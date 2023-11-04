package com.ofertas.Laborales.Main.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.ofertas.Laborales.Main.Modelo.Nivel;
import com.ofertas.Laborales.Main.Service.NivelService;

@Controller
//@RequestMapping("/niveles")
public class NivelController {

	private final NivelService nivelService;

	@Autowired
	public NivelController(NivelService nivelService) {
		this.nivelService = nivelService;
	}
    @GetMapping("/niveles")
    public String showNiveles1(Model model) {
        List<Nivel> niveles = nivelService.getAllNiveles();
        model.addAttribute("niveles", niveles);
        return "niveles";
    }	

    @GetMapping("/createOferta")
    public String showNiveles(Model model) {
        List<Nivel> listaniveles = nivelService.getAllNiveles();
        model.addAttribute("listaniveles", listaniveles);
        return "createOferta";
    }    
    
	/*
	@GetMapping
	public String getAllNiveles(Model model) {
		model.addAttribute("niveles", nivelService.getAllNiveles());
		return "ofertaList";
	}

	@GetMapping("/create")
	public String createNivelForm(Model model) {
		model.addAttribute("nivel", new Nivel());
		return "createNivel";
	}

	@PostMapping("/create")
	public String createNivel(@ModelAttribute("nivel") Nivel nivel) {
		nivelService.saveNivel(nivel);
		return "redirect:/niveles";
	}

	@GetMapping("/update/{id}")
	public String updateNivelForm(@PathVariable Long id, Model model) {
		Optional<Nivel> nivel = nivelService.getNivelById(id);
		if (nivel.isPresent()) {
			model.addAttribute("nivel", nivel.get());
			return "updateNivel";
		} else {
			return "redirect:/niveles";
		}
	}

	@PostMapping("/update/{id}")
	public String updateNivel(@PathVariable Long id, @ModelAttribute("nivel") Nivel nivel) {
		Optional<Nivel> existingNivel = nivelService.getNivelById(id);
		if (existingNivel.isPresent()) {
			nivel.setId(id);
			nivelService.saveNivel(nivel);
		}
		return "redirect:/niveles";
	}

	@GetMapping("/delete/{id}")
	public String deleteNivel(@PathVariable Long id) {
		nivelService.deleteNivel(id);
		return "redirect:/niveles";
	}
	*/	
}
