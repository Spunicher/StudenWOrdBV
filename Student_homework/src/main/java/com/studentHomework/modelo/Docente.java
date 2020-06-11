package com.studentHomework.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_docente")
	private int idDocente;

	private String apellido_Dct;

	private String contrasena;

	private String direccion;

	private String dui;

	private int edad;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String nombre_Dct;

	private String telefono;

	private String turno;

	public Docente() {
	}

	public int getIdDocente() {
		return this.idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getApellido_Dct() {
		return this.apellido_Dct;
	}

	public void setApellido_Dct(String apellido_Dct) {
		this.apellido_Dct = apellido_Dct;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDui() {
		return this.dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre_Dct() {
		return this.nombre_Dct;
	}

	public void setNombre_Dct(String nombre_Dct) {
		this.nombre_Dct = nombre_Dct;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTurno() {
		return this.turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}