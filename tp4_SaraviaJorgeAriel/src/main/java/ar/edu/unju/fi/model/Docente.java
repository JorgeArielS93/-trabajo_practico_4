package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.*;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Docente {
	private Integer legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
