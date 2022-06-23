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

	@Override
	public List<SolicitudDTO> fetchSolicitudDTODataInnerJoin(String estado, String fechaInicio, String fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<SolicitudDTO> listarSolicitudesxUsuario(int persona, String estado, String fechaInicio, String fechaFin,
			int aplicativo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolicitudDTO fetchSolicitudDetallexIDDTODataInnerJoin(int codigoSolicitud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolicitudDTO> listarSolicitud() {
		String endpoint = "http://localhost:9010/rest/solicitud/listarSolicitud";
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

	@Override
	public List<SolicitudDTO> listar() {
		String endpoint = "http://localhost:9010/rest/solicitud/solicitud/listarSolicitud";
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

	@Override
	public int guardar(SolicitudDTO solicitud) {
		//http://localhost:9010/rest/solicitud/registraSolicitud
		
				String endpoint = "http://localhost:9010/rest/solicitud/registraSolicitud";
				RestTemplate restCliente = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				HttpEntity request = new HttpEntity<>(solicitud,headers);
				
				ResponseEntity<?> respuesta  = null;
				
				RestUtilitario restUtil = new RestUtilitario();
				respuesta = restUtil.consumeRestServicePOST(endpoint, request, null);
				
				if (respuesta.getStatusCodeValue()== HttpStatus.OK.value()) {
					return 1;
				}else return -1;
				
				
			}



	@Override
	public SolicitudDTO insertaActualizaSolicitud(SolicitudDTO solicitud) {
		return solicitud;
		//http://localhost:9010/rest/solicitud/registraSolicitud
		
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
		
		*/
	}

	

}
