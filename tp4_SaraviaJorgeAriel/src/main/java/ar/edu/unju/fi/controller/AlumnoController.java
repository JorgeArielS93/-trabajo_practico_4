package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private Alumno unAlumno;

    @GetMapping("/formularioAlumno")
    public ModelAndView getFormulario() {
        ModelAndView mv = new ModelAndView("formAlumno");
        mv.addObject("alumno", unAlumno);
        mv.addObject("isEdit", false);
        return mv;
    }

    @GetMapping("/listaAlumnos")
    public ModelAndView listaCarreras() {
        ModelAndView mv = new ModelAndView("listaAlumnos");
        mv.addObject("listaAlumnos", ListadoAlumnos.getAlumnos());
        return mv;
    }

    @PostMapping("/guardarAlumno")
    public ModelAndView postSaveAlumno(@ModelAttribute("alumno") Alumno alumno) {
        if (alumno.getLu() != null && alumno.getLu() > 0) {
        	ListadoAlumnos.actualizarAlumno(alumno);
        } else {
            ListadoAlumnos.agregarUnAlumno(alumno);
        }
        ModelAndView mv = new ModelAndView("redirect:listaAlumnos");
        return mv;
    }
    
    @GetMapping("/modificar/{lu}")
    public ModelAndView modificarAlumno(@PathVariable("lu") int lu) {
    	ModelAndView mv = new ModelAndView("formAlumno");
    	mv.addObject("alumno",ListadoAlumnos.findAlumnoById(lu));
    	mv.addObject("isEdit", true);
    	return mv;
    }
    
    @GetMapping("/borrarAlumno/{lu}")
    public ModelAndView deleteAlumno(@PathVariable("lu") int lu) {
    	ListadoAlumnos.eliminarUnAlumno(lu);
    	ModelAndView mv= new ModelAndView("redirect:/alumno/listaAlumnos");
    	return mv;
    }
}