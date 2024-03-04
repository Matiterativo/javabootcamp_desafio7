package ejercicio_3;

import ejercicio_3.exception.NoExisteElementoException;

public class CollectionCustom<E> {
	
	private E[] coleccion;
    private int size;
	
    
    @SuppressWarnings("unchecked")
	public CollectionCustom(int capacidad) {
		this.coleccion = (E[]) new Object[capacidad];
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	
	//Agrega al final de la coleccion
	@SuppressWarnings("unchecked")
	public void addLast(E elemento) {
		//Si se alcanzo la capacidad maxima, amplio la capacidad
		if (this.size == this.coleccion.length) {
			E[] coleccionAmpliada = (E[]) new Object[this.coleccion.length + 1];
			System.arraycopy(this.coleccion, 0, coleccionAmpliada, 0, this.size);
			this.coleccion = coleccionAmpliada;			
		}
		this.coleccion[this.size] = elemento;
        size++;		
	}
	
	
	@SuppressWarnings("unchecked")
	public void addFirst(E elemento) {
		//Si se alcanzo la capacidad maxima, amplio la capacidad
		if (this.size == this.coleccion.length) {
			E[] coleccionAmpliada = (E[]) new Object[coleccion.length + 1];
			System.arraycopy(this.coleccion, 0, coleccionAmpliada, 1, this.size);
			this.coleccion = coleccionAmpliada;			
		} else {		
			//Si no se alcanzo la capacidad maxima corro los elementos hacia la derecha
			System.arraycopy(coleccion, 0, coleccion, 1, this.size);
		}
		
		coleccion[0] = elemento;
		size++;
	}
	
	
	
	public void add(E elemento) {
		this.addLast(elemento);
	}

	
	//METODO SOLO PARA TESTEAR - BORRAR
	public void imprimirElementos() {		
		for (int i = 0; i < this.size; i++) {          
			System.out.println(this.coleccion[i]);          
        }	
	}
	
	public E remove(E elemento) throws NoExisteElementoException{
		
		//Busco indice de primer elemento
		int indice = -1;
        for (int i = 0; i < this.size; i++) {
            if (coleccion[i].equals(elemento)) {
                indice = i;
                break;
            }
        }
        
        //Si el elemento no existe devuelvo una excepcion
        if (indice == -1) {
            throw new NoExisteElementoException("El elemento no existe en la colección");
        }
		
		//Si el elemento existe sobreescribo los valores (corro todos a la izqueirda)
        for (int i = indice; i < this.size - 1; i++) {
            this.coleccion[i] = this.coleccion[i + 1];
        }
        
		
		//Descremento el tamaño de la coleccion
		this.size--;
		
		//Retorno el elemento eliminado
		return elemento;
		
	}
	
	public boolean empty() {
		return this.size ==0;
	}
	
	
	public void removeAll(E elemento) throws NoExisteElementoException {
		
		//Detecto si existe el elemento para devolver excepcion caso contrario
		boolean existeElemento = false;

		
	    // Debo recorrer todo el arreglo para eliminar cada una de las ocurrencias
		for (int i = 0; i < this.size; i++) {
	        if (coleccion[i].equals(elemento)) {
	        	
	        	//Si el elemento existe sobreescribo los valores (corro todos a la izqueirda)
	            for (int j = i; j < this.size - 1; j++) {
	                this.coleccion[j] = this.coleccion[j + 1];
	            }
	            this.size--;
	            
	            existeElemento = Boolean.TRUE;
	        }
	    } 

	    // Si el elemento no existe, lanzar una excepción
	    if (!existeElemento) {
	        throw new NoExisteElementoException("El elemento no existe en la colección");
	    }		
		
		
	}
    

}
