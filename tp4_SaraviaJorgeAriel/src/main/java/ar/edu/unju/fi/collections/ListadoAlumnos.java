package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;
@Component
public class ListadoAlumnos {
	public static List<Alumno> alumnos = new ArrayList<>();
	private static int nextLu = 1; // Inicializamos el LU

	/** Metodo listar arraylist de alumnos */
	public static List<Alumno> getAlumnos() {
	    if (alumnos.isEmpty()) {
	        alumnos.add(new Alumno(12345678, "Juan", "Perez", "juan.perez@example.com", "123456789", LocalDate.of(1995,5,15), "Calle Falsa 123",nextLu++));
	        alumnos.add(new Alumno(87654321, "Maria", "Gomez", "maria.gomez@example.com", "987654321", LocalDate.of(1996,6,25), "Av. Siempre Viva 456", nextLu++));
	        alumnos.add(new Alumno(23456789, "Carlos", "Lopez", "carlos.lopez@example.com", "234567890", LocalDate.of(1997,7,30), "Calle Luna 789", nextLu++));
	        alumnos.add(new Alumno(34567890, "Ana", "Martinez", "ana.martinez@example.com", "345678901", LocalDate.of(1998,8,20), "Av. Sol 321", nextLu++));
	        alumnos.add(new Alumno(45678901, "Luis", "Hernandez", "luis.hernandez@example.com", "456789012", LocalDate.of(1999,9,10), "Calle Estrella 654", nextLu++));
	    }
	    return alumnos;
	}

	/** Metodo para buscar un alumno por LU con for iterable */
	public static Alumno findAlumnoById(int lu) {
		for (Alumno alumno : alumnos) {
			if (alumno.getLu()==lu) {
				return alumno;
			}
		}
		/** si no lo encuentra devuelve nulo */
		return null;
	}
	
	/**Agregar un alumno */
	public static void agregarUnAlumno(Alumno alumno) {
		alumno.setLu(nextLu++);
		alumnos.add(alumno);
	}
	
	/** Actualizar un alumno */
    public static void actualizarAlumno(Alumno alumno) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getLu() == alumno.getLu()) {
                alumnos.set(i, alumno);
                return;
            }
        }
    }
	
	/** eliminar una carrera  con programacion funcional*/
	public static void eliminarUnAlumno(int lu) {
		alumnos.removeIf(a -> a.getLu()==(lu));
	}
}
