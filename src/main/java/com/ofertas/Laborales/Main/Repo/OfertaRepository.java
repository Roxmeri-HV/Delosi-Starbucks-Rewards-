package com.ofertas.Laborales.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofertas.Laborales.Main.Modelo.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
	Oferta findById(String id);
}
