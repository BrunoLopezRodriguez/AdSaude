package com.bruno.adsaude.model;

public class IncidenciaDTO extends AbstractValueObject{
	
	private int id;
	private String resumen;
	private String descripcion;
	private String fechaHora;
	private int idTipoEstadoIncidencia;
	private String nombreTipoEstadoIncidencia;
	private int idTipoIncidencia;
	private String nombreTipoIncidencia;
	private Integer idFamiliar;
	private String nombreFamiliar;
	private Integer idAsistido;
	private String nombreAsistido;
	private Integer idEmpleado;
	private String nombreEmpleado;
	private int idAsistidoAfectado;
	private String nombreAsistidoAfectado;
	
	
	public IncidenciaDTO() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getResumen() {
		return resumen;
	}


	public void setResumen(String resumen) {
		this.resumen = resumen;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}


	public int getIdTipoEstadoIncidencia() {
		return idTipoEstadoIncidencia;
	}


	public void setIdTipoEstadoIncidencia(int idTipoEstadoIncidencia) {
		this.idTipoEstadoIncidencia = idTipoEstadoIncidencia;
	}


	public String getNombreTipoEstadoIncidencia() {
		return nombreTipoEstadoIncidencia;
	}


	public void setNombreTipoEstadoIncidencia(String nombreTipoEstadoIncidencia) {
		this.nombreTipoEstadoIncidencia = nombreTipoEstadoIncidencia;
	}


	public int getIdTipoIncidencia() {
		return idTipoIncidencia;
	}


	public void setIdTipoIncidencia(int idTipoIncidencia) {
		this.idTipoIncidencia = idTipoIncidencia;
	}


	public String getNombreTipoIncidencia() {
		return nombreTipoIncidencia;
	}


	public void setNombreTipoIncidencia(String nombreTipoIncidencia) {
		this.nombreTipoIncidencia = nombreTipoIncidencia;
	}


	public Integer getIdFamiliar() {
		return idFamiliar;
	}


	public void setIdFamiliar(Integer idFamiliar) {
		this.idFamiliar = idFamiliar;
	}


	public String getNombreFamiliar() {
		return nombreFamiliar;
	}


	public void setNombreFamiliar(String nombreFamiliar) {
		this.nombreFamiliar = nombreFamiliar;
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


	public int getIdAsistidoAfectado() {
		return idAsistidoAfectado;
	}


	public void setIdAsistidoAfectado(int idAsistidoAfectado) {
		this.idAsistidoAfectado = idAsistidoAfectado;
	}


	public String getNombreAsistidoAfectado() {
		return nombreAsistidoAfectado;
	}


	public void setNombreAsistidoAfectado(String nombreAsistidoAfectado) {
		this.nombreAsistidoAfectado = nombreAsistidoAfectado;
	}

	
}