package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/formularioCarrera")
    public ModelAndView getFormCarrera() {
        ModelAndView modelView = new ModelAndView("formCarrera");
        modelView.addObject("carrera", unaCarrera);
        modelView.addObject("isEdit", false);
        return modelView;
    }

    @GetMapping("/listaCarreras")
    public ModelAndView listaCarreras() {
        ModelAndView modelView = new ModelAndView("listaCarreras");
        modelView.addObject("listaCarreras", ListadoCarreras.getCarreras());
        return modelView;
    }

    @PostMapping("/guardar")
    public ModelAndView postPageSaveCarrera(@ModelAttribute("carrera") Carrera c) {
        if (c.getCodigo() != null && !c.getCodigo().isEmpty()) {
            ListadoCarreras.actualizarCarrera(c);
        } else {
            ListadoCarreras.agregarCarrera(c);
        }
        ModelAndView mv = new ModelAndView("redirect:/carrera/listaCarreras");
        return mv;
    }

    @GetMapping("/modificar/{codigo}")
    public ModelAndView modificarCarrera(@PathVariable("codigo") String codigo) {
        ModelAndView mv = new ModelAndView("formCarrera");
        mv.addObject("carrera", ListadoCarreras.findCarreraByCodigo(codigo));
        mv.addObject("isEdit", true);
        return mv;
    }

    @GetMapping("/borrar/{codigo}")
    public ModelAndView borrarCarrera(@PathVariable("codigo") String codigo) {
        ListadoCarreras.eliminarCarrera(codigo);
        ModelAndView mv = new ModelAndView("redirect:/carrera/listaCarreras");
        return mv;
    }
}
