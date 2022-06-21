package com.cliente.model.DTO;

import java.io.Serializable;


public class CategoriaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCategoria;
	private String descripcion;
	
	
	
	
	public CategoriaDTO(int idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}
