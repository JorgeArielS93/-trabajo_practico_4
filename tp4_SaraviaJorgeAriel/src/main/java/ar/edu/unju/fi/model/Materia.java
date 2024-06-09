package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String codigo;
    private String nombre;
    private String curso;
    private int cantidadHoras;
    private String modalidad;
    private Docente docente;

    // Constructor
    
    public Materia() {
		// TODO Auto-generated constructor stub
	}
    
    public Materia(String codigo, String nombre, String curso, int cantidadHoras, String modalidad, Docente docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.curso = curso;
        this.cantidadHoras = cantidadHoras;
        this.modalidad = modalidad;
        this.docente = docente;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", nombre=" + nombre + ", curso=" + curso + ", cantidadHoras="
				+ cantidadHoras + ", modalidad=" + modalidad + "]";
	}
}
