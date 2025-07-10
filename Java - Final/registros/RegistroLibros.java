package registros;

import Clases.Libro;
import EstructurasDeDatos.BinarySearchTree;

public class RegistroLibros {

    private Libro[] libros;
    private int cantidad;
    private BinarySearchTree<Libro> arbol;



    public RegistroLibros(int capacidadMaxima, BinarySearchTree<Libro> arbolin) {
        libros = new Libro[capacidadMaxima];
        cantidad = 0;
        arbol = arbolin;
    }

    // Agregar un nuevo libro (al arreglo y al árbol)
    public void agregarLibro() {
        if (cantidad >= libros.length) {
            System.out.println("Capacidad máxima, no se puede agregar más libros.");
            return;
        }

        Libro nuevoLibro = new Libro();  
        libros[cantidad++] = nuevoLibro;
        arbol.add(nuevoLibro);

        System.out.println("Libro registrado exitosamente:\n" + nuevoLibro);
    }

    // Mostrar todos los libros registrados
    public void mostrarCatalogo() {
        System.out.println("\n REGISTRADOS EN BIBLIOTECA:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(libros[i]);
        }
    }

    // Buscar un libro por código (usando el arreglo)
    public Libro buscarPorCodigo(int codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (libros[i].getCodigo() == codigo) {
                return libros[i];
            }
        }
        return null;
    }

    // (opcional) Buscar usando el árbol
    public Libro buscarEnArbol(Libro libro) {
        try {
            return arbol.find(libro);  // Suponiendo que BinarySearchTree tiene método find
        } catch (RuntimeException e) {
            System.out.println("Libro no encontrado en el árbol.");
            return null;
        }
    }

    public int getCantidadLibros() {
        return cantidad;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public BinarySearchTree<Libro> getArbol() {
        return arbol;
    }
}
