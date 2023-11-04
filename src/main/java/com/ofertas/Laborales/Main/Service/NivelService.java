package com.ofertas.Laborales.Main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofertas.Laborales.Main.Modelo.Nivel;
import com.ofertas.Laborales.Main.Repo.NivelRepository;

@Service
public class NivelService {

	private final NivelRepository nivelRepository;

	@Autowired
	public NivelService(NivelRepository nivelRepository) {
		this.nivelRepository = nivelRepository;
	}

	public List<Nivel> getAllNiveles() {
		return nivelRepository.findAll();
	}

	public Optional<Nivel> getNivelById(Long id) {
		return nivelRepository.findById(id);
	}

	public Nivel saveNivel(Nivel nivel) {
		return nivelRepository.save(nivel);
	}

	public void deleteNivel(Long id) {
		nivelRepository.deleteById(id);
	}
}
