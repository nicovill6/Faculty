package registros;

import Clases.SocioBiblioteca;

public class RegistroSocioBiblioteca {
    private SocioBiblioteca[] socios;
    private int cantidad;

    public SocioBiblioteca[] getSocios() {
        return socios;
    }

    public void setSocios(SocioBiblioteca[] socios) {
        this.socios = socios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public RegistroSocioBiblioteca(int capacidadMaxima) {
        socios = new SocioBiblioteca[capacidadMaxima];
        cantidad = 0;
    }

    public void registrarSocio() {
        if (cantidad >= socios.length) {
            System.out.println("Capacidad máxima alcanzada para socios.");
            return;
        }

        SocioBiblioteca nuevoSocio = new SocioBiblioteca(); // pide datos por consola
        socios[cantidad++] = nuevoSocio;
        System.out.println("\nSocio registrado exitosamente:\n" + nuevoSocio);
    }

    public void mostrarSocios() {
        System.out.println("\n--- LISTADO DE SOCIOS ---");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(socios[i]);
        }
    }

    public SocioBiblioteca buscarPorNumero(Integer numero) {
        for (int i = 0; i < cantidad; i++) {
            if (socios[i].getNumUsuario().equals(numero)) {
                return socios[i];
            }
        }
        return null;
    }
}
