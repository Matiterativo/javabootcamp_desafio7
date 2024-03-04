package ejercicio_3;

import ejercicio_3.exception.NoExisteElementoException;

public class MainTest {

	public static void main(String[] args) {
		
		//Testeo de la clase CollectionCustom
		
		CollectionCustom<Integer> coleccion = new CollectionCustom<>(1);
		
		//El tamaño antes de agregar cualquier elemento deberia ser 0
		
		System.out.println("Tamaño luego de crear coleccion custom: " + coleccion.size());
		
		//Agrego tres elementos con el metodo add() y addLast() que son equivalentes
		coleccion.add(5);
		coleccion.add(6);
		coleccion.addLast(25);
		
		
		//El tamaño despues de agregar 3 elementos deberia ser 3
		System.out.println("Tamaño luego de agregar tres elementos: " + coleccion.size());
		
		
		//Imprimo los elementos de la coleccion: el metodo imprimirElementos es solo de TESTEO, borrar al chequear
		//Deberia imprimir 5,6,25
		System.out.println("Iimprimo todos los elementos (metodo de testeo):");
		coleccion.imprimirElementos();
		
		//Agrego dos elementos al principio
		coleccion.addFirst(99);
		coleccion.addFirst(101);
		
		//Imprimo los elementos de la coleccion: el metodo imprimirelementos es solo de TESTEO, borrar al chequear
		//Deberia imprimir 101,99,5,6,25
		System.out.println("Iimprimo todos los elementos (metodo de testeo):");
		coleccion.imprimirElementos();
		
		
		//El tamaño actual deberia ser 5
		System.out.println("Tamaño actual de la coleccion al añadir dos elementos mas: " + coleccion.size());
		
		//Elimino el 99
		try {
			
			Integer removido = coleccion.remove(99);
			System.out.println("El elemento removido fue el: " + removido);
			System.out.println("El tamaño de la coleccion es: " + coleccion.size());
			
			//Intento remover un elemento inexistente. 77
			removido = coleccion.remove(77);
			
		} catch (NoExisteElementoException e) {
			System.out.println(e.getMessage());
		}
		
		//Deberia seguir siendo 4 el tamaño de la coleccion ya que 77 no existia
		System.out.println("El tamaño de la coleccion es: " + coleccion.size());
		
		
		//Elimino el resto de los elementos y luego imprimo con el metodo de TESTEO
		
		try {
			
			coleccion.remove(101);			
			coleccion.remove(5);
			coleccion.remove(6);
			coleccion.remove(25);
			
			System.out.println("El tamaño de la coleccion luego de eliminar todos los elementos es: " + coleccion.size());
			
		} catch (NoExisteElementoException e) {
			System.out.println(e.getMessage());
		}
		
		coleccion.imprimirElementos();
		
		//Indica si la coleccion esta vacia
		
		if (coleccion.empty() == Boolean.TRUE) {
			System.out.println("La coleccion está vacía");
		}else {
			System.out.println("La coleccion no está vacía");
		}
		
		//Agrego 6 elementos con repetidos: 5, 6, 4, 5, 8, 5
		
		System.out.println("Agrego 6 elementos");
		
		coleccion.add(5);
		coleccion.add(6);
		coleccion.add(4);
		coleccion.add(5);
		coleccion.add(8);
		coleccion.add(5);
		
		
		//Indica si la coleccion esta vacia
		
		if (coleccion.empty() == Boolean.TRUE) {
			System.out.println("La coleccion está vacía");
		}else {
			System.out.println("La coleccion no está vacía");
		}
		
		
		//Intento remover un elemento inexistente con el removeAll
		try {
			coleccion.removeAll(444);
		} catch (NoExisteElementoException e) {			
			System.out.println(e.getMessage());
		}
		
		
		//Elimino un elemento existente sin repetir con el removeAll
		try {
			coleccion.removeAll(4);
			
			//Imprimo la coleccion y su tamaño
			System.out.println("Los elementos de la coleccion luego de eliminar el 4 son: ");
			coleccion.imprimirElementos();
			System.out.println("El tamaño deberia ser 5 y es: " + coleccion.size());
			
		} catch (NoExisteElementoException e) {			
			System.out.println(e.getMessage());
		}
		
		
		
		//Remuevo todos los elementos = 5 e imprimo la coleccion y tamaño resultante
		try {
			coleccion.removeAll(5);
			System.out.println("Remuevo con removeAll el 5 y deberia quedar solo el 6 y el 8, y quedaron: ");
			coleccion.imprimirElementos();
			
		} catch (NoExisteElementoException e) {			
			System.out.println(e.getMessage());
		}
		

	}

}
