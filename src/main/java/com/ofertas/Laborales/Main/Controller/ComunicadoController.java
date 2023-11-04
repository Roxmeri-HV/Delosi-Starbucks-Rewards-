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

import com.ofertas.Laborales.Main.Modelo.Comunicado;
import com.ofertas.Laborales.Main.Service.ComunicadoService;


@Controller
@RequestMapping("/comunicados")
public class ComunicadoController {

	private final ComunicadoService comunicadoService;

	@Autowired
	public ComunicadoController(ComunicadoService comunicadoService) {
		this.comunicadoService = comunicadoService;
	}

	@GetMapping
	public String getAllComunicados(Model model) {
		model.addAttribute("comunicados", comunicadoService.getAllComunicados());
		return "comunicadoList";
	}

	@GetMapping("/create")
	public String createComunicadoForm(Model model) {
		model.addAttribute("comunicado", new Comunicado());
		return "createComunicado";
	}

	@PostMapping("/create")
	public String createComunicado(@ModelAttribute("comunicado") Comunicado comunicado) {
		comunicadoService.saveComunicado(comunicado);
		return "redirect:/comunicados";
	}

	@GetMapping("/update/{id}")
	public String updateComunicadoForm(@PathVariable Long id, Model model) {
		Optional<Comunicado> comunicado = comunicadoService.getComunicadoById(id);
		if (comunicado.isPresent()) {
			model.addAttribute("comunicado", comunicado.get());
			return "updateComunicado";
		} else {
			return "redirect:/comunicados";
		}
	}

	@PostMapping("/update/{id}")
	public String updateComunicado(@PathVariable Long id, @ModelAttribute("comunicado") Comunicado comunicado) {
		Optional<Comunicado> existingComunicado = comunicadoService.getComunicadoById(id);
		if (existingComunicado.isPresent()) {
			comunicado.setId(id);
			comunicadoService.saveComunicado(comunicado);
		}
		return "redirect:/comunicados";
	}

	@GetMapping("/delete/{id}")
	public String deleteOferta(@PathVariable Long id) {
		comunicadoService.deleteComunicado(id);
		return "redirect:/comunicados";
	}	
}
