package com.cliente.service;

import java.util.List;

import com.cliente.model.DTO.ConsultarSolicitudesXEstadoFecha;
import com.cliente.model.DTO.RptaServerDTO;
import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.model.DTO.SolicitudUserDTO;
import com.cliente.model.DTO.SolicitudUsuarioDTO;


public interface SolicitudService {
	
	
	public List<SolicitudDTO> fetchSolicitudDTODataInnerJoin(String estado, String fechaInicio, String fechaFin) ;
	
	
	public List<SolicitudDTO> listarSolicitudesxUsuario(int persona, String estado, String fechaInicio, String fechaFin,
			int aplicativo);
	
	public SolicitudDTO fetchSolicitudDetallexIDDTODataInnerJoin(int codigoSolicitud);
	
	public List<SolicitudDTO> listarSolicitud();
	
	public List<SolicitudDTO> listar();
	
	public int guardar(SolicitudDTO solicitud);
	
	public abstract SolicitudDTO insertaActualizaSolicitud(SolicitudDTO solicitud);

	public RptaServerDTO guardarSolicitud(SolicitudUsuarioDTO solicitud);
	
	public RptaServerDTO updateSolicitud(SolicitudDTO sol);
	
	
	public List<SolicitudUserDTO> findByEstadoAndFechaRegistro(ConsultarSolicitudesXEstadoFecha obj);
	
	public List<SolicitudUserDTO> consultarSolicitudEstadoFecha(ConsultarSolicitudesXEstadoFecha obj);

}
   