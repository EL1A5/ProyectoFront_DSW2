package com.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.model.DTO.TipoSolicitudDTO;
import com.cliente.service.TipoSolicitudService;
import com.cliente.util.RestUtilitario;

@Service
public class TipoSolicitudServiceImpl implements TipoSolicitudService {
	
	@Override
	public List<TipoSolicitudDTO> listarTipoSolicitud() {
		String endpoint = "http://localhost:9010/rest/tiposolicitud";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(headers);
		ResponseEntity<TipoSolicitudDTO[]> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		
		respuesta = restUtil.consumeRestServiceGET
				(endpoint,
					request,
					TipoSolicitudDTO[].class);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			TipoSolicitudDTO[] pokemones = respuesta.getBody();
			List<TipoSolicitudDTO> lstPokes = new ArrayList<TipoSolicitudDTO>();
			for(TipoSolicitudDTO poke: pokemones){
				lstPokes.add(poke);		
			}	
			return lstPokes;		
		}else{
			return new ArrayList<>();
		}
	}

}
