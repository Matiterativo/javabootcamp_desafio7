package ejercicio_2;

import java.util.ArrayList;

public class TorreDeControl {
	
	private ArrayList<Volador> voladores;
    private Operador operador;

    public TorreDeControl(ArrayList<Volador> voladores, Operador operador) {
        this.voladores = voladores;
        this.operador = operador;
    }

    public void gestionarAterrizaje() {
        for (Volador volador : voladores) {
            if (volador instanceof IAterrizaje) {
                System.out.println("Nave autorizada a aterrizar en pista 1");
            } else {
            		
            	System.out.println("Nave solicita autorización de aterrizaje.");
            	
                if (operador.autorizarAterrizaje()) {
                    System.out.println("Nave autorizada a aterrizar en pista 2");
                } else {
                    System.out.println("Autorización de aterrizaje denegada");
                }
            }
        }
    }

}
