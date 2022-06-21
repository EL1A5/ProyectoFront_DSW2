package com.cliente.model.DTO;

import java.io.Serializable;


public class AplicacionDTO implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	private int idAplicacion;
	private String descripcion;
	
    public AplicacionDTO() {
		
	}
	public AplicacionDTO(int idAplicacion, String descripcion) {
		super();
		this.idAplicacion = idAplicacion;
		this.descripcion = descripcion;
	}


	public int getIdAplicacion() {
		return idAplicacion;
	}


	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
