package com.cliente.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.CategoriaDTO;
import com.cliente.model.DTO.SolicitudDTO;
import com.cliente.service.SolicitudService;

@Controller
@RequestMapping
public class SolicitudWebController {
	@Autowired
	SolicitudService serviceSolicitud;
	
	
	@GetMapping("/configsolicitud")
	public String nav_categoria(Model model) {

		model.addAttribute("listaSolicitud", serviceSolicitud.listarSolicitud());
		model.addAttribute("solicitud", new SolicitudDTO());
		return "/reportes/regiatroSolicitud";
	}
	@PostMapping("/configCategoriaRegistrar")
	public String registrarSolicitud(@ModelAttribute SolicitudDTO obj) {
		String url = "";
		int insertar = serviceSolicitud.insertaActualizaSolicitud(obj);
		if (insertar > 0) {
			url = "redirect:/reporteSolicitud?primary=true";
		} else {
			url = "redirect:/reporteSolicitud?alert=true";
		}
		return url;
	}
}

