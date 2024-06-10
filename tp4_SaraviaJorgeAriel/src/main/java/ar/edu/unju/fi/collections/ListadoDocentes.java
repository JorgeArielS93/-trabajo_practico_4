package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	public static List<Docente> listaDocentes = new ArrayList<Docente>();
	private static int nextLegajo = 1; // Inicializamos el legajo
	
	public static List<Docente> getListaDocentes() {
		if (listaDocentes.isEmpty()) {
            listaDocentes.add(new Docente(nextLegajo++, "Juan", "Martinez", "juan.martinez@example.com", "123456789"));
            listaDocentes.add(new Docente(nextLegajo++, "Maria", "Rodriguez", "maria.rodriguez@example.com", "987654321"));
            listaDocentes.add(new Docente(nextLegajo++, "Carlos", "Sanchez", "carlos.sanchez@example.com", "234567890"));
            listaDocentes.add(new Docente(nextLegajo++, "Ana", "Fernandez", "ana.fernandez@example.com", "345678901"));
            listaDocentes.add(new Docente(nextLegajo++, "Luis", "Garcia", "luis.garcia@example.com", "456789012"));
        }
		return listaDocentes;
	}
	
	/** Metodo para buscar un docente por legajo */
    public static Docente findDocenteByLegajo(int legajo) {
        for (Docente docente : listaDocentes) {
            if (docente.getLegajo() == legajo) {
                return docente;
            }
        }
        return null; // Si no lo encuentra, devuelve nulo
    }

    /** Agregar un docente */
    public static void agregarUnDocente(Docente docente) {
        docente.setLegajo(nextLegajo++);
        listaDocentes.add(docente);
    }

    /** Actualizar un docente */
    public static void actualizarDocente(Docente docente) {
        for (int i = 0; i < listaDocentes.size(); i++) {
            if (listaDocentes.get(i).getLegajo() == docente.getLegajo()) {
                listaDocentes.set(i, docente);
                return;
            }
        }
    }

    /** Eliminar un docente con programación funcional */
    public static void eliminarUnDocente(int legajo) {
        listaDocentes.removeIf(d -> d.getLegajo() == legajo);
    }
}