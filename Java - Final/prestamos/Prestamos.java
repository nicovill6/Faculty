package prestamos;
import java.time.LocalDate;
import Clases.*;
import EstructurasDeDatos.*;


public class Prestamos {


    public Prestamos(){

    }


    public Libro buscarlibro(BinarySearchTree<Libro> libros) {
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

    public void prestamo (BinarySearchTree<Libro> arbol , SocioBiblioteca[] socios, Stack<Operacion> operaciones, Queue<SocioBiblioteca> pendientes){

        SocioBiblioteca socio1 = buscarSocio(socios);
        Libro libro1 = buscarlibro(arbol);

        if (socio1 == null || libro1 == null) {
        System.out.println("Error: Socio o libro no encontrado.");
        return;}

        if(libro1.getDisponible()){
            libro1.setDisponible(false);
            socio1.setLibrosPrestados(socio1.getLibrosPrestados() + 1);
            operaciones.push(new Operacion(libro1, socio1, LocalDate.of(2025, 6, 15)));
            System.out.println("Préstamo realizado exitosamente.");
        }
        else{
            pendientes.add(socio1);
            System.out.println("Libro no disponible. Socio agregado a la cola de pendientes.");

        }

    }

    public SocioBiblioteca buscarSocio(SocioBiblioteca[] socios) {
    Integer dniBuscado = Helper.getInt("Ingresa un dni");
    SocioBiblioteca buscado = new SocioBiblioteca(dniBuscado);
    for (SocioBiblioteca socio : socios) {
        if (socio != null && socio.compareTo(buscado) == 0) {
            return socio;
        }
    }
    return null;  
    }





    








    
}
