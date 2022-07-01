package com.cliente.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.AplicacionDTO;
import com.cliente.model.DTO.CategoriaDTO;
import com.cliente.model.DTO.PersonaDTO;
import com.cliente.service.AplicacionService;
import com.cliente.service.CategoriaService;
import com.cliente.service.PersonaService;

@Controller
@RequestMapping("/menu")

public class MenuController {
	
	@Autowired
	CategoriaService servicioCategoria;
	
	@Autowired
	AplicacionService servicioAplicacion;
	
	@Autowired
	PersonaService servicioPersona;

	@GetMapping("/configcategoria")
	public String nav_categoria(Model model) {
		model.addAttribute("listaCategorias", servicioCategoria.listarCategoria());
		model.addAttribute("categoria", new CategoriaDTO());
		return "/configuracion/categoria";
	}
	
	@GetMapping("/configaplicacion")
	public String nav_aplicacion(Model model) {
		model.addAttribute("listaAplicaciones", servicioAplicacion.listarAplicacion());
		model.addAttribute("aplicacion", new AplicacionDTO());
		return "/configuracion/aplicacion";	
	}
	

	@GetMapping("/configusuario")
	public String nav_usuario(Model model) {
		model.addAttribute("listaPersonas", servicioPersona.listarPersonas());
		model.addAttribute("persona", new PersonaDTO());
		return "/configuracion/usuario";
	}
	
	
	
	
	
}
