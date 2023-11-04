package com.ofertas.Laborales.Main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofertas.Laborales.Main.Modelo.Comunicado;
import com.ofertas.Laborales.Main.Repo.ComunicadoRepository;

@Service
public class ComunicadoService {

	private final ComunicadoRepository comunicadoRepository;

	@Autowired
	public ComunicadoService(ComunicadoRepository comunicadoRepository) {
		this.comunicadoRepository = comunicadoRepository;
	}

	public List<Comunicado> getAllComunicados() {
		return comunicadoRepository.findAll();
	}

	public Optional<Comunicado> getComunicadoById(Long id) {
		return comunicadoRepository.findById(id);
	}

	public Comunicado saveComunicado(Comunicado comunicado) {
		return comunicadoRepository.save(comunicado);
	}

	public void deleteComunicado(Long id) {
		comunicadoRepository.deleteById(id);
	}
}
