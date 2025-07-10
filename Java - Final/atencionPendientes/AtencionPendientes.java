package atencionPendientes;
import Clases.*;
import EstructurasDeDatos.*;
import registros.RegistroLibros;
import java.util.Scanner;

public class AtencionPendientes {
    private Scanner input = new Scanner(System.in);

    public Scanner getInput() {
        return this.input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public static Libro verLibro(RegistroLibros gestorLibro){
        int codigoLibro = Helper.getInt("Ingrese el código del libro que desea buscar: ");
        Libro libroBuscado = gestorLibro.buscarPorCodigo(codigoLibro);
        if(libroBuscado != null) {
            System.out.println("Libro encontrado: " + libroBuscado);
        } else {
            System.out.println("Libro no encontrado.");
            return null;
        }

        return libroBuscado;
    }

    public static void atender(RegistroLibros gestorLibros, Queue<SocioBiblioteca> pendientes, Stack<Operacion> operaciones) {
        
        if(pendientes.isEmpty()){
            System.out.println("No hay socios pendientes para atender");
            return;
        }
        
        Libro libroBuscado = verLibro(gestorLibros);
        if(libroBuscado == null){
            System.out.println("Libro no encontrado.");
            return;
        }

        SocioBiblioteca socioAtendido = pendientes.poll();
        if(libroBuscado.getDisponible()){
            libroBuscado.setDisponible(false);
            socioAtendido.setLibrosPrestados(socioAtendido.getLibrosPrestados() + 1);
            operaciones.push(new Operacion(libroBuscado, socioAtendido, Helper.validarFecha()));
            System.out.println("Se ha atendido al socio: " + socioAtendido.apellidoNombre() + " con el libro: " + libroBuscado.getTituloLibro());
        }
        else{
            System.out.println("El libro no esta disponible para prestamo: ");
        }
    }
}
