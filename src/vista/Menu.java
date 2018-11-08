/**
 * Clase: Menu
 * 
 * Clase que contiene la impresion de pantalla de los distintos menus del sitema.
 * 
 * @author Hector Marion
 * 
 * Version: 14.07.2018.2
 */

package vista;

public class Menu {

	//Metodo para imprimir el menu principal
	public static void menuPrincipal(){ 
		
		System.out.println("\nBienvenido al Menu de Seleccion");
		System.out.println("1 - Menu de Libros"); 
		System.out.println("2 - Menu de Investigaciones");
		System.out.println("3 - Menu de Reserva");
		System.out.println("0 - Salir.");
		System.out.print  ("Ingrese la opcion seleccionada: ");
	}
	
	//Metodo para imprimir el menu de opciones de Libros
	public static void menuLibro(){ //
		
		System.out.println("\nMenu de Libros");
		System.out.println("1 - Insertar un Libro"); 
		System.out.println("2 - Borrar un Libro");  
		System.out.println("3 - Buscar un Libro");
		System.out.println("4 - Imprimir los Libros cargados");
		System.out.println("0 - Volver al Menu Principal");
		System.out.print  ("Ingrese la opcion seleccionada: ");
	}
	
	//Metodo para imprimir el menu de busqueda de Libros
	public static void menuBusquedaLibro(){
		
		System.out.println("\nMenu de busqueda de Libro:");
		System.out.println("1 - Busqueda por ISBN");
		System.out.println("2 - Busqueda por Titulo");
		System.out.println("3 - Busqueda por Autor");
		System.out.println("4 - Busqueda por Genero");
		System.out.println("0 - Volver al Menu de Libros");
		System.out.print("Ingrese la opcion seleccionada: ");
	}
	
	//Metodo para imprimir el menu de opciones de Investigaciones
	public static void menuInvestigacion(){
		
		System.out.println("\nMenu de Investigaciones");
		System.out.println("1 - Insertar una Investigacion"); 
		System.out.println("2 - Borrar una Investigacion");  
		System.out.println("3 - Buscar una Investigacion");
		System.out.println("4 - Imprimir las Investigaciones cargadas");
		System.out.println("0 - Volver al Menu Principal");
		System.out.print  ("Ingrese la opcion seleccionada: ");
	}
	
	//Metodo para imprimir el menu de busqueda de Investigaciones
	public static void menuBusquedaInvestigacion(){
		
		System.out.println("\nMenu de busqueda de Investigaciones:");
		System.out.println("1 - Busqueda por Titulo");
		System.out.println("2 - Busqueda por Autor");
		System.out.println("3 - Busqueda por Campo");
		System.out.println("0 - Volver al Menu de Investigaciones");
		System.out.print("Ingrese la opcion seleccionada: ");
	}
	
	//Metodo para imprimir el menu de reservas
	public static void menuReservas(){ 
		
		System.out.println("\nBienvenido al Menu de Reservas");
		System.out.println("1 - Reservar un Libro"); 
		System.out.println("2 - Reservar una Investigaciones");
		System.out.println("3 - Muestra todas las Reservas");
		System.out.println("4 - Muestra la Proxima Reserva");
		System.out.println("5 - Entregar Reserva");
		System.out.println("6 - Anular Proxima Reserva");
		System.out.println("0 - Volver al menu anterior");
		System.out.print  ("Ingrese la opcion seleccionada: ");
	}
}
