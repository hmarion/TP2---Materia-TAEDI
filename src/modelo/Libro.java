/**
 * Clase: Libro
 * 
 * @author Hector Marion
 * 
 * Version: 08.07.2018.2
 */

package modelo;

import java.util.Scanner;

public class Libro extends ElementoBibliotecario implements Comparable{

	//Atributos de la clase
	private long ISBN;
	private String genero;
	
	
	//Constructor de la clase
	public Libro(String autor, String titulo, int anioPublicacion, long iSBN, String genero){
		super(autor, titulo, anioPublicacion);
		this.ISBN = iSBN;
		this.genero = genero;
	}
	
	public Libro(){
	}
	
	
	//Getters y Setters
	public long getISBN(){
		return ISBN;
	}
	
	public void setISBN(long iSBN){
		ISBN = iSBN;
	}
	
	public String getGenero(){
		return genero;
	}
	
	public void setGenero(String genero){
		this.genero = genero;
	}
	
	@Override
	public int compareTo(Object o){
		ElementoBibliotecario libro = (ElementoBibliotecario)o;
		String titulo1 = this.getTitulo();
		String titulo2 = libro.getTitulo();
		return titulo1.compareTo(titulo2);
	}
	
	public int compararDato(Object o){
		Libro libro = (Libro)o;
		String ISBN1 = String.valueOf(this.getISBN());
		String ISBN2 = String.valueOf(libro.getISBN());
		return ISBN1.compareTo(ISBN2);
	}

	@Override
	public String toString() {
		return "Libro: ISBN " + ISBN + ", Titulo: " + getTitulo() + ", Autor: " + getAutor() + ", Año: " + getAnioPublicacion() 
				+", Genero: " + genero;
	}

	public long ingresarISBN(){
		Scanner sc = new Scanner(System.in);
		Long ISBN = 0L;
			try{
				System.out.print("Ingrese el ISBN (El ISBN debe ser de 13 digitos): ");
				ISBN = sc.nextLong();
				while((ISBN > 9999999999999L) || ISBN < (1000000000000L)){
					System.out.println("El numero ingresado debe ser de 13 digitos");
					System.out.print("Ingrese el ISBN (El ISBN debe ser de 13 digitos): ");
					ISBN = sc.nextLong();
				}
			}catch(Exception e){
				System.out.println("Ingreso un caracter no valido");
			}
		return ISBN;
	}
}
