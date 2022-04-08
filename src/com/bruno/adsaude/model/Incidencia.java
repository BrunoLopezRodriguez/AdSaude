package com.bruno.adsaude.model;

import java.util.Date;

public class Incidencia extends AbstractValueObject{

	private int id;
	private String resumen;
	private String descripcion;
	private Date fechaHora;
	private int idTipoEstadoIncidencia;
	private int idTipoIncidencia;
	private Integer idFamiliar;
	private Integer idAsistido;
	private Integer idEmpleado;
	private int idAsistidoAfectado;
	
	
	public Incidencia() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public int getIdTipoEstadoIncidencia() {
		return idTipoEstadoIncidencia;
	}
	public void setIdTipoEstadoIncidencia(int idTipoEstadoIncidencia) {
		this.idTipoEstadoIncidencia = idTipoEstadoIncidencia;
	}
	public int getIdTipoIncidencia() {
		return idTipoIncidencia;
	}
	public void setIdTipoIncidencia(int idTipoIncidencia) {
		this.idTipoIncidencia = idTipoIncidencia;
	}
	public Integer getIdFamiliar() {
		return idFamiliar;
	}
	public void setIdFamiliar(Integer idFamiliar) {
		this.idFamiliar = idFamiliar;
	}
	public Integer getIdAsistido() {
		return idAsistido;
	}
	public void setIdAsistido(Integer idAsistido) {
		this.idAsistido = idAsistido;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdAsistidoAfectado() {
		return idAsistidoAfectado;
	}
	public void setIdAsistidoAfectado(int idAsistidoAfectado) {
		this.idAsistidoAfectado = idAsistidoAfectado;
	}
}
