package com.ofertas.Laborales.Main.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofertas.Laborales.Main.Modelo.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	Empleado findById(String id);

}
