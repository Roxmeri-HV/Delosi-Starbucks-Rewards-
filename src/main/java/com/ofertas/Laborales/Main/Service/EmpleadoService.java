package com.ofertas.Laborales.Main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofertas.Laborales.Main.Modelo.Empleado;
import com.ofertas.Laborales.Main.Repo.EmpleadoRepository;



@Service

public class EmpleadoService {

		private final EmpleadoRepository empleadoRepository;

		@Autowired
		public EmpleadoService(EmpleadoRepository empleadoRepository) {
			this.empleadoRepository = empleadoRepository;
		}

		public List<Empleado> getAllEmpleados() {
			return empleadoRepository.findAll();
		}

		public Optional<Empleado> getEmpleadoById(Long id) {
			return empleadoRepository.findById(id);
		}

		public Empleado saveEmpleado(Empleado empleado) {
			return empleadoRepository.save(empleado);
		}

		public void deleteEmpleado(Long id) {
			empleadoRepository.deleteById(id);
		}

	}

