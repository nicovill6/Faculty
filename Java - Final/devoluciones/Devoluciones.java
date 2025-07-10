package devoluciones;
import java.time.LocalDate;
import Clases.*;
import EstructurasDeDatos.*;


public class Devoluciones {

	public Devoluciones(){

	}

	private static SocioBiblioteca buscarSocio(SocioBiblioteca[] socios) {
	    	SocioBiblioteca buscado = new SocioBiblioteca(Helper.getInt("Ingresa el DNI del usuario: "));
	    	for (SocioBiblioteca socio : socios) {
	    		if (socio != null && socio.compareTo(buscado) == 0) {
	            return socio;
	    		}
	    	}
	    	return null;  
	    }
	    private static Libro buscarlibro(BinarySearchTree <Libro> libros) {
	    	Integer codex = Helper.getInt("Ingresa un codigo");
	    	Libro buscado = new Libro(codex);
	    	if (libros.find(buscado) != null) {
	            return libros.find(buscado);  
	    	}
			else{
				System.out.println("Libro no encontrado.");
			}
	    	return null;  
	    }

	    public static void devolver (BinarySearchTree <Libro> libros , SocioBiblioteca[] socios, Stack<Operacion> operaciones){

	        SocioBiblioteca socio1 = buscarSocio(socios);
	        Libro libro1 = buscarlibro(libros);

	        if (socio1==null) {
	        	System.out.println("Error: Socio no encontrado.");
				return;
	        }
	        if(libro1==null) {
	        	System.out.println("Error: Libro no encontrado.");
	        	return;
	        }
	        else if(libro1.getDisponible() == false){
	            libro1.setDisponible(true);
	            socio1.setLibrosPrestados(socio1.getLibrosPrestados() - 1);
				System.out.println("Cargue el detalle de la fecha de operacion: ");
	            LocalDate fechaOperacion= Helper.validarFecha();
	            operaciones.push(new Operacion(libro1, socio1,fechaOperacion));
	        }
	        else{
	            System.out.println("Libro no disponible. Socio agregado a la cola de pendientes.");
	        }

	    }   
	} 
	

