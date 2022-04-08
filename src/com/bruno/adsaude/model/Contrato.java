package com.bruno.adsaude.model;

import java.util.Date;

public class Contrato extends AbstractValueObject{
	
	private Integer idContrato;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer idAsistido;

	public Contrato () {
		
	}

	public Integer getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Integer idContrato) {
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
	
}
