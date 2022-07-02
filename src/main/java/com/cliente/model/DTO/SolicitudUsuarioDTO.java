package com.cliente.model.DTO;

import java.io.Serializable;

public class SolicitudUsuarioDTO implements Serializable{
	
	private int codigo;
	private int tipoSolicitud;
	private int aplicacion;
	private int categoria;
	private String prioridad;
	private String fechaRegistro;
	private String descripcion;
	private int persona;
	
	public SolicitudUsuarioDTO() {
		
	}
	
	
	public SolicitudUsuarioDTO(int codigo, int tipoSolicitud, int aplicacion, int categoria, String prioridad,
			String fechaRegistro, String descripcion, int persona) {
		super();
		this.codigo = codigo;
		this.tipoSolicitud = tipoSolicitud;
		this.aplicacion = aplicacion;
		this.categoria = categoria;
		this.prioridad = prioridad;
		this.fechaRegistro = fechaRegistro;
		this.descripcion = descripcion;
		this.persona= persona;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(int tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	public int getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(int aplicacion) {
		this.aplicacion = aplicacion;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getPersona() {
		return persona;
	}


	public void setPersona(int persona) {
		this.persona = persona;
	}
	
	
	
	
	
	

}
