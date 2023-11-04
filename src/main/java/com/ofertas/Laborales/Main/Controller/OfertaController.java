package com.ofertas.Laborales.Main.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ofertas.Laborales.Main.Modelo.Nivel;
import com.ofertas.Laborales.Main.Modelo.Oferta;
import com.ofertas.Laborales.Main.Service.NivelService;
import com.ofertas.Laborales.Main.Service.OfertaService;


@Controller
@RequestMapping("/ofertas")
public class OfertaController {

	private final OfertaService ofertaService;
	//agregado para unir la columna a nivel
	private final NivelService nivelservice;

	@Autowired
	public OfertaController(OfertaService ofertaService, NivelService nivelservice) {
		this.ofertaService = ofertaService;
		//agregado para unir la columna a nivel
		this.nivelservice = nivelservice;
	}

	@GetMapping
	public String getAllOfertas(Model model) {
		model.addAttribute("ofertas", ofertaService.getAllOfertas());
		return "ofertaList";
	}

	@GetMapping("/create")
	public String createOfertaForm(Model model) {
		model.addAttribute("oferta", new Oferta());
		//agregado para unir la columna a nivel
        List<Nivel> niveles = nivelservice.getAllNiveles();
        model.addAttribute("niveles", niveles);
		return "createOferta";
	}

	@PostMapping("/create")
	public String createOferta(@ModelAttribute("oferta") Oferta oferta) {
		ofertaService.saveOferta(oferta);
		return "redirect:/ofertas";
	}

	@GetMapping("/update/{id}")
	public String updateOfertaForm(@PathVariable Long id, Model model) {
		Optional<Oferta> oferta = ofertaService.getOfertaById(id);
		if (oferta.isPresent()) {
			model.addAttribute("oferta", oferta.get());
			//agregado para unir la columna a nivel
	        List<Nivel> niveles = nivelservice.getAllNiveles();
	        model.addAttribute("niveles", niveles);			
			return "updateOferta";
		} else {
			return "redirect:/ofertas";
		}
	}

	@PostMapping("/update/{id}")
	public String updateOferta(@PathVariable Long id, @ModelAttribute("oferta") Oferta oferta) {
		Optional<Oferta> existingOferta = ofertaService.getOfertaById(id);
		if (existingOferta.isPresent()) {
			oferta.setId(id);
			ofertaService.saveOferta(oferta);
		}
		return "redirect:/ofertas";
	}

	@GetMapping("/delete/{id}")
	public String deleteOferta(@PathVariable Long id) {
		ofertaService.deleteOferta(id);
		return "redirect:/ofertas";
	}	
}
