package com.cliente.model.DTO;

import java.io.Serializable;

public class ConsultarSolicitudesXEstadoFecha implements Serializable {
		

	private String estado;
	private String fecha;
	
	
	private String fechaInicio;
	private String fechaFin;
	
	public ConsultarSolicitudesXEstadoFecha() {
	}
	
	public ConsultarSolicitudesXEstadoFecha(String estado, String fecha) {
		super();
		this.estado = estado;
		this.fecha = fecha;
	}

	
	public ConsultarSolicitudesXEstadoFecha(String estado, String fecha, String fechaInicio, String fechaFin) {
		super();
		this.estado = estado;
		this.fecha = fecha;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	
	
	
	

}
