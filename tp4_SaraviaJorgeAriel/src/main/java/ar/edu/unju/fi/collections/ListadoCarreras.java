package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
    private static List<Carrera> listaCarreras = new ArrayList<Carrera>();
    private static int nextCodigo = 1; // Inicializamos el código
    
    public static List<Carrera> getCarreras() {
        if (listaCarreras.isEmpty()) {
            listaCarreras.add(new Carrera(generateCodigo(), "Ingeniería Informática", 5, true));
            listaCarreras.add(new Carrera(generateCodigo(), "Medicina", 6, true));
            listaCarreras.add(new Carrera(generateCodigo(), "Derecho", 4, true));
            listaCarreras.add(new Carrera(generateCodigo(), "Arquitectura", 5, true));
            listaCarreras.add(new Carrera(generateCodigo(), "Psicología", 5, true));
        }
        return listaCarreras;
    }
    
    private static String generateCodigo() {
        return "CAR" + nextCodigo++;
    } 
    public static Carrera findCarreraByCodigo(String codigo) {
        for (Carrera carrera : listaCarreras) {
            if (carrera.getCodigo().equals(codigo)) {
                return carrera;
            }
        }
        return null;
    }

    public static void agregarCarrera(Carrera carrera) {
        carrera.setCodigo(generateCodigo());
        listaCarreras.add(carrera);
    }

    public static void actualizarCarrera(Carrera carrera) {
        for (int i = 0; i < listaCarreras.size(); i++) {
            if (listaCarreras.get(i).getCodigo().equals(carrera.getCodigo())) {
                listaCarreras.set(i, carrera);
                return;
            }
        }
    }

    public static void eliminarCarrera(String codigo) {
        listaCarreras.removeIf(c -> c.getCodigo().equals(codigo));
    }
}
