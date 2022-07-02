package com.cliente.model.DTO;

import java.io.Serializable;

public class AutenticacionResponseDTO implements Serializable {
	
	private String codigo;
	private String mensaje;
	
	public AutenticacionResponseDTO() {
		
	}
	
	public AutenticacionResponseDTO(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
