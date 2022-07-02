package com.cliente.service;

import java.util.List;

import com.cliente.model.DTO.FiltroPersonaDTO;
import com.cliente.model.DTO.PersonaDTO;
import com.cliente.model.DTO.RptaServerDTO;


public interface PersonaService {
	
	
	public List<PersonaDTO> listarPersonas();
	public RptaServerDTO insertarPersonas(PersonaDTO persona);
	public RptaServerDTO actualizarPersonas(PersonaDTO persona);
	public List<PersonaDTO> listadoFiltro(FiltroPersonaDTO dto);

}
