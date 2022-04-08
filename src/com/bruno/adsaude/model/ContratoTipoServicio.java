package com.bruno.adsaude.model;

public class ContratoTipoServicio extends AbstractValueObject{
	
	
	private Integer idContrato;
	private int idTipoServicio;
	private String descripcion;
	
	
	public ContratoTipoServicio() {
		
	}


	public Integer getIdContrato() {
		return idContrato;
	}


	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}


	public int getIdTipoServicio() {
		return idTipoServicio;
	}


	public void setIdTipoServicio(int idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
