package com.cliente.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.CategoriaDTO;
import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.service.AplicacionService;
import com.cliente.service.SolicitudService;


@Controller
@RequestMapping
public class SolicitudWebController {
	@Autowired
	SolicitudService serviceSolicitud;
	
	@Autowired
	AplicacionService serviceAplicacion;
	
	
	@PostMapping("/registrarAtencion")
	public String registrarAtencion(@ModelAttribute SolicitudDTO objSolicitud) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		SolicitudDTO solicitud = new SolicitudDTO();
		solicitud.setTipoSolicitud(objSolicitud.getTipoSolicitud());
		solicitud.setAplicacion(objSolicitud.getAplicacion());
		solicitud.setCategoria(objSolicitud.getCategoria());
//		solicitud.setDescripcionSolicitud(objSolicitud.getDescripcionSolicitud());
//		solicitud.setFechaRegistro(formatoFecha.format(date));
		solicitud.setPrioridad(objSolicitud.getPrioridad());
		solicitud.setEstado("Registrado");

//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		UserDetails userDetails = (UserDetails) auth.getPrincipal();
//		Optional<User> usuario = serviceUsuario.buscarUsuario(userDetails.getUsername());
//		solicitud.setPersona(usuario.get().getPersona());
		serviceSolicitud.guardar(solicitud);
		return "redirect:/regsolicitudes?success=true";
	}
	
	
	@PostMapping("/solicitudActualizar")
	public String solicitud_actualizar(@ModelAttribute SolicitudDTO sol ) {
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		SolicitudDTO solicitud = new SolicitudDTO();
		//sol.getCodigo(), formato.format(fecha), sol.getSolucion()
		SolicitudDTO inserto = serviceSolicitud.insertaActualizaSolicitud(solicitud);
		return "redirect:/repsolicitudes";
	}
	
	
	@GetMapping("/menu/solicitudes")
	public String menu_solicitudes(Model model) {
		model.addAttribute("listaAplicativos", serviceAplicacion.listarAplicacion() );
		return "principal";
	}
	
	
	@PostMapping("/solicitudes/consultarMisSolicitudes")
	public String consultar_mis_solicitudes(HttpServletRequest request, Model model) {
		
		System.out.println("Estado : " + request.getParameter("cboEstado") );
		System.out.println("Aplicativo : " + request.getParameter("cboAplicacion") );
		System.out.println("Fecha : " + request.getParameter("fecha") );
		
		
		
		
		
		
		
		model.addAttribute("listaAplicativos", serviceAplicacion.listarAplicacion() );
		return "principal";
	}
	
	
	
}
	
	



