package com.cliente.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.PersonaDTO;
import com.cliente.service.PersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	
	@Autowired
	PersonaService servicioPersona;
	
	@PostMapping("/configPersonaRegistrar")
	public String registrarPersona(@ModelAttribute PersonaDTO persona) {
		String url = "";
		int rptaGuardar =0;
		
		
		
		
		

		if (rptaGuardar > 0) {
			url = "redirect:/persona/configusuario?success=true";
		} else {
			url = "redirect:/persona/configusuario?success=false";
		}

		return url;
	}
	
	@GetMapping("/configusuario")
	public String nav_usuario(Model model) {
		model.addAttribute("persona", new PersonaDTO());
		model.addAttribute("listaPersonas",  servicioPersona.listarPersonas());
		return "/configuracion/usuario";
	}
	
	
	
	
	

}
