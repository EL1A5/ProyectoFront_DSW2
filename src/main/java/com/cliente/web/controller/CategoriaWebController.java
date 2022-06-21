package com.cliente.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.model.DTO.CategoriaDTO;
import com.cliente.service.CategoriaService;


@Controller
@RequestMapping
public class CategoriaWebController {

	@Autowired
	CategoriaService serviceCategoria;

	
	@GetMapping("/configcategoria")
	public String nav_categoria(Model model) {

		model.addAttribute("listaCategorias", serviceCategoria.listarCategoria());
		model.addAttribute("categoria", new CategoriaDTO());
		return "/configuracion/categoria";
	}
	
	
	
	@PostMapping("/configCategoriaRegistrar")
	public String registrarCategoria(@ModelAttribute CategoriaDTO obj) {
		String url = "";
		int insertar = serviceCategoria.insertaActualizaCategoria(obj);
		if (insertar > 0) {
			url = "redirect:/configcategoria?primary=true";
		} else {
			url = "redirect:/configcategoria?alert=true";
		}
		return url;
	}
}
