package Clases;

import java.time.LocalDate;

public class Operacion {
	private Integer idOperacion;
	private String tipoOperacion;
	private Libro libro;
	private SocioBiblioteca usuario;
	private LocalDate fecha;
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public SocioBiblioteca getUsuario() {
		return usuario;
	}
	public void setUsuario(SocioBiblioteca usuario) {
		this.usuario = usuario;
	}

	public Operacion(Libro libro, SocioBiblioteca usuario, LocalDate fecha) {
		this.idOperacion= Helper.generarNumRandom();
		this.tipoOperacion= seleccionarOperacion();
		this.libro= libro;
		this.usuario= usuario;
		this.fecha= fecha;
	}
	public String seleccionarOperacion() {
		String [] operaciones= {"Préstamo","Devolución"};
		int opcion= Helper.getPositiveInt("Seleccione tipo de operación realizada: 1= Préstamo o 2= Devolución");
		while(opcion<1 || opcion>2) {
			opcion= Helper.getPositiveInt("Error. Seleccione tipo de operación válida: 1= Préstamo o 2= Devolución ");
		}
		--opcion;
		System.out.println("*Operación: "+ operaciones[opcion]+"\nCargada correctamente!\n");
		return operaciones[opcion];
	}
	@Override
	public String toString() {
		return "Datos Operación\n[*ID Operacion: " + idOperacion + ";\n*Tipo de Operación: " + tipoOperacion + "\n*" + libro
				+ "\n*" + usuario + "\n*Fecha de operación: " + fecha + "]";
	}
	
}
