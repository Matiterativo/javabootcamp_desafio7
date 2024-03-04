package ejercicio_2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// Creo una lista de objetos voladores, en este caso extienden de la clase padre Volador
		// aunque podrian no hacerlo si implementaran la interfaz
		
        ArrayList<IAterrizaje> objetosVoladores = new ArrayList<>();
        
        //Creo tres instancias de clases con herencia de Volador
        objetosVoladores.add(new Avion());
        objetosVoladores.add(new Avion());
        objetosVoladores.add(new UFO());
        objetosVoladores.add(new UFO());
        
        //Creo el operador con legajo 4823 que va a autorizar aterrizajes que no cumplan contrato
        Operador operador = new Operador(4823);

        // Crear una instancia de la TorreControl y le paso los aterrizajes a gestionar y el operador encargado de hacerlo
        TorreDeControl torreControl = new TorreDeControl(objetosVoladores, operador);
        
        // Proceso los objetov voladores solicitando autorizacion al operador en caso de no cumplir el contrato de aterrizaje
        torreControl.gestionarAterrizaje();

	}

}
