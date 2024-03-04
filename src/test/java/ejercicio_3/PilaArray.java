package ejercicio_3;

import ejercicio_3.exception.NoExisteElementoException;

public class PilaArray {
	
	private Integer [] pila;
	private int contador;
	
	public PilaArray(int capacidad) {
		this.pila = new Integer[capacidad];
		this.contador =0;
	}
	
	public boolean estaVacia(){
		//TODO
		return false;
	}
	
	public boolean aniadir(Integer elemento) {
		//TODO
		return false;
	}
	
	public Integer primero() throws NoExisteElementoException{
		//TODO
		return null;
	}
	
	public Integer extraer() throws NoExisteElementoException{
		//TODO
		return null;
	}
	
}
