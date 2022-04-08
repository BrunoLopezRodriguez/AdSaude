package com.bruno.adsaude.model;

public class RutaAsistido extends AbstractValueObject{
	
	private int idAsistido;
	private int idRuta;
	private String numeroOrden;

	
	public RutaAsistido() {
		
	}


	public int getIdAsistido() {
		return idAsistido;
	}


	public void setIdAsistido(int idAsistido) {
		this.idAsistido = idAsistido;
	}


	public int getIdRuta() {
		return idRuta;
	}


	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}


	public String getNumeroOrden() {
		return numeroOrden;
	}


	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
}
