package com.bruno.adsaude.model;

public class Pais extends AbstractValueObject{
	
	private int id;
	private String nombre;
	
	
	
	
	public Pais() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
