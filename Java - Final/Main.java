
import Clases.*;
import EstructurasDeDatos.*;
import devoluciones.Devoluciones;
import prestamos.Prestamos;
import atencionPendientes.AtencionPendientes;
import consultas.Consultas;
import reversionesOperaciones.Reversiones;
import registros.RegistroLibros;
import registros.RegistroSocioBiblioteca;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree<Libro> arbolin= new BinarySearchTree<>();
        RegistroLibros gestorLibros = new RegistroLibros(100, arbolin);
        RegistroSocioBiblioteca gestorSocios = new RegistroSocioBiblioteca(100);
        Stack<Operacion> operaciones = new Stack<>();
        Queue<SocioBiblioteca> pendientes = new Queue<>();
        int opcion;
        boolean flag = true;
        while(flag){
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Gestion de Libros");
            System.out.println("2. Gestion de Socios");
            System.out.println("3. Prestamo de Libro"); 
            System.out.println("4. Devolucion de Libro"); 
            System.out.println("5. Deshacer Operacion"); 
            System.out.println("6. Atender Pendientes de Prestamo"); 
            System.out.println("7. Consultas"); 
            System.out.println("0. Salir");
            System.out.print("\nIngrese una opción: ");
            opcion = Helper.getInt("");
            switch (opcion) {
                case 1:
                    menuLibros(scanner, gestorLibros);
                    break;
                case 2:
                    menuSocios(scanner, gestorSocios);
                    break;
                case 3:
                    Prestamos prestamosGestor = new Prestamos();
                    prestamosGestor.prestamo(gestorLibros.getArbol(), gestorSocios.getSocios(), operaciones, pendientes);
                    break;
                case 4:
                    Devoluciones.devolver(gestorLibros.getArbol(), gestorSocios.getSocios(), operaciones);
                    break;
                case 5:
                    Reversiones.deshacerOperacion(operaciones);
                    break;
                case 6:
                    AtencionPendientes.atender(gestorLibros, pendientes, operaciones);
                    break;
                case 7:
                    menuConsultas(scanner, gestorLibros, gestorSocios);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    flag = false;
                    break;
                default:
                    opcion = Helper.getInt("Opción inválida. Ingrese una opción válida: ");
                    break;
                }
            }

        }

    public static void menuLibros(Scanner scanner, RegistroLibros gestorLibros) {
        int opcion;
        boolean flag = true;
        while(flag){
            System.out.println("\n--- GESTION DE LIBROS ---");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Buscar libro por codigo");
            System.out.println("0. Volver");
            System.out.print("\nIngrese una opción: ");
            opcion = Helper.getInt("");
            switch (opcion) {
                case 1:
                    gestorLibros.agregarLibro();
                    break;
                case 2:
                    gestorLibros.mostrarCatalogo();
                    break;
                case 3:
                    System.out.print("Ingrese código: ");
                    int codigo = scanner.nextInt();
                    var libro = gestorLibros.buscarPorCodigo(codigo);
                    System.out.println(libro != null ? libro : "Libro no encontrado.");
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } 
    }

    public static void menuSocios(Scanner scanner, RegistroSocioBiblioteca gestorSocios) {
        int opcion;
        boolean flag = true;
        while(flag) {
            System.out.println("\n--- GESTION DE SOCIOS ---");
            System.out.println("1. Registrar nuevo socio");
            System.out.println("2. Mostrar todos los socios");
            System.out.println("0. Volver");
            System.out.print("\nIngrese una opción: ");
            opcion = Helper.getInt("");
            switch (opcion) {
                case 1:
                    gestorSocios.registrarSocio();
                    break;
                case 2:
                    gestorSocios.mostrarSocios();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    public static void menuConsultas(Scanner scanner, RegistroLibros gestorLibros, RegistroSocioBiblioteca gestorSocios) {
        int opcion;
        boolean flag = true;
        while(flag) {
            System.out.println("\n--- CONSULTAS ---");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Ver todos los socios");
            System.out.println("3. Monto total de libros prestados");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Usuarios con X libros prestados o más");
            System.out.println("0. Volver al menu principal");
            System.out.print("Ingrese una opción: ");
            opcion = Helper.getInt("");

            switch (opcion) {
                case 1:
                    System.out.println("Todos los libros");
                    Consultas.mostrarTodosLosLibros(gestorLibros.getLibros());
                    break;
                case 2:
                    System.out.println("Todos los socios");
                    Consultas.mostrarTodosLosUsuarios(gestorSocios.getSocios());
                    break;
                case 3:
                    System.out.println("Monto total de libros prestados");
                    Consultas.montoTotalLibrosPrestados(gestorLibros.getLibros());
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del autor: ");
                    Consultas.librosDeUnAutor(gestorLibros);
                    break;
                case 5:
                    System.out.println("Usuarios con X libros prestados o más");
                    Consultas.usuariosConXCantLibros(gestorSocios.getSocios());
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
