package com.ofertas.Laborales.Main.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "encuesta")
public class Encuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String tipoencuesta;

	@Column(nullable = false)
	private String Preg01;

	@Column(nullable = false)
	private String Preg02;

	@Column(nullable = false)
	private String Preg03;

	@Column(nullable = false)
	private String Preg04;

	@Column(nullable = false)
	private String Preg05;

	public Encuesta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoencuesta() {
		return tipoencuesta;
	}

	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}

	public String getPreg01() {
		return Preg01;
	}

	public void setPreg01(String preg01) {
		Preg01 = preg01;
	}

	public String getPreg02() {
		return Preg02;
	}

	public void setPreg02(String preg02) {
		Preg02 = preg02;
	}

	public String getPreg03() {
		return Preg03;
	}

	public void setPreg03(String preg03) {
		Preg03 = preg03;
	}

	public String getPreg04() {
		return Preg04;
	}

	public void setPreg04(String preg04) {
		Preg04 = preg04;
	}

	public String getPreg05() {
		return Preg05;
	}

	public void setPreg05(String preg05) {
		Preg05 = preg05;
	}

}
