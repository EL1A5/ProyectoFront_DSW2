package com.cliente.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.PersonaDTO;
import com.cliente.model.DTO.RptaServerDTO;
import com.cliente.service.PersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	
	@Autowired
	PersonaService servicioPersona;
	
	@PostMapping("/configPersonaRegistrar")
	public String registrarPersona(@ModelAttribute PersonaDTO persona) {
		String url = "";
		System.out.println("Codigo :" +persona.getCodigo());
		System.out.println("Nombre: " +persona.getNombre());
		System.out.println("Apellido : " +persona.getApellido());
		System.out.println("Documento : " +persona.getDocumento());
		System.out.println("Celular : " +persona.getCelular());
		System.out.println("Telefono : " +persona.getTelefono());
		System.out.println("tipo usuario : " +persona.getTipoUsuario());
		
		RptaServerDTO rpta;
		if (persona.getCodigo() == 0) {
			rpta = servicioPersona.insertarPersonas(persona);
		}else {
			rpta = servicioPersona.actualizarPersonas(persona);
		}
	
		if (rpta!= null) {
			if (rpta.getCodigo()== 1) {
				url = "redirect:/persona/configusuario?success=true";
			} else {
				url = "redirect:/persona/configusuario?success=false";
			}
		}else {
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
