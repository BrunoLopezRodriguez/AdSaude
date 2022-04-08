package com.bruno.adsaude.model;

public class MedicoDTO extends UsuarioDTO{
	
	public static final int TIPO = 70; 
	
	private int idLocalidad;
	private String nombreLocalidad;
	
	
	public MedicoDTO() {
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
