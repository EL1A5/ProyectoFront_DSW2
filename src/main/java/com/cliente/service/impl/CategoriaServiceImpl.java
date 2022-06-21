package com.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cliente.model.DTO.CategoriaDTO;
import com.cliente.service.CategoriaService;
import com.cliente.util.RestUtilitario;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Override
	public List<CategoriaDTO> listarCategoria() {
		// TODO Auto-generated method stub
		String endpoint = "http://localhost:9010/rest/categoria";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(headers);
		
		ResponseEntity<CategoriaDTO[]> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		
		respuesta = restUtil.consumeRestServiceGET
				(endpoint,
					request,
					CategoriaDTO[].class);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			CategoriaDTO[] pokemones = respuesta.getBody();
			
			List<CategoriaDTO> lstPokes = new ArrayList<CategoriaDTO>();
			for(CategoriaDTO poke: pokemones){
				lstPokes.add(poke);		
			}	
			return lstPokes;		
			
		}else{
			return new ArrayList<>();
		}
	}

	@Override
	public int insertaActualizaCategoria(CategoriaDTO categoria) {
		        
				String endpoint = "http://localhost:9010/rest/categoria";
				RestTemplate restCliente = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				HttpEntity request = new HttpEntity<>(categoria,headers);
				
				ResponseEntity<?> respuesta  = null;
				
				RestUtilitario restUtil = new RestUtilitario();
				respuesta = restUtil.consumeRestServicePOST(endpoint, request, null);
				
				if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
					return 1;
				}else return -1;
	}

}
