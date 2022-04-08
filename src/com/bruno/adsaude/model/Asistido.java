package com.bruno.adsaude.model;

public class Asistido extends UsuarioDTO{
	
	public static final int TIPO = 20; 
	
	
	private Integer idMedico;
	private Integer idLocalidad;
	
	
	public Asistido() {
		setTipo(TIPO);
	}


	public Integer getIdMedico() {
		return idMedico;
	}


	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}


	public Integer getIdLocalidad() {
		return idLocalidad;
	}


	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	
}
