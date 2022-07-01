package com.cliente.model.DTO;

public class PersonaDTO {
	
	private int codigo;
	private String nombre;
	private String apellido;
	private String documento;
	private String celular;
	private String telefono;
	private String tipoUsuario;
	
	public PersonaDTO() {
		
	}
	
	
	public PersonaDTO(int codigo, String nombre, String apellido, String documento, String celular, String telefono,
			String tipoUsuario) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.celular = celular;
		this.telefono = telefono;
		this.tipoUsuario = tipoUsuario;
	}


	
	
	

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	
	

	
	

}
