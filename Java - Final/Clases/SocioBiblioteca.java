package Clases;

//Tener en cuenta de agregar los respectivos getters/setters, segun hagan falta. Además, ver el método compareTo()
public class SocioBiblioteca {
	private String apellidoNombre;
	private Integer dni;
	private Integer numUsuario;
	private String direccion;
	private long telefono;
	private Integer librosPrestados;

	public Integer getDni() {
		return dni;
	}

	public SocioBiblioteca(Integer dni) {
		this.dni = dni;
	}
	
	public SocioBiblioteca() {
		this.apellidoNombre= apellidoNombre();
		this.dni= validarDni();
		this.numUsuario= Helper.generarNumRandom();
		this.direccion= cargaDireccion();
		this.telefono= cargarNumTel();
		this.librosPrestados=0;
	}
	
	public String apellidoNombre() {
		String concatenar;
		System.out.println("Ingrese apellido");
		String apellido= Helper.validarCadena();
		System.out.println("Ingrese nombre");
		String nombre= Helper.validarCadena();
		System.out.println("*Apellido y nombre cargados correctamente!\n");
		return concatenar= apellido.toUpperCase()+", "+nombre.toUpperCase();
	}
	public int validarDni() {
		int dni= Helper.getPositiveInt("Ingrese DNI: ");
		return controlDni(dni);
	}
	private int controlDni(int dni) {
		while(dni<1000000 || dni>99999999) {
			dni= Helper.getPositiveInt("Error, ingrese DNI válido: ");
		}
		System.out.println("*DNI cargado correctamente!\n");
		return dni;
	}
	public String cargaDireccion() {
		System.out.println("Ingrese dirección:");
		this.direccion = Helper.validarCadena();
		System.out.println("*Dirección cargada correctamente!\n");
		return this.direccion.toUpperCase();
	}
	public long cargarNumTel() {
		long prefijo= 3880000000L;
		int telefono= validarTel(Helper.getPositiveInt("Ingrese número de teléfono sin el prefijo 388. Ejemplo: 1234567: "));
		System.out.println("*Teléfono cargado correctamente!\n");
		return prefijo+telefono;
	}
	private int validarTel(int numero) {
		while(numero>9999999) {
			numero= Helper.getPositiveInt("Error. Ingrese un número de teléfono válido: ");
		}
		return numero;
	}
	public Integer getNumUsuario() {
		return numUsuario;
	} 

	//get y set LibosPrestados
	public int getLibrosPrestados() {
		return librosPrestados;
	}

	public void setLibrosPrestados(Integer librosPrestados) {
		this.librosPrestados = librosPrestados;
	}

	public int compareTo(SocioBiblioteca x){
		return Integer.compare(this.dni, x.getDni());
	}

	@Override
	public String toString() {
		return "Socio/a [Apellido/Nombre: " + apellidoNombre + "; DNI: " + dni + "; Número de usuario: " + numUsuario
				+ "; Dirección: " + direccion + "; Teléfono: " + telefono + "; Libros Prestados: " + librosPrestados + "]";
	}
	
	
}
