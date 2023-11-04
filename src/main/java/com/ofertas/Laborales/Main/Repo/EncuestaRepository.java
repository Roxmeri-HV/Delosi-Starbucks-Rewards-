package com.ofertas.Laborales.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofertas.Laborales.Main.Modelo.Encuesta;

public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {
	Encuesta findById(String id);
}
