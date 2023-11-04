package com.ofertas.Laborales.Main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofertas.Laborales.Main.Modelo.Encuesta;
import com.ofertas.Laborales.Main.Repo.EncuestaRepository;

@Service
public class EncuestaService {

	private final EncuestaRepository encuestaRepository;

	@Autowired
	public EncuestaService(EncuestaRepository encuestaRepository) {
		this.encuestaRepository = encuestaRepository;
	}

	public List<Encuesta> getAllEncuestas() {
		return encuestaRepository.findAll();
	}

	public Optional<Encuesta> getEncuestaById(Long id) {
		return encuestaRepository.findById(id);
	}

	public Encuesta saveEncuesta(Encuesta encuesta) {
		return encuestaRepository.save(encuesta);
	}

	public void deleteEncuesta(Long id) {
		encuestaRepository.deleteById(id);
	}
}
