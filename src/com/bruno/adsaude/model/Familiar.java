package com.bruno.adsaude.model;

public class Familiar extends UsuarioDTO{
	
	public static final int TIPO = 60; 
	
	
	private Integer idLocalidad;
	
	
	public Familiar() {
		setTipo(TIPO);
	}
	
	
	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	

}
