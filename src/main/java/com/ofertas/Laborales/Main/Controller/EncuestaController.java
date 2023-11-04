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

import com.ofertas.Laborales.Main.Modelo.Encuesta;
import com.ofertas.Laborales.Main.Service.EncuestaService;

@Controller
@RequestMapping("/encuestas")
public class EncuestaController {

	private final EncuestaService encuestaService;

	@Autowired
	public EncuestaController(EncuestaService encuestaService) {
		this.encuestaService = encuestaService;
	}

	@GetMapping
	public String getAllEncuestas(Model model) {
		model.addAttribute("encuestas", encuestaService.getAllEncuestas());
		return "encuestaList";
	}

	@GetMapping("/create")
	public String createEncuestaForm(Model model) {
		model.addAttribute("encuesta", new Encuesta());
		return "createEncuesta";
	}

	@PostMapping("/create")
	public String createEncuesta(@ModelAttribute("encuesta") Encuesta encuesta) {
		encuestaService.saveEncuesta(encuesta);
		return "redirect:/encuestas";
	}

	@GetMapping("/update/{id}")
	public String updateEncuestaForm(@PathVariable Long id, Model model) {
		Optional<Encuesta> encuesta = encuestaService.getEncuestaById(id);
		if (encuesta.isPresent()) {
			model.addAttribute("encuesta", encuesta.get());
			return "updateEncuesta";
		} else {
			return "redirect:/encuestas";
		}
	}

	@PostMapping("/update/{id}")
	public String updateEncuestas(@PathVariable Long id, @ModelAttribute("encuesta") Encuesta encuesta) {
		Optional<Encuesta> existingEncuesta = encuestaService.getEncuestaById(id);
		if (existingEncuesta.isPresent()) {
			encuesta.setId(id);
			encuestaService.saveEncuesta(encuesta);
		}
		return "redirect:/encuestas";
	}

	@GetMapping("/delete/{id}")
	public String deleteEncuesta(@PathVariable Long id) {
		encuestaService.deleteEncuesta(id);
		return "redirect:/encuestas";
	}

}
