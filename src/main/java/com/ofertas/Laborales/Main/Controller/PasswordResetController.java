package com.ofertas.Laborales.Main.Controller;



import java.sql.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ofertas.Laborales.Main.Modelo.PasswordResetToken;
import com.ofertas.Laborales.Main.Modelo.User;
import com.ofertas.Laborales.Main.Repo.PasswordResetTokenRepository;
import com.ofertas.Laborales.Main.Repo.UserRepository;

@Controller

public class PasswordResetController {

	private final UserRepository userRepository;
	private final PasswordResetTokenRepository passwordResetTokenRepository;
	private final JavaMailSender mailSender;

	@Autowired
	public PasswordResetController(UserRepository userRepository,
			PasswordResetTokenRepository passwordResetTokenRepository, JavaMailSender mailSender) {
		this.userRepository = userRepository;
		this.passwordResetTokenRepository = passwordResetTokenRepository;
		this.mailSender = mailSender;
	}

	@GetMapping("/reset-password")
	public String showResetPasswordForm() {
		return "reset_password";
	}

	@PostMapping("/reset-password")
	public String resetPassword(@RequestParam String email, Model model) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			String token = UUID.randomUUID().toString();
			PasswordResetToken passwordResetToken = new PasswordResetToken();
			passwordResetToken.setToken(token);
			passwordResetToken.setUser(user);
			passwordResetToken.setExpiryDate(new Date(System.currentTimeMillis() + 86400000)); // Set expiry to 24 hours
																								// from now
			passwordResetTokenRepository.save(passwordResetToken);

			String resetPasswordLink = "http://localhost:9095/reset-password/token/" + token;

			// Send the reset password email
			sendResetPasswordEmail(user.getEmail(), resetPasswordLink);

			model.addAttribute("message", "Password reset link sent to your email address.");
		} else {
			model.addAttribute("error", "User with the provided email does not exist.");
		}
		return "reset_password";
	}

	@GetMapping("/reset-password/token/{token}")
	public String showPasswordResetForm(@PathVariable String token, Model model) {
		PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
		if (passwordResetToken != null && passwordResetToken.getExpiryDate().after(new Date(0))) {
			model.addAttribute("token", token);
			return "password_reset_form";
		} else {
			model.addAttribute("error", "Invalid or expired password reset token.");
			return "reset_password";
		}
	}

	@PostMapping("/reset-password/token/{token}")
	public String resetPasswordWithToken(@PathVariable String token, @RequestParam String password, Model model) {
		PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
		if (passwordResetToken != null && passwordResetToken.getExpiryDate().after(new Date(0))) {
			User user = passwordResetToken.getUser();
			user.setPassword(password);
			userRepository.save(user);
			passwordResetTokenRepository.delete(passwordResetToken);
			model.addAttribute("message", "Password reset successful. You can now login with your new password.");
			return "login";
		} else {
			model.addAttribute("error", "Invalid or expired password reset token.");
			return "reset_password";
		}
	}

	private void sendResetPasswordEmail(String to, String resetPasswordLink) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Password Reset");
		message.setText("Click the following link to reset your password: " + resetPasswordLink);

		mailSender.send(message);
	}

}
