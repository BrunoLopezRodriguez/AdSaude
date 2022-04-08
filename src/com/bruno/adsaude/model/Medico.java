package com.bruno.adsaude.model;

public class Medico extends UsuarioDTO{
	
	public static final int TIPO = 80; 
	
	
	private int idLocalidad;
	
	public Medico () {
		setTipo(TIPO);
	}


	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	
}
