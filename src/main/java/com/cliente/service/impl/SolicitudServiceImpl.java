package com.cliente.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cliente.model.DTO.AplicacionDTO;
import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.service.SolicitudService;
import com.cliente.util.RestUtilitario;

@Service
public class SolicitudServiceImpl implements SolicitudService {
     //http://localhost:9010/rest/solicitud
	@Override
	public List<SolicitudDTO> listarSolicitud() {
		String endpoint = "http://localhost:9010/rest/solicitud";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(headers);
		
		ResponseEntity<SolicitudDTO[]> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		
		respuesta = restUtil.consumeRestServiceGET
				(endpoint,
					request,
					AplicacionDTO[].class);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			SolicitudDTO[] pok = respuesta.getBody();
			
			List<SolicitudDTO> lstPokes = new ArrayList<SolicitudDTO>();
			for(SolicitudDTO poke: pok){
				lstPokes.add(poke);		
			}	
			return lstPokes;		
			
		}else{
			return new ArrayList<>();
		}
	}
	@Override
	public SolicitudDTO guarda(SolicitudDTO solicitud) {
		//localhost:9010/rest/solicitud/registraSolicitud
		/*String endpoint = "http://localhost:9010/rest/solicitud/registraSolicitud";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(solicitud,headers);
		
		ResponseEntity<?> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		respuesta = restUtil.consumeRestServicePOST(endpoint, request, null);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			return 1;
		}else return -1;
		
		*/return solicitud;
	}
	@Override
	public int insertaActualizaSolicitud(SolicitudDTO solicitud) {
		//localhost:9010/rest/solicitud/registraSolicitud
		String endpoint = "http://localhost:9010/rest/solicitud/actualizaSolicitud";
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(solicitud,headers);
		
		ResponseEntity<?> respuesta  = null;
		
		RestUtilitario restUtil = new RestUtilitario();
		respuesta = restUtil.consumeRestServicePUT(endpoint, request, null);
		
		if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
			return 1;
		}else return -1;
		
		
	}

	
	

}
