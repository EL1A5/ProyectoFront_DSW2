package com.cliente.service;

import com.cliente.model.DTO.AutenticacionDTO;
import com.cliente.model.DTO.AutenticacionResponseDTO;

public interface UsuarioService {

	public AutenticacionResponseDTO autenticar(AutenticacionDTO auth);
	
}
