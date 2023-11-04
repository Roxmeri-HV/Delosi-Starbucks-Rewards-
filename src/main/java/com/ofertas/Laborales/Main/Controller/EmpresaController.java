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

import com.ofertas.Laborales.Main.Modelo.Empresa;
import com.ofertas.Laborales.Main.Service.EmpresaService;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

	private final EmpresaService empresaService;

	@Autowired
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@GetMapping
	public String getAllEmpresas(Model model) {
		model.addAttribute("empresas", empresaService.getAllEmpresas());
		return "empresaList";
	}

	@GetMapping("/create")
	public String createEmpresaForm(Model model) {
		model.addAttribute("empresa", new Empresa());
		return "createEmpresa";
	}

	@PostMapping("/create")
	public String createEmpresa(@ModelAttribute("empresa") Empresa empresa) {
		empresaService.saveEmpresa(empresa);
		return "redirect:/empresas";
	}

	@GetMapping("/update/{id}")
	public String updateEmpresaForm(@PathVariable Long id, Model model) {
		Optional<Empresa> empresa = empresaService.getEmpresaById(id);
		if (empresa.isPresent()) {
			model.addAttribute("empresa", empresa.get());
			return "updateEmpresa";
		} else {
			return "redirect:/empresas";
		}
	}

	@PostMapping("/update/{id}")
	public String updateEmpresa(@PathVariable Long id, @ModelAttribute("empresa") Empresa empresa) {
		Optional<Empresa> existingEmpresa = empresaService.getEmpresaById(id);
		if (existingEmpresa.isPresent()) {
			empresa.setId(id);
			empresaService.saveEmpresa(empresa);
		}
		return "redirect:/empresas";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmpresa(@PathVariable Long id) {
		empresaService.deleteEmpresa(id);
		return "redirect:/empresas";
	}

}
