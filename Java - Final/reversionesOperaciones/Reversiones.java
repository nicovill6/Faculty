package reversionesOperaciones;

import EstructurasDeDatos.*;
import Clases.*;

public class Reversiones {

    public static void deshacerOperacion(Stack<Operacion> acciones){
        if(acciones.isEmpty()){
            System.out.println("No hay operaciones para deshacer.");
            return;
        }

        Operacion operacion = acciones.pop();
        Libro libro = operacion.getLibro();
        SocioBiblioteca socio = operacion.getUsuario();
        String tipoOperacion = operacion.getTipoOperacion();

        if(tipoOperacion.equalsIgnoreCase("Préstamo")){
            libro.setDisponible(true);
            socio.setLibrosPrestados(socio.getLibrosPrestados() - 1);
            System.out.println("Se ha revertido el prestamo del libro: " + libro.getTituloLibro());
        }
        else if(tipoOperacion.equalsIgnoreCase("Devolución")){
            libro.setDisponible(false);
            socio.setLibrosPrestados(socio.getLibrosPrestados() + 1);
            System.out.println("Se ha revertido la devolucion del libro: " + libro.getTituloLibro());
        }
        else {
            System.out.println("Tipo de operacion desconocida: " + tipoOperacion);
        }
    }
}
