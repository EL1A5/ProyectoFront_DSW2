package com.cliente.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.AutenticacionDTO;
import com.cliente.model.DTO.AutenticacionResponseDTO;
import com.cliente.service.impl.UsuarioServiceImpl;

@Controller
@RequestMapping
public class LoginController {
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServiceImpl usuarioService;

	@RequestMapping({"/","/login"})
	public String inicio() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String salir() {
		return "logout";
	}
	
	
	
	@PostMapping("/autenticarUsuario")
	public String validarUsuario(HttpServletRequest request) {
		String url = "";
		String usuario = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("LoginController-validarUsuario-Usuario : " + usuario);
		System.out.println("LoginController-validarUsuario-password : " + password);
		AutenticacionDTO obj = new AutenticacionDTO();
		obj.setUsername(usuario);
		obj.setPassword(password);
		AutenticacionResponseDTO rpta = usuarioService.autenticar(obj);
		if (rpta != null) {
			System.out.println(rpta.getCodigo());
			System.out.println(rpta.getMensaje());
			
			
			if (rpta.getCodigo().equals("1")) {
				url = "redirect:/principal";
			}else {
				url = "redirect:/login?usuarioval=true";
			}	
		}else {
			url = "redirect:/login?usuarioval=true";
		}
		return url;
	}
	
	@GetMapping("/principal")
	public String principal() {
		return "principal";
	}
	
	
	
}
