package com.cliente.service;

import java.util.List;

import com.cliente.model.DTO.SolicitudDTO;

public interface SolicitudService {
	
	public abstract List<SolicitudDTO> listaSolicitudPorEstadoAplicativoFecha(String estado, int id_aplicacion, String fec_reg);

}
