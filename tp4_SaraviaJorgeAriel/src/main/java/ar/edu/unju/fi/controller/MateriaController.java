package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    Materia materia;

    @GetMapping("/formularioMateria")
    public ModelAndView getFormulario() {
        ModelAndView mv = new ModelAndView("formMateria");
        mv.addObject("materia", materia);
        mv.addObject("isEdit", false);
        return mv;
    }

    @GetMapping("/listaMaterias")
    public ModelAndView getListaMaterias() {
        ModelAndView mv = new ModelAndView("listaMaterias");
        mv.addObject("materias", ListadoMaterias.getListaMaterias());
        return mv;
    }

    @PostMapping("/guardarMateria")
    public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia) {
        if (materia.getCodigo() != null && !materia.getCodigo().isEmpty()) {
            ListadoMaterias.actualizarMateria(materia);
        } else {
            ListadoMaterias.agregarUnaMateria(materia);
        }
        return new ModelAndView("redirect:/materia/listaMaterias");
    }

    @GetMapping("/modificar/{codigo}")
    public ModelAndView modificarMateria(@PathVariable("codigo") String codigo) {
        ModelAndView mv = new ModelAndView("formMateria");
        mv.addObject("materia", ListadoMaterias.findMateriaByCodigo(codigo));
        mv.addObject("isEdit", true);
        return mv;
    }

    @GetMapping("/borrarMateria/{codigo}")
    public ModelAndView deleteMateria(@PathVariable("codigo") String codigo) {
        ListadoMaterias.eliminarUnaMateria(codigo);
        return new ModelAndView("redirect:/materia/listaMaterias");
    }
}
