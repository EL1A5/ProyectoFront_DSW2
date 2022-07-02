package com.cliente.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.service.AplicacionService;
import com.cliente.service.CategoriaService;
import com.cliente.service.SolicitudService;
import com.cliente.service.TipoSolicitudService;

@Controller
@RequestMapping
public class ConsultaWebController {
	
	@Autowired
	SolicitudService serviceSolicitud;
	
	@Autowired
	AplicacionService serviceAplicacion;
	
	@Autowired
	TipoSolicitudService serviceTipoSolicitud;
	
	@Autowired
	CategoriaService serviceCategoria;
	
	@GetMapping("/consulta/repsolicitudes")
	public String registrar_solicitudes(Model model) {
		System.out.println("registro solicitudes");
		model.addAttribute("listaAplicativos", serviceAplicacion.listarAplicacion());
		model.addAttribute("listaTipoSolicitudes", serviceTipoSolicitud.listarTipoSolicitud());
		model.addAttribute("listaCategoria", serviceCategoria.listarCategoria());
		model.addAttribute("solicitud", new SolicitudDTO());
		return "/reportes/consultaSolicitudes";
	}
	
	
	
	
	
	

}
