package com.cliente.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.service.SolicitudService;
import com.cliente.util.Constantes;


@Controller
@RequestMapping("/rest/solicitud")
public class SolicitudWebController {
	
	@Autowired
	@Qualifier("solService")
	private SolicitudService solService;
	
	//url: http://localhost:9090/web/listar
	
	@PostMapping("/missolicitudes")
	public String consultar_misSolicitudes(HttpServletRequest request, Model model) {
		String url = "principal";

		String estado = request.getParameter("cboEstado");
		int aplicativo = Integer.parseInt(request.getParameter("cboAplicacion"));
		String fecha = request.getParameter("fecha");

		int buscarSeparador = fecha.indexOf("/");
		String fechaInicio = fecha.substring(0, buscarSeparador).trim() + " 00:00:00";
		String fechaFin = fecha.substring(buscarSeparador + 2).trim() + " 23:59:59";


		model.addAttribute("listaAplicativos", solService.listar());
			

		return url;
		
	}
	
	@PostMapping(value = "/registrarAtencion")
	public ModelAndView registraSolicitud(SolicitudDTO sol, Model model) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		SolicitudDTO solicitud = new SolicitudDTO();
		solicitud.setTipoSolicitud(sol.getTipoSolicitud());
		solicitud.setAplicacion(sol.getAplicacion());
		solicitud.setCategoria(sol.getCategoria());
		solicitud.setDescripcionSolicitud(sol.getDescripcionSolicitud());
		solicitud.setFechaRegistro(formatoFecha.format(date));
		solicitud.setPrioridad(sol.getPrioridad());
		solicitud.setEstado("Registrado");
		System.out.println("ini registrarAtencion()");
		System.out.println("Formulario: "+sol.toString());
		solService.insertaActualizaSolicitud(sol);
		ModelAndView modelAndView = new ModelAndView(Constantes.MENSAJE_REG_ERROR);
		modelAndView.addObject("usuarios", solService.listar());
		return modelAndView;
					
		}
	*/
	
	@PostMapping("/consultarSolicitudes")
	public String consultar_Solicitudes(HttpServletRequest request, Model model) {

		String estado = request.getParameter("cboEstado");
		String fecha = request.getParameter("fecha");
		int buscarSeparador = fecha.indexOf("/");
		String fechaInicio = fecha.substring(0, buscarSeparador).trim() + " 00:00:00";
		String fechaFin = fecha.substring(buscarSeparador + 2).trim() + " 23:59:59";

		model.addAttribute("listaSolicitudes", solService.fetchSolicitudDTODataInnerJoin(estado, fechaInicio, fechaFin));

		return "/reportes/consultaSolicitudes";
		
	}
	@GetMapping("/verSolicitudDetalle/{codigo}")
	public String verSolicitudDetalle(@PathVariable int codigo, Model model) {
		SolicitudDTO objSol  = solService.fetchSolicitudDetallexIDDTODataInnerJoin(codigo);
		model.addAttribute("solicitud", objSol);
		return "detalleOperador";
	}
	
	@PostMapping("/solicitudActualizar")
	public String solicitud_actualizar(@ModelAttribute SolicitudDTO sol ) {
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		solService.insertaActualizaSolicitud(sol);
		return "redirect:/repsolicitudes";
	}
	
	
	
	
}

	



