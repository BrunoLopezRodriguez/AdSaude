package com.bruno.adsaude.model;

public class EmpleadoDTO extends UsuarioDTO{
	
	public static final int TIPO = 30; 

	
	private int idTipoEmpleado;
	private String nombreTipoEmpleado;
	private int idLocalidad;
	private String nombreLocalidad;
	
	
	
	
	public EmpleadoDTO() {		
		setTipo(TIPO);
	}


	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}



	public void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}



	public String getNombreTipoEmpleado() {
		return nombreTipoEmpleado;
	}



	public void setNombreTipoEmpleado(String nombreTipoEmpleado) {
		this.nombreTipoEmpleado = nombreTipoEmpleado;
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
