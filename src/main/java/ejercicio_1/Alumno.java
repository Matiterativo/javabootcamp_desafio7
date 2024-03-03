package ejercicio_1;

import java.util.ArrayList;

public class Alumno {

	private String nombre;
    private String apellido;
    private ArrayList<Examen> examenes;
    
    public Alumno(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;	
		this.examenes = new ArrayList<Examen>();
	}    
    
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
    
    public void agregarExamen(Examen examen) {
    	
    	this.examenes.add(examen);
	
    }

	public ArrayList<Examen> getExamenes() {
		return examenes;
	}
    
    public double getPromedio() {

		if (examenes.isEmpty()) {
            return 0;
        }

        double total = 0;
        for (Examen examen : examenes) {
            total += examen.getNota();
        }

        return total / examenes.size();
    }
    

}