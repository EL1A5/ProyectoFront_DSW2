package com.cliente.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cliente.model.DTO.AutenticacionDTO;
import com.cliente.model.DTO.AutenticacionResponseDTO;
import com.cliente.service.UsuarioService;
import com.cliente.util.RestUtilitario;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Override
	public AutenticacionResponseDTO autenticar(AutenticacionDTO auth) {
		
		String endPoint = "http://localhost:9010/usuario/autenticarUsuario";
		
		RestTemplate restCliente = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request = new HttpEntity<>(auth, headers);
		
		ResponseEntity<AutenticacionResponseDTO> respuesta = null;
		RestUtilitario restUtil = new RestUtilitario();
		
		respuesta = restUtil.consumeRestServicePOST(endPoint, request, AutenticacionResponseDTO.class);
		
		if (respuesta.getStatusCodeValue() == HttpStatus.OK.value() ) {
			AutenticacionResponseDTO obj = respuesta.getBody();
			return obj;
		}else {
			return null;
		}
	}

}
