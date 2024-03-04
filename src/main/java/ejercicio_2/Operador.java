package ejercicio_2;

import java.util.Scanner;

public class Operador {
	
	private int numeroEmpleado;

    public Operador(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public boolean autorizarAterrizaje() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Desea dar autorización para aterrizar? (indique número de opción) \n1.Si \n2.No");
        Integer opcion = teclado.nextInt(); 
        //teclado.close();
        return (opcion==1);
    }

	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
    
    

}
