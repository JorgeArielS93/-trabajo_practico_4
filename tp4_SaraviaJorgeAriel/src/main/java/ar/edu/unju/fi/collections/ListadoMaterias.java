package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {
    private static List<Materia> listaMaterias = new ArrayList<Materia>();
    private static int nextId = 1; // Inicializamos el id
    
    public static List<Materia> getListaMaterias() {
        if (listaMaterias.isEmpty()) {
            listaMaterias.add(new Materia(generateCodigo(), "Matemáticas", "1A", 5, "Presencial", new Docente(1, "Juan", "Martinez", "juan.martinez@example.com", "123456789")));
            listaMaterias.add(new Materia(generateCodigo(), "Física", "1B", 4, "Online", new Docente(2, "Maria", "Rodriguez", "maria.rodriguez@example.com", "987654321")));
            listaMaterias.add(new Materia(generateCodigo(), "Química", "2A", 6, "Presencial", new Docente(3, "Carlos", "Sanchez", "carlos.sanchez@example.com", "234567890")));
            listaMaterias.add(new Materia(generateCodigo(), "Historia", "2B", 3, "Online", new Docente(4, "Ana", "Fernandez", "ana.fernandez@example.com", "345678901")));
            listaMaterias.add(new Materia(generateCodigo(), "Geografía", "3A", 5, "Presencial", new Docente(5, "Luis", "Garcia", "luis.garcia@example.com", "456789012")));
        }
        return listaMaterias;
    }

    private static String generateCodigo() {
        return "MAT" + nextId++;
    }
    
    /** Metodo para buscar una materia por código */
    public static Materia findMateriaByCodigo(String codigo) {
        for (Materia materia : listaMaterias) {
            if (materia.getCodigo().equals(codigo)) {
                return materia;
            }
        }
        return null; // Si no lo encuentra, devuelve nulo
    }

    /** Agregar una materia */
    public static void agregarUnaMateria(Materia materia) {
        materia.setCodigo(generateCodigo());
        //materia.setDocente(ListadoDocentes.findDocenteByLegajo(materia.getDocente().getLegajo()));
        listaMaterias.add(materia);
    }

    /** Actualizar una materia */
    public static void actualizarMateria(Materia materia) {
        for (int i = 0; i < listaMaterias.size(); i++) {
            if (listaMaterias.get(i).getCodigo().equals(materia.getCodigo())) {
                listaMaterias.set(i, materia);
                return;
            }
        }
    }

    /** Eliminar una materia con programación funcional */
    public static void eliminarUnaMateria(String codigo) {
        listaMaterias.removeIf(m -> m.getCodigo().equals(codigo));
    }
}
