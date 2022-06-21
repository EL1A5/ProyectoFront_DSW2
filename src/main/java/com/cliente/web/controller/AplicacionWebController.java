package com.cliente.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cliente.model.DTO.AplicacionDTO;
import com.cliente.service.AplicacionService;
import com.cliente.util.Paginas;



@Controller
@RequestMapping
public class AplicacionWebController {

	@Autowired
	AplicacionService serviceAplicacion;
	
	
	// http://localhost:9090/configaplicacion
	@GetMapping(value = "/configaplicaciones")
	
	public ModelAndView listarAplicaciones() {
		System.out.println("entra al metodo");
		ModelAndView modalview=new ModelAndView(Paginas.LISTA_APLICACION);
		return modalview;
	}
	
	
	@GetMapping("/configaplicacion")
	public String nav_aplcacion(Model model) {
		model.addAttribute("listaAplicaciones", serviceAplicacion.listarAplicacion());
		model.addAttribute("aplicacion", new AplicacionDTO());
		return "/configuracion/aplicacion";
	}
	
	@PostMapping("/configAplicacionRegistrar")
	public String registrarAplicacion(@ModelAttribute AplicacionDTO objAplicacion) {
		String url = "";
		System.out.println("ENTRA "+objAplicacion.getIdAplicacion() +" : "+ objAplicacion.getDescripcion());
		int insertar = serviceAplicacion.insertaActualizaAplicacion(objAplicacion);
		if (insertar > 0) {
			System.out.println("ENTRA AQUI");
			url = "redirect:/configaplicacion?success=true";
		} else {
			System.out.println("ENTRA ALLI");
			url = "redirect:/configaplicacion?success=false";
		}
		return url;
	}
	
	
}
