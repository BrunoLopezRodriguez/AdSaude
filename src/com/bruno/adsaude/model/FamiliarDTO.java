package com.bruno.adsaude.model;

public class FamiliarDTO extends UsuarioDTO{
	
	public static final int TIPO = 50; 
	
	
	private int idLocalidad;
	private String nombreLocalidad;
	
	public FamiliarDTO() {
		setTipo(TIPO);
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}
	
	
	

}
