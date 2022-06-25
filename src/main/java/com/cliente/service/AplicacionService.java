package com.cliente.service;

import java.util.List;

import com.cliente.model.DTO.AplicacionDTO;


public interface AplicacionService {
	
	public List<AplicacionDTO> listarAplicacion();
	
	public abstract AplicacionDTO guarda(AplicacionDTO aplicacion);
	
	public int insertaActualizaAplicacion(AplicacionDTO aplicacion);
}
