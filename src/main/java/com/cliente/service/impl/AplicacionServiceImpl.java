package com.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cliente.model.DTO.AplicacionDTO;
import com.cliente.service.AplicacionService;
import com.cliente.util.RestUtilitario;

@Service("aplicacionServiceImpl")
public class AplicacionServiceImpl implements AplicacionService {

	@Override
	public List<AplicacionDTO> listarAplicacion() {
		
		// http://localhost:9010/rest/aplication
		
		String endpoint = "http://localhost:9010/rest/aplication";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(headers);
		
		ResponseEntity<AplicacionDTO[]> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		
		respuesta = restUtil.consumeRestServiceGET
				(endpoint,
					request,
					AplicacionDTO[].class);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			AplicacionDTO[] pokemones = respuesta.getBody();
			
			List<AplicacionDTO> lstPokes = new ArrayList<AplicacionDTO>();
			for(AplicacionDTO poke: pokemones){
				lstPokes.add(poke);		
			}	
			return lstPokes;		
			
		}else{
			return new ArrayList<>();
		}
	}

	@Override
	public AplicacionDTO guarda(AplicacionDTO aplicacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertaActualizaAplicacion(AplicacionDTO aplicacion) {
		// http://localhost:9010/rest/aplication/registraAplicacion
		
		String endpoint = "http://localhost:9010/rest/aplication/registraAplicacion";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(aplicacion,headers);
		
		ResponseEntity<?> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		respuesta = restUtil.consumeRestServicePOST(endpoint, request, null);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			return 1;
		}else return -1;
		
		
	}

}
