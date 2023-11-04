package com.ofertas.Laborales.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofertas.Laborales.Main.Modelo.Nivel;

public interface NivelRepository extends JpaRepository<Nivel, Long> {
	Nivel findById(String id);
}
