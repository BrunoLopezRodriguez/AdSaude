package com.bruno.adsaude.model;

public class Empleado extends UsuarioDTO{
	
	public static final int TIPO = 40; 
	
	
	private Integer idTipoEmpleado;
	private Integer idLocalidad;
	
	
	public Empleado() {
		setTipo(TIPO);
	}


	public Integer getIdTipoEmpleado() {
		return idTipoEmpleado;
	}


	public void setIdTipoEmpleado(Integer idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}


	public Integer getIdLocalidad() {
		return idLocalidad;
	}


	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	

}
