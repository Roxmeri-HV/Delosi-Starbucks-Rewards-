package com.ofertas.Laborales.Main.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ofertas.Laborales.Main.Modelo.User;
import com.ofertas.Laborales.Main.Service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "userList";
	}

	@GetMapping("/create")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		return "createUser";
	}

	@PostMapping("/create")
	public String createUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping("/update/{id}")
	public String updateUserForm(@PathVariable Long id, Model model) {
		Optional<User> user = userService.getUserById(id);
		if (user.isPresent()) {
			model.addAttribute("user", user.get());
			return "updateUser";
		} else {
			return "redirect:/users";
		}
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
		Optional<User> existingUser = userService.getUserById(id);
		if (existingUser.isPresent()) {
			user.setId(id);
			userService.saveUser(user);
		}
		return "redirect:/users";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}

}
