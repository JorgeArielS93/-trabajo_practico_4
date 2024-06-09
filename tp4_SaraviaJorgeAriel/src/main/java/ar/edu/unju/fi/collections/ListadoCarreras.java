package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;

public class ListadoCarreras {
	public static List<Carrera> carreras = new ArrayList<>();

	/** Metodo listar arraylist de carreras */
	public static List<Carrera> getCarreras() {
		
		return carreras;
	}
	
	/** Metodo para buscar una carrera por ID con for iterable*/
	public static Carrera buscarCarreraPorCodigo(String codigo) {
		for (Carrera carrera : carreras) {
			if (carrera.getCodigo().equalsIgnoreCase(codigo)) {
				return carrera;
			}
		}
		/** si no lo encuentra devuelve nulo */
		return null;
	}
	
	/**Agregar una carrera */
	public static void agregarUnaCarrera(Carrera carrera) {
		carreras.add(carrera);
	}
	
	/** modificar una carrera */
	public static void modificarUnaCarrera(Carrera carrera) {
		for (Carrera c : carreras) {
			if (c.getCodigo().equalsIgnoreCase(carrera.getCodigo())) {
				c=carrera;
				break;
			}
		}
	}
	
	/** eliminar una carrera  con programacion funcional*/
	public static void eliminarUnaCarrera(String codigo) {
		carreras.removeIf(c -> c.getCodigo().equals(codigo));
	}
}
