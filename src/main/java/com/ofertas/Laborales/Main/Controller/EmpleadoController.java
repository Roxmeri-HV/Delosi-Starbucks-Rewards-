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

import com.ofertas.Laborales.Main.Modelo.Empleado;
import com.ofertas.Laborales.Main.Service.EmpleadoService;


@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	
	private final EmpleadoService empleadoService;

	@Autowired
	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

	@GetMapping
	public String getAllEmpleado(Model model) {
		model.addAttribute("empleados", empleadoService.getAllEmpleados());
		return "empleadoList";
	}

	@GetMapping("/create")
	public String createEmpleadoForm(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "createEmpleado";
	}

	@PostMapping("/create")
	public String createEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		empleadoService.saveEmpleado(empleado);
		return "redirect:/empleados";
	}

	@GetMapping("/update/{id}")
	public String updateEmpleadoForm(@PathVariable Long id, Model model) {
		Optional<Empleado> empleado = empleadoService.getEmpleadoById(id);
		if (empleado.isPresent()) {
			model.addAttribute("empleado", empleado.get());
			return "updateEmpleado";
		} else {
			return "redirect:/empleados";
		}
	}

	@PostMapping("/update/{id}")
	public String updateEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado) {
		Optional<Empleado> existingEmpleado = empleadoService.getEmpleadoById(id);
		if (existingEmpleado.isPresent()) {
			empleado.setId(id);
			empleadoService.saveEmpleado(empleado);
		}
		return "redirect:/empleados";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmpleado(@PathVariable Long id) {
		empleadoService.deleteEmpleado(id);
		return "redirect:/empleados";
	}


}
