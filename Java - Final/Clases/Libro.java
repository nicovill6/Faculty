package Clases;

//Tener en cuenta de agregar los respectivos getters/setters, segun hagan falta. Además, ver el método compareTo()
public class Libro implements Comparable<Libro>{
	
	private Integer codigo;
	private Integer seleccion;
	private String tituloLibro;
	private String autor;
	private float precio;
	private boolean disponible;

	public Libro(String autor){
		this.autor = autor;
	}

	public Libro(Integer codigo) {
		this.codigo= codigo;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}
	
	public Libro() {  //CAMBIAR
		this.codigo= Helper.generarNumRandom();
		this.seleccion= seleccion();
		this.tituloLibro= titulos(this.seleccion);
		this.autor= autores(this.seleccion);
		this.precio= Helper.getPositiveFloat("Ingrese precio del libro: ");
		this.disponible= true;
	}
	
	public Integer seleccion() {
		titulosLibros();
		seleccion= validarSeleccion(Helper.getPositiveInt("Seleccione -por número- el libro que desea agregar a la Biblioteca: "));
		return seleccion-1;
	}
	private Integer validarSeleccion(Integer numero) {
		while(numero<1 || numero>20) {
			numero= Helper.getPositiveInt("Error! Ingrese una opción correcta: ");
		}
		return numero;
	}
	private void titulosLibros() {
		System.out.println("\t\t\t***Catálogo de obras***\n"
				+"1) Crónica de una muerte anunciada.\t2) El amor en los tiempos del cólera.\n"
				+"3) Cien años de soledad.\t\t4) Los mitos de la historia argentina.\n"
				+"5) La voz del gran jefe.\t\t6) Los pacientes del doctor García.\n"
				+"7) El tiempo entre costuras.\t\t8) La reina del sur.\n"
				+"9) Distancia de rescate.\t\t10) Rayuela.\n"
				+"11) Pedro Páramo.\t\t\t12) Aura.\n"
				+"13) La tregua.\t\t\t\t14) La ciudad y los perros.\n"
				+"15) Conversación en La Catedral.\t16) Martín Fierro.\n"
				+"17) 1984.\t\t\t\t18) El principito.\n"
				+"19) Don Quijote de la Mancha.\t\t20) Harry Potter y la piedra filosofal.\n");
	}
	public String titulos(int posicion) {
		String [] titulos= {"Crónica de una muerte anunciada","El amor en los tiempos del cólera",
				"Cien años de soledad","Los mitos de la historia argentina","La voz del gran jefe",
				"Los pacientes del doctor García","El tiempo entre costuras","La reina del sur",
				"Distancia de rescate","Rayuela","Pedro Páramo","Aura","La tregua","La ciudad y los perros",
				"Conversación en La Catedral","Martín Fierro","1984","El principito","Don Quijote de la Mancha",
				"Harry Potter y la piedra filosofal"};
		return titulos[posicion];
	}
	public String autores(int posicion) {
		String [] autores= {"Gabriel García Márquez","Gabriel García Márquez","Gabriel García Márquez",
				"Felipe Pigna","Felipe Pigna","Almudena Grandes","María Dueñas",
				"Arturo Pérez-Reverte","Samanta Schweblin","Julio Cortázar","Juan Rulfo",
				"Carlos Fuentes","Mario Benedetti","Mario Vargas Llosa",
				"Mario Vargas Llosa","José Hernández","George Orwell",
				"Antoine de Saint-Exupéry","Miguel de Cervantes","J.K. Rowling"};
		return autores[posicion];
	}
	public Integer getCodigo() {
    	return codigo;
}


	//get y set disponible
	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	//get y set precio
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	//get y set autor
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "Libro [CÓDIGO: " + codigo +"; TÍTULO: " + tituloLibro + "; AUTOR: "
				+ autor + "; PRECIO: $" + precio + "; DISPONIBILIDAD: " + disponible + "]";
	}
	public int compareTo(Libro otro) {
	    return this.codigo.compareTo(otro.codigo);
	}

	
}
