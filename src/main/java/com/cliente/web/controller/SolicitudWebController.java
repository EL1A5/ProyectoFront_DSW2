package com.cliente.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.service.SolicitudService;

@Controller
@RequestMapping
public class SolicitudWebController {
	
	@Autowired
	private SolicitudService serviceSolicitud;

	
    @GetMapping("/listaSolicitudConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaSolicitudPorEstadoAplicativoFecha(

			@RequestParam(name = "estado", required = false, defaultValue = "") String estado,
			@RequestParam(name = "aplicativo", required = false, defaultValue = "-1") int id_aplicacion,
			@RequestParam(name = "fechaRegistro", required = false, defaultValue = "") String fec_reg
	) {
		Map<String, Object> salida = new HashMap<>();
		
		try {
			List<SolicitudDTO> lista = serviceSolicitud.listaSolicitudPorEstadoAplicativoFecha("%"+estado+"%", id_aplicacion,fec_reg);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", com.cliente.util.Constantes.MENSAJE_CONSULTA_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
