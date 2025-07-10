package registros;

import Clases.Libro;

class NodoLibro {
    Libro libro;
    NodoLibro izquierda;
    NodoLibro derecha;

    public NodoLibro(Libro libro) {
        this.libro = libro;
    }
}

public class ArbolLibros {
    private NodoLibro raiz;

    public void insertar(Libro libro) {
        raiz = insertarRecursivo(raiz, libro);
    }

    private NodoLibro insertarRecursivo(NodoLibro actual, Libro libro) {
        if (actual == null) {
            return new NodoLibro(libro);
        }

        if (libro.getCodigo() < actual.libro.getCodigo()) {
            actual.izquierda = insertarRecursivo(actual.izquierda, libro);
        } else if (libro.getCodigo() > actual.libro.getCodigo()) {
            actual.derecha = insertarRecursivo(actual.derecha, libro);
        } else {
            System.out.println("Error: código de libro duplicado.");
        }

        return actual;
    }

    public Libro buscar(int codigo) {
        return buscarRecursivo(raiz, codigo);
    }

    private Libro buscarRecursivo(NodoLibro actual, int codigo) {
        if (actual == null) return null;
        if (codigo == actual.libro.getCodigo()) return actual.libro;

        if (codigo < actual.libro.getCodigo())
            return buscarRecursivo(actual.izquierda, codigo);
        else
            return buscarRecursivo(actual.derecha, codigo);
    }
}
