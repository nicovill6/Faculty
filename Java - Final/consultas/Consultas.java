package consultas;
import Clases.Helper;
import Clases.Libro;
import Clases.SocioBiblioteca;
import EstructurasDeDatos.*;
import registros.RegistroLibros;

import java.util.Scanner;

public class Consultas {
    private Scanner input=new Scanner(System.in);

    //region 1)Mostrar todo los libros
    //Libros de la biblioteca: se presenta la información de todos los libros que tiene la biblioteca.

    public static void mostrarTodosLosLibros(Libro[] arregloLibros){

        System.out.println("\n== LIBROS DE LA BIBLIOTECA ==\n");
        int contador=1;  

        if(arregloLibros.length==0){
            System.out.println("Aun no hay libros registrados en la biblioteca");
            return;
        }

        for(int i=0; i<arregloLibros.length;i++){
            if(arregloLibros[i]!=null){             //por si no completa el arreglo
                System.out.println(contador+". "+arregloLibros[i]);
                contador++;
            }
        }

        System.out.println(contador-1+" Libros disponibles");
    }


    //region 2)Mostrar los usuarios
    //Usuarios de la biblioteca: se presenta la información de todos los usuarios asociados a la biblioteca.

    public static void mostrarTodosLosUsuarios(SocioBiblioteca[] arregloSociosBiblioteca){

        System.out.println("== SOCIOS DE LA BIBLIOTECA ==");
        int contador=0;
        if(arregloSociosBiblioteca.length==0){
            System.out.println("Aun no hay usuarios registrados en la biblioteca");
            return;
        }

        for(int i=0;i<arregloSociosBiblioteca.length;i++){
            if(arregloSociosBiblioteca[i]!=null){
                System.out.println(contador+". "+arregloSociosBiblioteca[i]);
                contador++;
            }
        }

        System.out.println(contador-1+"Socios registrados");
    }

    //region 3)Monto total libros prestados
    //Monto total al que ascienden los libros que se encuentran en préstamo en un momento dado.

    public static void montoTotalLibrosPrestados(Libro[] arreLibros){
        System.out.println("== MONTO TOTAL DE LIBROS PRESTADOS ==");
        if(arreLibros.length==0){
            System.out.println("Aun no se registraron libros en la biblioteca");
            return;
        }
        float montoTotal=0;
        
        for(int i=0;i<arreLibros.length;i++){
            Libro libro=arreLibros[i];
            if(libro!=null && !libro.getDisponible()){
                float precioLibro=libro.getPrecio();
                montoTotal+=precioLibro;
            }
        }

         System.out.println("Monto total de los libros prestados: $" + String.format("%.2f", montoTotal));
    }

    //region 4)Buscar libros por autor
    /*Libros de un autor (búsqueda por subcadena). En este caso, se debe obtener una lista enlazada con los libros
    cuyo autor contenga la subcadena indicada*/

    public static SimpleLinkedList <Libro> librosDeUnAutor(RegistroLibros gestorLibros){
        Libro[] arreLibros=gestorLibros.getLibros();
        SimpleLinkedList <Libro> librosAutor=new SimpleLinkedList<>();
        
        if(arreLibros.length==0){
            System.out.println("Aun no hay libros registrados en la biblioteca");
            return librosAutor;
        }
        
        System.out.println("\nIngrese el nombre del autor que desea buscar: ");
        String autorBuscado=Helper.validarCadena().toLowerCase();
        
        if(autorBuscado.length()<3){
            System.out.println("\n(Sugerencia: Puede ingresar mas letras para obtener una busqueda mas precisa)\n");
        }

        for(int i=0;i<arreLibros.length;i++){
            Libro libro=arreLibros[i];

            if(libro!=null){
                String autorActual=libro.getAutor().toLowerCase();
                if(autorActual.contains(autorBuscado)){
                  librosAutor.addLast(libro);
            }
          }
        }

        return librosAutor;
    }

    
    //region 5)Mostrar usuarios por x cant de libros
    /*Usuarios cuya cantidad de libros prestados es igual o mayor a un valor dado. En este caso, se debe obtener una
    lista enlazada con los usuarios que se han prestado una cantidad igual o superior a x (siendo x un valor dado
    por el usuario). */

    public static SimpleLinkedList <SocioBiblioteca> usuariosConXCantLibros(SocioBiblioteca[] sociosBiblioteca){
        SimpleLinkedList<SocioBiblioteca> sociosConXPrestamos=new SimpleLinkedList<>();

        if(sociosBiblioteca.length==0){
            System.out.println("Aun no hay socios registrados en la biblioteca");
            return sociosConXPrestamos;
        }
        
        
        System.out.println("\n== Filtrar usuarios con al menos x cantidad de libros prestados ==\n");
        int cantPrestamos=Helper.getPositiveInt("Ingrese la cantidad minima de prestamos que debe tener un usuario: ");

        for(int i=0;i<sociosBiblioteca.length;i++){
            SocioBiblioteca socio=sociosBiblioteca[i];
            if(socio!=null && socio.getLibrosPrestados()>=cantPrestamos){
                sociosConXPrestamos.addLast(sociosBiblioteca[i]);
            }
        }

        return sociosConXPrestamos;
    }
        
}

