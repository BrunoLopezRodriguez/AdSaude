package com.bruno.adsaude.model;

public class TipoServicioDTO extends AbstractValueObject{

	
	private int id;
	private String nombre;
	private String descripcion;
	private String tiempoEstimado;
	private Integer idTipoServicio;
	private Integer idPadre;
	private String nombrePadre;
	
	
	public TipoServicioDTO() {
		
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTiempoEstimado() {
		return tiempoEstimado;
	}
	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	
	public Integer getIdTipoServicio() {
		return idTipoServicio;
	}
	public void setIdTipoServicio(Integer idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}
	public Integer getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
	public String getNombrePadre() {
		return nombrePadre;
	}
	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}
	
}
