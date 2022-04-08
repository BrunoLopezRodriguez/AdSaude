package com.bruno.adsaude.model;

import java.util.Date;

public class ContratoDTO extends AbstractValueObject{
	
	private int idContrato;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer idAsistido;
	private String nombreAsistido;
	private String descripcionNecesidad;
	private Integer idTipoServicio;
	private String nombreTipoServicio;
	
	public ContratoDTO() {
		
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getIdAsistido() {
		return idAsistido;
	}

	public void setIdAsistido(Integer idAsistido) {
		this.idAsistido = idAsistido;
	}

	public String getNombreAsistido() {
		return nombreAsistido;
	}

	public void setNombreAsistido(String nombreAsistido) {
		this.nombreAsistido = nombreAsistido;
	}

	public String getDescripcionNecesidad() {
		return descripcionNecesidad;
	}

	public void setDescripcionNecesidad(String descripcionNecesidad) {
		this.descripcionNecesidad = descripcionNecesidad;
	}

	public Integer getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(Integer idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public String getNombreTipoServicio() {
		return nombreTipoServicio;
	}

	public void setNombreTipoServicio(String nombreTipoServicio) {
		this.nombreTipoServicio = nombreTipoServicio;
	}

	
}
