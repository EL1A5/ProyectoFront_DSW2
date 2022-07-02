package com.cliente.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cliente.model.DTO.RptaServerDTO;
import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.model.DTO.SolicitudUsuarioDTO;
import com.cliente.service.AplicacionService;
import com.cliente.service.CategoriaService;
import com.cliente.service.PersonaService;
import com.cliente.service.SolicitudService;
import com.cliente.service.TipoSolicitudService;


@Controller
@RequestMapping
public class SolicitudWebController {
	@Autowired
	SolicitudService serviceSolicitud;
	
	@Autowired
	AplicacionService serviceAplicacion;
	
	@Autowired
	TipoSolicitudService serviceTipoSolicitud;
	
	@Autowired
	CategoriaService serviceCategoria;
	
	
	
	@PostMapping("/solicitudes/registrarAtencion")
	public String registrarAtencion(@ModelAttribute SolicitudDTO objSolicitud) {
		System.out.println("Tipo Solicitud: " + objSolicitud.getTipoSolicitud());
		System.out.println("Aplicacion: " + objSolicitud.getAplicacion());
		System.out.println("Categoria: " + objSolicitud.getCategoria());
		System.out.println("Prioridad: " + objSolicitud.getPrioridad());
		System.out.println("Solicitud: " + objSolicitud.getSolicitud());
		
		SolicitudUsuarioDTO sol = new SolicitudUsuarioDTO();
		sol.setAplicacion(Integer.parseInt(objSolicitud.getAplicacion()));
		sol.setTipoSolicitud(Integer.parseInt(objSolicitud.getTipoSolicitud()));
		sol.setCategoria(Integer.parseInt(objSolicitud.getCategoria()));
		sol.setPrioridad(objSolicitud.getPrioridad());
		sol.setDescripcion(objSolicitud.getSolicitud());
		
		RptaServerDTO rpta =serviceSolicitud.guardarSolicitud(sol);
		
		if (rpta!= null) {
			System.out.println("Inserto");
		}else {
			System.out.println("No Inserto");
		}
	
		return "redirect:/solicitudes/registrar?success=true";
	}
	

	
	@GetMapping("/menu/solicitudes")
	public String menu_solicitudes(Model model) {
		model.addAttribute("listaAplicativos", serviceAplicacion.listarAplicacion() );
		return "principal";
	}
	
	@GetMapping("/solicitudes/consultarMisSolicitudes")
	public String consultar_mis_solicitudes(HttpServletRequest request, Model model) {
		System.out.println("Estado : " + request.getParameter("cboEstado") );
		System.out.println("Aplicativo : " + request.getParameter("cboAplicacion") );
		System.out.println("Fecha : " + request.getParameter("fecha") );
		
		
		model.addAttribute("listaAplicativos", serviceAplicacion.listarAplicacion() );
		return "principal";// se tiene que ir a otro lado
	}
	
	
	
	@GetMapping("/solicitudes/registrar")
	public String registrar_solicitudes(Model model) {
		System.out.println("registro solicitudes");
		model.addAttribute("listaAplicativos", serviceAplicacion.listarAplicacion());
		model.addAttribute("listaTipoSolicitudes", serviceTipoSolicitud.listarTipoSolicitud());
		model.addAttribute("listaCategoria", serviceCategoria.listarCategoria());
		model.addAttribute("solicitud", new SolicitudDTO());
		return "/core/registroSolicitud";
	}
	
	
	
	
	
	

	
	
	
}
	
	



