/**
 * Clase: Investigacion
 * 
 * @author Hector Marion
 * 
 * Version: 08.07.2018.2
 */

package modelo;

public class Investigacion extends ElementoBibliotecario implements Comparable{

	//Atributos de la clase
	private String campo;

	
	//Constructor de la clase
	public Investigacion(String autor, String titulo, int anioPublicacion, String campo) {
		super(autor, titulo, anioPublicacion);
		this.campo = campo;
	}
	
	public Investigacion() {
	}


	//Getters y Setters
	public String getCampo(){
		return campo;
	}

	public void setCampo(String campo){
		this.campo = campo;
	}


	@Override
	public int compareTo(Object o){
		ElementoBibliotecario investigacion = (ElementoBibliotecario)o;
		String titulo1 = this.getTitulo();
		String titulo2 = investigacion.getTitulo();
		return titulo1.compareTo(titulo2);
	}
	
	@Override
	public String toString() {
		return "Investigacion: " + getTitulo() + ", Autor: " + getAutor() + ", Anioo: " + getAnioPublicacion() 
				+", Campo: " + campo;
	}

	
}
