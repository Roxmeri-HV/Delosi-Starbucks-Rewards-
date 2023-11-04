package com.ofertas.Laborales.Main.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String catRubro;

	@Column(nullable = false)
	private String ruc;

	@Column(nullable = false)
	private String razonSocial;

	@Column(nullable = false)
	private String nomSurcursal;

	@Column(nullable = false)
	private String dirComercial;

	@Column(nullable = false)
	private String telefono;

	@Column(nullable = false)
	private String cantEmpleado;

	public Empresa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCatRubro() {
		return catRubro;
	}

	public void setCatRubro(String catRubro) {
		this.catRubro = catRubro;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNomSurcursal() {
		return nomSurcursal;
	}

	public void setNomSurcursal(String nomSurcursal) {
		this.nomSurcursal = nomSurcursal;
	}

	public String getDirComercial() {
		return dirComercial;
	}

	public void setDirComercial(String dirComercial) {
		this.dirComercial = dirComercial;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCantEmpleado() {
		return cantEmpleado;
	}

	public void setCantEmpleado(String cantEmpleado) {
		this.cantEmpleado = cantEmpleado;
	}

}
