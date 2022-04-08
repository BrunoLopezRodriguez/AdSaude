package com.bruno.adsaude.model;

public class Ruta extends AbstractValueObject{
	
	private int id;
	private String descripcion;
	private String diaSemana;
	private int idEmpleao;
	
	
	public Ruta() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getDiaSemana() {
		return diaSemana;
	}


	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}


	public int getIdEmpleao() {
		return idEmpleao;
	}


	public void setIdEmpleao(int idEmpleao) {
		this.idEmpleao = idEmpleao;
	}
	

}
