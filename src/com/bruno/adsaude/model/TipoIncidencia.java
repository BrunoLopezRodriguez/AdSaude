package com.bruno.adsaude.model;

public class TipoIncidencia extends AbstractValueObject{
	
	public static final Integer ENVIADA = 1;
	public static final Integer RECHAZADA = 2;
	
	private int id;
	private String nombre;
	
	
	public TipoIncidencia() {		
	}
	
	
	public TipoIncidencia(Integer id) {
		setId(id);
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
