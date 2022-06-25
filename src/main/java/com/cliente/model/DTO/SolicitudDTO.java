package com.cliente.model.DTO;

import java.io.Serializable;

public class SolicitudDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id_solicitud;
	private String des_atencion;
	private String des_solicitud;
	private String estado;
	private String fec_cierre;
	private String fec_reg;
	private String prioridad;
	private int id_aplicacion;
	private int id_categoria;
	private int id_persona;
	private int id_tipo_solicitud;
	
	public SolicitudDTO() {
		
	}

	public SolicitudDTO(int id_solicitud, String des_atencion, String des_solicitud, String estado, String fec_cierre,
			String fec_reg, String prioridad, int id_aplicacion, int id_categoria, int id_persona,
			int id_tipo_solicitud) {
		super();
		this.id_solicitud = id_solicitud;
		this.des_atencion = des_atencion;
		this.des_solicitud = des_solicitud;
		this.estado = estado;
		this.fec_cierre = fec_cierre;
		this.fec_reg = fec_reg;
		this.prioridad = prioridad;
		this.id_aplicacion = id_aplicacion;
		this.id_categoria = id_categoria;
		this.id_persona = id_persona;
		this.id_tipo_solicitud = id_tipo_solicitud;
	}

	public int getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(int id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public String getDes_atencion() {
		return des_atencion;
	}

	public void setDes_atencion(String des_atencion) {
		this.des_atencion = des_atencion;
	}

	public String getDes_solicitud() {
		return des_solicitud;
	}

	public void setDes_solicitud(String des_solicitud) {
		this.des_solicitud = des_solicitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFec_cierre() {
		return fec_cierre;
	}

	public void setFec_cierre(String fec_cierre) {
		this.fec_cierre = fec_cierre;
	}

	public String getFec_reg() {
		return fec_reg;
	}

	public void setFec_reg(String fec_reg) {
		this.fec_reg = fec_reg;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public int getId_aplicacion() {
		return id_aplicacion;
	}

	public void setId_aplicacion(int id_aplicacion) {
		this.id_aplicacion = id_aplicacion;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}

	public int getId_tipo_solicitud() {
		return id_tipo_solicitud;
	}

	public void setId_tipo_solicitud(int id_tipo_solicitud) {
		this.id_tipo_solicitud = id_tipo_solicitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
