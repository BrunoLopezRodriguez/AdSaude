package com.bruno.adsaude.model;

import java.util.Date;

public class Asistencia extends AbstractValueObject{

	private Date fechaHoraInicio;
	private Date fechaHoraFin;
	private Integer idAsistido;
	private Integer idTipoServicio;
	private Integer idEmpleado;
	
	public Asistencia() {
		
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

	public Integer getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(Integer idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
}
