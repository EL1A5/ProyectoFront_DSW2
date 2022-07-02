package com.cliente.model.DTO;

import java.io.Serializable;

public class SolicitudUserDTO implements Serializable {

	private int codigo;
	private String estado;
	private String fechaInicio;
	private String fechaFin;
	private String prioridad;
	private String aplicacion;
	private String tipoSolicitud;
	private String categoria;
	private String solicitud;
	private String solucion;	
	private String reg_nombres;
	private String reg_apellidos;
	
	public SolicitudUserDTO() {
		
	}  
	

	public SolicitudUserDTO(int codigo, String estado, String fechaInicio, String fechaFin, String prioridad,
			String aplicacion, String tipoSolicitud, String categoria) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.prioridad = prioridad;
		this.aplicacion = aplicacion;
		this.tipoSolicitud = tipoSolicitud;
		this.categoria = categoria;
	}

	public SolicitudUserDTO(int codigo, String estado, String fechaInicio, String fechaFin, String prioridad,
			String aplicacion, String tipoSolicitud, String categoria, String solicitud, String solucion) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.prioridad = prioridad;
		this.aplicacion = aplicacion;
		this.tipoSolicitud = tipoSolicitud;
		this.categoria = categoria;
		this.solicitud = solicitud;
		this.solucion = solucion;
	}
	
	
	

	public SolicitudUserDTO(int codigo, String estado, String fechaInicio, String fechaFin, String prioridad,
			String aplicacion, String tipoSolicitud, String categoria, String solicitud, String solucion,
			String reg_nombres, String reg_apellidos) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.prioridad = prioridad;
		this.aplicacion = aplicacion;
		this.tipoSolicitud = tipoSolicitud;
		this.categoria = categoria;
		this.solicitud = solicitud;
		this.solucion = solucion;
		this.reg_nombres = reg_nombres;
		this.reg_apellidos = reg_apellidos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public String getReg_nombres() {
		return reg_nombres;
	}

	public void setReg_nombres(String reg_nombres) {
		this.reg_nombres = reg_nombres;
	}

	public String getReg_apellidos() {
		return reg_apellidos;
	}

	public void setReg_apellidos(String reg_apellidos) {
		this.reg_apellidos = reg_apellidos;
	}
	
	
}
