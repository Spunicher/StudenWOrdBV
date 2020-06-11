package com.studentHomework.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mtr")
	private int idMtr;

	private int cod_Gra;

	private int cod_Sec;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="materia")
	private List<Actividad> actividads;

	public Materia() {
	}

	public int getIdMtr() {
		return this.idMtr;
	}

	public void setIdMtr(int idMtr) {
		this.idMtr = idMtr;
	}

	public int getCod_Gra() {
		return this.cod_Gra;
	}

	public void setCod_Gra(int cod_Gra) {
		this.cod_Gra = cod_Gra;
	}

	public int getCod_Sec() {
		return this.cod_Sec;
	}

	public void setCod_Sec(int cod_Sec) {
		this.cod_Sec = cod_Sec;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(List<Actividad> actividads) {
		this.actividads = actividads;
	}

	public Actividad addActividad(Actividad actividad) {
		getActividads().add(actividad);
		actividad.setMateria(this);

		return actividad;
	}

	public Actividad removeActividad(Actividad actividad) {
		getActividads().remove(actividad);
		actividad.setMateria(null);

		return actividad;
	}

}