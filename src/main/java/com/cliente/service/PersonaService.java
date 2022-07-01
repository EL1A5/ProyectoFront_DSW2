package com.cliente.service;

import java.util.List;
import com.cliente.model.DTO.PersonaDTO;

public interface PersonaService {
	
	
	public List<PersonaDTO> listarPersonas();
	public int insertarPersonas(PersonaDTO persona);
	
	

}
