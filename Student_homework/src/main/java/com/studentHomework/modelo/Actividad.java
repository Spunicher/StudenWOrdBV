package com.studentHomework.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id_codAct;

	private String estado;

	private String nombre;

	private BigDecimal poncentaje;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="cod_Mate")
	private Materia materia;

	public Actividad() {
	}

	public int getId_codAct() {
		return this.id_codAct;
	}

	public void setId_codAct(int id_codAct) {
		this.id_codAct = id_codAct;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPoncentaje() {
		return this.poncentaje;
	}

	public void setPoncentaje(BigDecimal poncentaje) {
		this.poncentaje = poncentaje;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}