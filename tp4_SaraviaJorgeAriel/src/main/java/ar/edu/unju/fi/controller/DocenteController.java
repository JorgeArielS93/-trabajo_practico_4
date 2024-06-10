package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	@Autowired
	Docente docente;
	
	@GetMapping("formularioDocente")
	public ModelAndView getDormulario() {
		ModelAndView mv= new ModelAndView("formDocente");
		mv.addObject("maestro",docente);
		mv.addObject("isEdit", false);
        return mv;
	}
	
	@GetMapping("listaDocentes")
	public ModelAndView getListaDocentes() {
		ModelAndView mv= new ModelAndView("listaDocentes");
		mv.addObject("docentes",ListadoDocentes.getListaDocentes());
		return mv;
	}
	
	@PostMapping("guardarDocente")
	public ModelAndView guardarDocente(@ModelAttribute("maestro") Docente docente) {
		if (docente.getLegajo() != null && docente.getLegajo()>0) {
			ListadoDocentes.actualizarDocente(docente);
		}else {
			ListadoDocentes.agregarUnDocente(docente);
		}
		ModelAndView mv = new ModelAndView("redirect:listaDocentes");
		return mv;
	}
	
	 @GetMapping("/modificar/{legajo}")
	    public ModelAndView modificarDocente(@PathVariable("legajo") int legajo) {
	    	ModelAndView mv = new ModelAndView("formDocente");
	    	mv.addObject("maestro",ListadoDocentes.findDocenteByLegajo(legajo));
	    	mv.addObject("isEdit", true);
	    	return mv;
	    }
	    
	    @GetMapping("/borrarDocente/{legajo}")
	    public ModelAndView deleteDocente(@PathVariable("legajo") int legajo) {
	    	ListadoDocentes.eliminarUnDocente(legajo);
	    	ModelAndView mv= new ModelAndView("redirect:/docente/listaDocentes");
	    	return mv;
	    }
}
