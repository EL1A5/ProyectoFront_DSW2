package com.cliente.service;

import java.util.List;

import com.cliente.model.DTO.SolicitudDTO;


public interface SolicitudService {
	
	
	public List<SolicitudDTO> fetchSolicitudDTODataInnerJoin(String estado, String fechaInicio, String fechaFin) ;
	
	
	public List<SolicitudDTO> listarSolicitudesxUsuario(int persona, String estado, String fechaInicio, String fechaFin,
			int aplicativo);
	
	public SolicitudDTO fetchSolicitudDetallexIDDTODataInnerJoin(int codigoSolicitud);
	
	public List<SolicitudDTO> listarSolicitud();
	
	public List<SolicitudDTO> listar();
	
	public int guardar(SolicitudDTO solicitud);
	
	public abstract SolicitudDTO insertaActualizaSolicitud(SolicitudDTO solicitud);


}
   