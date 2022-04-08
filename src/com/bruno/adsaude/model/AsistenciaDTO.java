package com.bruno.adsaude.model;

import java.util.Date;

public class AsistenciaDTO extends AbstractValueObject{
	
	
	private Date fechaHoraInicio;
	private Date fechaHoraFin;
	private Integer idAsistido;
	private String nombreAsistido;
	private Integer idServicio;
	private String nombreServicio;
	private Integer idEmpleado;
	private String nombreEmpleado;

	public AsistenciaDTO() {
		
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

	public String getNombreAsistido() {
		return nombreAsistido;
	}

	public void setNombreAsistido(String nombreAsistido) {
		this.nombreAsistido = nombreAsistido;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	
	
}
