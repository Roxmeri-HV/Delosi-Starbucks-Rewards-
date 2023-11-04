package com.ofertas.Laborales.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofertas.Laborales.Main.Modelo.Comunicado;

public interface ComunicadoRepository extends JpaRepository<Comunicado, Long> {
	Comunicado findById(String id);
}
