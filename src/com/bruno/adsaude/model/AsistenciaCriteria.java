package com.bruno.adsaude.model;

import java.util.Date;

public class AsistenciaCriteria extends AbstractValueObject{
	
	private Date fechaHoraInicio;
	private Date fechaHoraFin;
	private Integer idAsistido;
	private Integer idServicio;
	private Integer idEmpleado;
	

	public AsistenciaCriteria() {
		
	}


	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}


	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}


	public Date getFechaHoraFin() {
		return fechaHoraFin;
	}


	public void setFechaHoraFin(Date fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}


	public Integer getIdAsistido() {
		return idAsistido;
	}


	public void setIdAsistido(Integer idAsistido) {
		this.idAsistido = idAsistido;
	}


	public Integer getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}


	public Integer getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
}
