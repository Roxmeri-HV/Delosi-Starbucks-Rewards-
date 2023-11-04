package com.ofertas.Laborales.Main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofertas.Laborales.Main.Modelo.Oferta;
import com.ofertas.Laborales.Main.Repo.OfertaRepository;

@Service
public class OfertaService {

	private final OfertaRepository ofertaRepository;

	@Autowired
	public OfertaService(OfertaRepository ofertaRepository) {
		this.ofertaRepository = ofertaRepository;
	}

	public List<Oferta> getAllOfertas() {
		return ofertaRepository.findAll();
	}

	public Optional<Oferta> getOfertaById(Long id) {
		return ofertaRepository.findById(id);
	}

	public Oferta saveOferta(Oferta oferta) {
		return ofertaRepository.save(oferta);
	}

	public void deleteOferta(Long id) {
		ofertaRepository.deleteById(id);
	}
}
