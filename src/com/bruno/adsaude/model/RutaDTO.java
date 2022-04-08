package com.bruno.adsaude.model;

public class RutaDTO extends AbstractValueObject{

	private int id;
	private String descripcion;
	private String diaSemana;
	private Integer idEmpleado;
	private String nombreEmpleado;
	private int numeroOrden;
	private Integer idAsistido;
	private String nombreAsistido;
	private String direccionAsistido;
	
	
	public RutaDTO() {
		
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


	public Integer getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public String getNombreEmpleado() {
		return nombreEmpleado;
	}


	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}


	public int getNumeroOrden() {
		return numeroOrden;
	}


	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}


	public Integer getIdAsistido() {
		return idAsistido;
	}


	public void setIdAsistido(Integer idAsistido) {
		this.idAsistido = idAsistido;
	}


	public String getNombreAsistido() {
		return nombreAsistido;
	}


	public void setNombreAsistido(String nombreAsistido) {
		this.nombreAsistido = nombreAsistido;
	}


	public String getDireccionAsistido() {
		return direccionAsistido;
	}


	public void setDireccionAsistido(String direccionAsistido) {
		this.direccionAsistido = direccionAsistido;
	}


}
