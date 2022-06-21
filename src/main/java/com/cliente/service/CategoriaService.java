package com.cliente.service;

import java.util.List;
import com.cliente.model.DTO.CategoriaDTO;

public interface CategoriaService {

	public List<CategoriaDTO> listarCategoria();
	
	public int insertaActualizaCategoria(CategoriaDTO categoria);
}
