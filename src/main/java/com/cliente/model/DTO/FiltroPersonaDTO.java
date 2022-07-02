package com.cliente.model.DTO;

import java.io.Serializable;

public class FiltroPersonaDTO implements Serializable{

	
	private int tipoUsuario;
	private String dni;
	private String apellidos;
	
	
	public FiltroPersonaDTO(int tipoUsuario, String dni, String apellidos) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.dni = dni;
		this.apellidos = apellidos;
	}
	
	public FiltroPersonaDTO() {
		
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	
	
	
	
	
}
