package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	@Autowired
	private Carrera unaCarrera;
	
	@GetMapping("/formuarioCarrera")
	public ModelAndView getFormCarrera() {
		// vista formCarrera.html
		ModelAndView modelView = new ModelAndView("formCarrera");
		// agregar el objeto
		modelView.addObject("carrera",unaCarrera);
		return modelView;
	}
	
	@GetMapping ("/listaCarrera")
	public ModelAndView listaCarreras() {
		ModelAndView modelView = new ModelAndView("listaCarreras");
		modelView.addObject("listaCarreras",ListadoCarreras.getCarreras());
		return modelView;
	}
	
	@PostMapping("/guardar")
	public ModelAndView postPageSaveCarrera(@ModelAttribute("carrera") Carrera c) {
		return null;
		
	}
}
