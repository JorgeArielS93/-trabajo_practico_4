package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.*;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
	private int dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    
    private String domicilio;
    private Integer lu;

    
}