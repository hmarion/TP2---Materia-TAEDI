/**
 * Clase Abstracta: ElementoBibliotecario
 * 
 * @author Hector Marion
 * 
 * Version: 16.07.2018.2
 */

package modelo;

public abstract class ElementoBibliotecario{

	//Atributos de la Clase
	private String autor;
	private String titulo;
	private int anioPublicacion;
	private boolean reserva;

	//Constructor de la clase
	public ElementoBibliotecario(String autor, String titulo, int anioPublicacion){
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.anioPublicacion = anioPublicacion;
		this.reserva = false;
	}
	
	public ElementoBibliotecario(){
	}

	//Getters y Setters
	public String getAutor(){
		return autor;
	}
	
	public void setAutor(String autor){
		this.autor = autor;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public int getAnioPublicacion(){
		return anioPublicacion;
	}
	
	public void setAnioPublicacion(int anioPublicacion){
		this.anioPublicacion = anioPublicacion;
	}

	private void setReserva(boolean reserva){
		this.reserva = reserva;
	}
	
	public boolean getReserva(){
		return reserva;
	}
	
	public void reservar(){
		setReserva(true);
	}
	
	public void anularReserva(){
		setReserva(false);
	}
	
}
