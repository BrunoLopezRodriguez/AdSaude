package com.bruno.adsaude.model;



public class AsistidoDTO extends UsuarioDTO{

	public static final int TIPO = 10; 

	private Integer idMedico;
	private String nombreMedico;
	private Integer idLocalidad;
	private String nombreLocalidad;

	

	public AsistidoDTO() {	
		setTipo(TIPO);
	}

	public Integer getIdMedico() {
		return idMedico;
	}



	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}



	public String getNombreMedico() {
		return nombreMedico;
	}



	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}



	public Integer getIdLocalidad() {
		return idLocalidad;
	}



	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}



	public String getNombreLocalidad() {
		return nombreLocalidad;
	}



	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}



	

}
