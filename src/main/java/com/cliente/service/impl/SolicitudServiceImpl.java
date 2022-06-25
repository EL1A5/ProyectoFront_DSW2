package com.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cliente.model.DTO.CategoriaDTO;
import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.service.SolicitudService;
import com.cliente.util.RestUtilitario;

public class SolicitudServiceImpl implements SolicitudService{

	@Override
	public List<SolicitudDTO> listaSolicitudPorEstadoAplicativoFecha(String estado, int id_aplicacion, String fec_reg) {
		String endpoint = "http://localhost:9010/rest/solicitud";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(headers);
		
		ResponseEntity<SolicitudDTO[]> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		
		respuesta = restUtil.consumeRestServiceGET
				(endpoint,
					request,
					SolicitudDTO[].class);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			SolicitudDTO[] pokemones = respuesta.getBody();
			
			List<SolicitudDTO> lstPokes = new ArrayList<SolicitudDTO>();
			for(SolicitudDTO poke: pokemones){
				lstPokes.add(poke);		
			}	
			return lstPokes;		
			
		}else{
			return new ArrayList<>();
		}
	}
	


}
