package EstructurasDeDatos;

public class Stack<ELEMENT> {
	//region atributos
	private final int tamanio=10;
	private ELEMENT[] datos;
	private int cuenta;
	
	public Stack() {
		this.datos= (ELEMENT []) new Object[this.tamanio];
		this.cuenta=0;
	}
	public void push(ELEMENT elemento) {
		if(this.isFull()) {
			throw new RuntimeException("Pila llena!");
		}
		datos[cuenta]=elemento;
		++cuenta;
	}
	public ELEMENT pop() {
		if(this.isEmpty()) {
			throw new RuntimeException("La pila está vacía!");
		}
		--cuenta;
		return this.datos[this.cuenta];
	}
	public ELEMENT peek() {
		if(this.isEmpty()) {
			throw new RuntimeException("Pila vacía!");
		}
		return this.datos[this.cuenta-1];
	}
	public boolean isFull() {
		return this.cuenta>=this.datos.length;
	}
	public boolean isEmpty() {
		return this.cuenta<=0;
	}
}

	
