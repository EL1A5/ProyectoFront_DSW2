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
import com.cliente.model.DTO.PersonaDTO;
import com.cliente.service.PersonaService;
import com.cliente.util.RestUtilitario;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Override
	public List<PersonaDTO> listarPersonas() {
		String endpoint = "http://localhost:9010/usuario";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(headers);
		
		ResponseEntity<PersonaDTO[]> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		
		respuesta = restUtil.consumeRestServiceGET(endpoint,request,PersonaDTO[].class);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			PersonaDTO[] persona = respuesta.getBody();
			List<PersonaDTO> lista = new ArrayList<PersonaDTO>();
			for(PersonaDTO x: persona){
				lista.add(x);		
			}	
			return lista;		
			
		}else{
			return new ArrayList<>();
		}
	}

	@Override
	public int insertarPersonas(PersonaDTO persona) {
		// TODO Auto-generated method stub
		return 0;
	}

}
