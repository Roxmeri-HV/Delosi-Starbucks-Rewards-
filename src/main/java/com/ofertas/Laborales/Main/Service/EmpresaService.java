package com.ofertas.Laborales.Main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofertas.Laborales.Main.Modelo.Empresa;
import com.ofertas.Laborales.Main.Repo.EmpresaRepository;

@Service
public class EmpresaService {

	private final EmpresaRepository empresaRepository;

	@Autowired
	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public List<Empresa> getAllEmpresas() {
		return empresaRepository.findAll();
	}

	public Optional<Empresa> getEmpresaById(Long id) {
		return empresaRepository.findById(id);
	}

	public Empresa saveEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public void deleteEmpresa(Long id) {
		empresaRepository.deleteById(id);
	}

}
