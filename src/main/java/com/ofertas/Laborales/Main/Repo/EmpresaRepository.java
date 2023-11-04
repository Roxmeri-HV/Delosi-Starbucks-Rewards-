package com.ofertas.Laborales.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofertas.Laborales.Main.Modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	Empresa findById(String id);
}
