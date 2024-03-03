package ejercicio_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		final String MENSAJE_INICIO ="CONTROL DE ALUMNOS Y NOTAS \n---------------------------";
		final String MENSAJE_CANTIDAD_ALUMNOS ="Ingrese la cantidad de alumnos a procesar: ";
		
		Scanner teclado = new Scanner(System.in);
	
		System.out.println(MENSAJE_INICIO);		
		
		int cantidadAlumnos = solicitarEnteroValido(teclado, MENSAJE_CANTIDAD_ALUMNOS);
		
		ArrayList<Alumno> alumnos = leerAlumnosyNotas(teclado, cantidadAlumnos);
		
		
		imprimirAlumnosCalificacionMasAlta(alumnos);
		imprimirAlumnosCalificacionMasBaja(alumnos);
		imprimirAlumnosPromocion(alumnos);
		imprimirAlumnosRecursan(alumnos);		
		
		teclado.close();	
		
	}
	
	private static int solicitarEnteroValido(Scanner teclado, String mensaje) {
		
		boolean numeroValido=false;
		int numero=0;
		
		while (!numeroValido) {
			
		    System.out.println(mensaje);
		    
		    if (teclado.hasNextInt()) {
		        numero = teclado.nextInt();
		        numeroValido = true;
		    } else {
		        System.out.println("Error: Ingrese un número entero válido.");
		        teclado.next();
		    }
		    
		}
		
		teclado.nextLine();
		
		return numero;
	}
	
	private static double solicitarNotaValida(Scanner teclado, String mensaje) {
		
		
		boolean numeroValido=false;
		double numero=0;
		
		while (!numeroValido) {
			
		    System.out.println(mensaje);
		    
		    if (teclado.hasNextDouble()) {
		        numero = teclado.nextDouble();
		        if (numero>=0 && numero <=10) {
		        	numeroValido = true;
		        }else {
		          System.out.println("Error: la nota debe tener un valor entre 0 y 10");
		        }
		    } else {
		        System.out.println("Error: Ingrese un número decimal válido.");
		        teclado.next();
		    }
		    
		}
		
		teclado.nextLine();
		
		return numero;
	}
		
	private static ArrayList<Alumno> leerAlumnosyNotas(Scanner teclado, int cantidadAlumnos) {
		
		ArrayList<Alumno> alumnos = new ArrayList<>();
		
		for (int i = 0; i < cantidadAlumnos; i++) {
			 
	            System.out.println("\nDatos de nuevo alumno:");
	            System.out.print("Nombre: ");
	            String nombre = teclado.nextLine();
	            System.out.print("Apellido: ");
	            String apellido = teclado.nextLine();
	            Alumno alumno = new Alumno(nombre, apellido);
	            
	       
	            int nroExamen;
	            
				do {
	            
	            	nroExamen = solicitarEnteroValido(teclado, "Nro de examen (0 para finalizar): ");
	            	
	            	if (nroExamen !=0) {
	            		double nota= solicitarNotaValida(teclado, "Ingrese nota del examen: ");
	            		Examen examen = new Examen(nroExamen, nota);
	            		alumno.agregarExamen(examen);
	            	}
	            	
	            }
	            while (nroExamen !=0);
	            
				alumnos.add(alumno);
			      
		 }
		
		return alumnos;
		
	};

	private static void imprimirAlumnosCalificacionMasAlta(ArrayList<Alumno> alumnos) {
		//obtengo la calificacion mas alta
		double notaMasAlta=-1;
		
		for (Alumno alumno : alumnos) {
		    for (Examen examen : alumno.getExamenes()) {
		        if (examen.getNota() > notaMasAlta) {
		        	notaMasAlta = examen.getNota();
		        };
		    }
		}		
		
		System.out.println("\nLa nota mas alta fue: " + notaMasAlta);
		System.out.println("\nLos alumnos con la nota mas alta son: \n");
		
		
		//imprimo los alumnos con la calificacion mas alta
		for (Alumno alumno : alumnos) {
		    for (Examen examen : alumno.getExamenes()) {
		        if (examen.getNota() == notaMasAlta) {
		        	System.out.println(alumno.getApellido() +", "+ alumno.getNombre());
		        };
		    }
		}		
	}
	
	private static void imprimirAlumnosCalificacionMasBaja(ArrayList<Alumno> alumnos) {
		//obtengo la calificacion mas baja
		double notaMasBaja=11;
		
		for (Alumno alumno : alumnos) {
		    for (Examen examen : alumno.getExamenes()) {
		        if (examen.getNota() < notaMasBaja) {
		        	notaMasBaja = examen.getNota();
		        };
		    }
		}	
		
		System.out.println("\nLa nota mas baja fue: " + notaMasBaja);
		System.out.println("\nLos alumnos con la nota mas baja son: \n");
		
		//imprimo los alumnos con la calificacion mas baja
		for (Alumno alumno : alumnos) {
		    for (Examen examen : alumno.getExamenes()) {
		        if (examen.getNota() == notaMasBaja) {
		        	System.out.println(alumno.getApellido() +", "+ alumno.getNombre());
		        };
		    }
		}		
	}
	
	private static void imprimirAlumnosPromocion(ArrayList<Alumno> alumnos) {
		//imprimo los alumnos con promedio mayor o igual a 7
		System.out.println("\nLos alumnos que promocionan son: \n");
		for (Alumno alumno : alumnos) {
		   if (alumno.getPromedio() >= 7) {
			   System.out.println(alumno.getApellido() +", "+ alumno.getNombre());    
		   }
		}		
		
	}
	
	private static void imprimirAlumnosRecursan(ArrayList<Alumno> alumnos) {
		//imprimo los alumnos con promedio menor a 7
		System.out.println("\nLos alumnos que recursan son: \n");
		for (Alumno alumno : alumnos) {
		   if (alumno.getPromedio() < 7) {
			   System.out.println(alumno.getApellido() +", "+ alumno.getNombre());    
		   }
		}		
		
	}



}
