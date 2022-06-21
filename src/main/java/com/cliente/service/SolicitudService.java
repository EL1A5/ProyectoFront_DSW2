package com.cliente.service;

import java.util.List;
import com.cliente.model.DTO.SolicitudDTO;



public interface SolicitudService {
	public List<SolicitudDTO> listarSolicitud();
	public abstract SolicitudDTO guarda(SolicitudDTO solicitud);
	public int insertaActualizaSolicitud(SolicitudDTO solicitud);
	
}
