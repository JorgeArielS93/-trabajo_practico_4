package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.*;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
	private String codigo;
    private String nombre;
    private String curso;
    private int cantidadHoras;
    private String modalidad;
    
    @Autowired
    private Docente docente;
}
