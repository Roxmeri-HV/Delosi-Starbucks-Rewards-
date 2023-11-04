package com.ofertas.Laborales.Main.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ofertas")
public class Oferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombreOferta;

	@Column(nullable = false)
	private String idEmpresa;

	@Column(nullable = false)
	private String fechaPublicacion;
	
	@Column(nullable = false)
	private String fechaVencimiento;

	@Column(nullable = false)
	private String descripcion;	
	
	@Column(nullable = false)
	private String detalle;

	@Column(nullable = false)
	private String requisitos;

	@Column(nullable = false)
	private String salario;

	@Column(nullable = false)
	private String departamento;

	@Column(nullable = false)
	private String distrito;
	
	@Column(nullable = false)
	private String area;
	
	@Column(nullable = false)
	private String modalidadTrabajo;
	
	//@Column(nullable = false)
	//private String niveLaboral;
	
	//agregado para unir la columna a nivel
	@ManyToOne
    @JoinColumn(name = "nivel_id")
    private Nivel nivel;	
	
	public Oferta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreOferta() {
		return nombreOferta;
	}

	public void setNombreOferta(String nombreOferta) {
		this.nombreOferta = nombreOferta;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getModalidadTrabajo() {
		return modalidadTrabajo;
	}

	public void setModalidadTrabajo(String modalidadTrabajo) {
		this.modalidadTrabajo = modalidadTrabajo;
	}
/*
	public String getNiveLaboral() {
		return niveLaboral;
	}

	public void setNiveLaboral(String niveLaboral) {
		this.niveLaboral = niveLaboral;
	}
*/
	//agregado para unir la columna a nivel
	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}	
	
}
