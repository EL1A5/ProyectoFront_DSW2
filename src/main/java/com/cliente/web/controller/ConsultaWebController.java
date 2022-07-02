package com.cliente.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.ConsultarSolicitudesXEstadoFecha;
import com.cliente.model.DTO.FiltroPersonaDTO;
import com.cliente.model.DTO.PersonaDTO;
import com.cliente.model.DTO.RptaServerDTO;
import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.model.DTO.SolicitudUserDTO;
import com.cliente.service.AplicacionService;
import com.cliente.service.CategoriaService;
import com.cliente.service.PersonaService;
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
	
	@Autowired
	PersonaService servicePersona;

	@GetMapping("/consulta/repsolicitudes")
	public String nav_consultar_solicitudes(Model model) {
		System.out.println("registro solicitudes");
		model.addAttribute("listaAplicativos", serviceAplicacion.listarAplicacion());
		model.addAttribute("listaTipoSolicitudes", serviceTipoSolicitud.listarTipoSolicitud());
		model.addAttribute("listaCategoria", serviceCategoria.listarCategoria());
		model.addAttribute("solicitud", new SolicitudDTO());
		return "/reportes/consultaSolicitudes";
	}

	@PostMapping("/consulta/consultarSolicitudes")
	public String consultar_solicitudes(HttpServletRequest request, Model model) {

		System.out.println("Usuario : " + request.getParameter("cboEstado"));
		System.out.println("FECHA : " + request.getParameter("fecha"));
		String estado = request.getParameter("cboEstado");
		
		/*
		String fecha = request.getParameter("fecha");
		ConsultarSolicitudesXEstadoFecha xa = new ConsultarSolicitudesXEstadoFecha();
		xa.setEstado(estado);
		xa.setFecha(fecha);
		System.out.println("Filas: " + serviceSolicitud.findByEstadoAndFechaRegistro(xa).size());
		model.addAttribute("listaSolicitudes", serviceSolicitud.findByEstadoAndFechaRegistro(xa));
		*/
		String fecha = request.getParameter("fecha");
		int buscarSeparador = fecha.indexOf("/");
		String fechaInicio = fecha.substring(0, buscarSeparador).trim() + " 00:00:00";
		String fechaFin = fecha.substring(buscarSeparador + 2).trim() + " 23:59:59";
		
		ConsultarSolicitudesXEstadoFecha xa = new ConsultarSolicitudesXEstadoFecha();
		xa.setEstado(estado);
		xa.setFechaInicio(fechaInicio);
		xa.setFechaFin(fechaFin);
		model.addAttribute("listaSolicitudes",
				serviceSolicitud.consultarSolicitudEstadoFecha(xa)
				);
		
		

		return "/reportes/consultaSolicitudes";
	}
	
	@GetMapping("/consulta/verSolicitud/{codigo}")
	public String verSolicitud(@PathVariable int codigo, Model model) {
		
		
		SolicitudDTO objSol  = serviceSolicitud.fetchSolicitudDetallexIDDTODataInnerJoin(codigo);
		model.addAttribute("solicitud", objSol);
		return "detalle";
	}
	
	@GetMapping("/consulta/verSolicitudDetalle/{codigo}")
	public String verSolicitudDetalle(@PathVariable int codigo, Model model) {
		System.out.println("verSolicitudDetalle -  codigo: " + codigo);
		SolicitudDTO objSol  = serviceSolicitud.fetchSolicitudDetallexIDDTODataInnerJoin(codigo);
		
		System.out.println("verSolicitudDetalle -  codigo: " + objSol.getAplicacion());
		
		model.addAttribute("solicitud", objSol);
		return "detalleOperador";
	}
	
	@PostMapping("/consulta/solicitudActualizar")
	public String actualizarSolicitud(@ModelAttribute SolicitudDTO obj) {
		System.out.println("actualizarSolicitud - : " + obj.getCodigo());
		RptaServerDTO rpta = serviceSolicitud.updateSolicitud(obj);
		
		if (rpta != null) {
			System.out.println("Actualizo");
		}else {
			System.out.println("no actualizo");
		}
		return "redirect:/consulta/repsolicitudes";
	}
	
	@GetMapping("/consulta/repusuarios")
	public String rep_usuarios() {
		return "/reportes/consultaUsuarios";
	}
	
	
	@PostMapping("/consulta/repConsultaUsuarios")
	public String consultar_usuarios(HttpServletRequest request, Model model) {
		String url = "/reportes/consultaUsuarios";
		int tipoUsuario = Integer.parseInt(request.getParameter("cboTipoUsuario"));
		String dni = request.getParameter("txtDNI");
		String apellidos = request.getParameter("txtApellidos");
		
		System.out.println("consultar_usuarios - frontend - tipoUsuario: "+ tipoUsuario);
		System.out.println("consultar_usuarios - frontend - dni: "+ dni);
		System.out.println("consultar_usuarios - frontend - apellidos: "+ apellidos);
		
		
		FiltroPersonaDTO filtro = new FiltroPersonaDTO();
		filtro.setApellidos(apellidos);
		filtro.setDni(dni);
		filtro.setTipoUsuario(tipoUsuario);
		List<PersonaDTO> lista = servicePersona.listadoFiltro(filtro);
		model.addAttribute("listaPersonas", lista);
		return url;
	}
	
	

}
