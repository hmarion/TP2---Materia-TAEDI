/**
 * Clase: Operaciones
 * 
 * Clase en la que se arman los metodos utilizados por la clase Main
 * 
 * @author Hector Marion
 * 
 * Version: 16.07.2018.2
 */

package vista;

import java.util.Scanner;

import estructura.ColaLista;
import estructura.ListaDoble;
import estructura.ListaSimple;
import estructura.Nodo;
import estructura.NodoCola;
import estructura.NodoDoble;
import modelo.ElementoBibliotecario;
import modelo.Investigacion;
import modelo.Libro;

public class Operaciones {

	//Metodo para ingresar un Libro a la lista doblemente enlazada
	public static void ingresarLibro(ListaSimple listaAlfabeto){
		Scanner sc = new Scanner(System.in);
		Libro libro = new Libro();
		ListaDoble auxiliar = new ListaDoble();
		System.out.println("\nRegistro de un nuevo Libro:");
		Long ISBN = 0L;
		do{
			ISBN = libro.ingresarISBN();
		}while(ISBN == 0);
		System.out.print("Ingrese el Titulo del Libro: ");
		String titulo = sc.nextLine();
		titulo = titulo.substring(0,1).toUpperCase() + titulo.substring(1);
		System.out.print("Ingrese el Autor del Libro: ");
		String autor = sc.nextLine();
		System.out.print("Ingrese el Año de Publicacion del Libro: ");
		int anio = sc.nextInt();
		System.out.print("Ingrese el genero del Libro: ");
		sc = new Scanner(System.in);
		String genero = sc.nextLine();
		libro = new Libro(autor, titulo, anio, ISBN, genero);
		auxiliar = Operaciones.buscarListaDoble(listaAlfabeto, libro.getTitulo().charAt(0));
		auxiliar.insertar(libro);
	}
	

	//Metodo para eliminar un Libro de la lista doblemente enlazada
	public static void eliminarLibro(ListaSimple listaAlfabeto){
		Libro libro = new Libro();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ingrese el Titulo del Libro que desea eliminar: ");
		String titulo = sc.nextLine();
		titulo = titulo.substring(0,1).toUpperCase() + titulo.substring(1);
		ListaDoble auxiliarLista = Operaciones.buscarListaDoble(listaAlfabeto, titulo.charAt(0)); 
		NodoDoble auxiliarNodo = auxiliarLista.getPrimero();
		boolean salida = false;
		
		do{
			if(auxiliarNodo != null && auxiliarNodo.getDato() instanceof Libro){
				libro = (Libro)auxiliarNodo.getDato();
				if(titulo.equals(libro.getTitulo())){
					if(libro.getReserva() == false){
						libro = (Libro)auxiliarNodo.getDato();
						System.out.println("Se elimino el Libro: " + libro.toString());
						auxiliarLista.eliminar(libro);
					}else{
						System.out.println("El Libro esta reservado, no se puede borrar");
					}
					salida = true;
				}										
			auxiliarNodo = auxiliarNodo.getReferenciaSiguiente();
			}
		}while(auxiliarNodo != null && salida == false);
		if(!salida){
			System.out.println("No hay en Sistema ningun Libro con ese Titulo ingresado");
		}
	}
	
	//Metodo para buscar un Libro por ISBN en la lista doblemente enlazada
	public static void buscarLibroPorISBN(ListaSimple listaAlfabeto){
		Libro libro = new Libro();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Long ISBN1 = libro.ingresarISBN();
		int busqueda = 0;
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() != null){
				NodoDoble auxiliarDoble = new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null){				
					if(auxiliarDoble.getDato() instanceof Libro){
						libro = (Libro)auxiliarDoble.getDato();
						if(ISBN1.equals(libro.getISBN())){
							System.out.println(auxiliarDoble.getDato().toString());
							busqueda++;
						}
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null);
		if(busqueda==0){
			System.out.println("No se encontro ningun Libro con ese ISBN");
		}
	}
	
	//Metodo para buscar un Libro por Titulo en la lista doblemente enlazada
	public static void buscarLibroPorTitulo(ListaSimple listaAlfabeto){
		Libro libro = new Libro();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Scanner sc = new Scanner(System.in);
		int busqueda = 0;
		
		System.out.print("Ingrese el Titulo del Libro: ");
		String titulo = sc.nextLine();
		titulo = titulo.toLowerCase();
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() != null){
				NodoDoble auxiliarDoble = new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null){
					if(auxiliarDoble.getDato() instanceof Libro){
						libro = (Libro)auxiliarDoble.getDato();
						String cadena = libro.getTitulo().toLowerCase();
						if(cadena.indexOf(titulo) != -1){
							System.out.println(auxiliarDoble.getDato().toString());
							busqueda++;
						}
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null);
		if(busqueda==0){
			System.out.println("No se encontro ningun Libro con ese titulo");
		}
	}
	
	//Metodo para buscar un Libro por el Autor en la lista doblemente enlazada
	public static void buscarLibroPorAutor(ListaSimple listaAlfabeto){
		Libro libro = new Libro();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Scanner sc = new Scanner(System.in);
		int busqueda = 0;
		
		System.out.print("Ingrese el Autor del Libro: ");
		String autor = sc.nextLine();
		autor = autor.toLowerCase();
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() != null){
				NodoDoble auxiliarDoble =  new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null){
					if(auxiliarDoble.getDato() instanceof Libro){
						libro = (Libro)auxiliarDoble.getDato();
						if(autor.equals(libro.getAutor().toLowerCase())){
							System.out.println(auxiliarDoble.getDato().toString());
							busqueda++;
						}
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null);
		if(busqueda==0){
			System.out.println("No se encontro ningun Libro con ese Autor");
		}
	}
	
	//Metodo para buscar un Libro por el Genero en la lista doblemente enlazada
	public static void buscarLibroPorGenero(ListaSimple listaAlfabeto){
		Libro libro = new Libro();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Scanner sc = new Scanner(System.in);
		int busqueda =0;
		
		System.out.print("Ingrese el Genero del Libro: ");
		String genero = sc.nextLine();
		genero = genero.toLowerCase();
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() != null){
				NodoDoble auxiliarDoble = new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null){
					if(auxiliarDoble.getDato() instanceof Libro){
						libro = (Libro)auxiliarDoble.getDato();
						if(genero.equals(libro.getGenero().toLowerCase())){
							System.out.println(auxiliarDoble.getDato().toString());
							busqueda++;
						}
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null);
		if(busqueda==0){
			System.out.println("No se encontro ningun Libro de ese Genero");
		}
	}
	
	//Metodo para ingresar una Investigacion a la lista doblemente enlazada
	public static void ingresarInvestigacion(ListaSimple listaAlfabeto){
		Scanner sc = new Scanner(System.in);
		Investigacion investigacion = new Investigacion();
		ListaDoble auxiliar = new ListaDoble();
		System.out.println("\nRegistro de una nueva Investigacion:");
		System.out.print("Ingrese el Titulo de la Investigacion: ");
		String titulo = sc.nextLine();
		titulo = titulo.substring(0,1).toUpperCase() + titulo.substring(1);
		System.out.print("Ingrese el Autor de la Investigacion: ");
		String autor = sc.nextLine();
		System.out.print("Ingrese el Año de Publicacion de la Investigacion: ");
		int anio = sc.nextInt();
		System.out.print("Ingrese el campo de la Investigacion: ");
		sc = new Scanner(System.in);
		String campo = sc.nextLine();
		investigacion = new Investigacion(autor, titulo, anio, campo);
		auxiliar = Operaciones.buscarListaDoble(listaAlfabeto, investigacion.getTitulo().charAt(0));
		auxiliar.insertar(investigacion);
	}
		
	//Metodo para eliminar una Investigacion de la lista doblemente enlazada
	public static void eliminarInvestigacion(ListaSimple listaAlfabeto){
		Investigacion investigacion = new Investigacion();
		Scanner sc = new Scanner(System.in);
		int busqueda = 0;
		
		System.out.print("Ingrese el Titulo de la Investigacion que desea eliminar: ");
		String titulo = sc.nextLine();
		titulo = titulo.substring(0,1).toUpperCase() + titulo.substring(1);
		ListaDoble auxiliarLista = Operaciones.buscarListaDoble(listaAlfabeto, titulo.charAt(0)); 
		NodoDoble auxiliarNodo = auxiliarLista.getPrimero();
		boolean salida = false;
		
		do{
			if(auxiliarNodo != null && auxiliarNodo.getDato() instanceof Investigacion){
				investigacion = (Investigacion)auxiliarNodo.getDato();
				if(titulo.equals(investigacion.getTitulo())){
					if(investigacion.getReserva() == false){						
						investigacion = (Investigacion)auxiliarNodo.getDato();
						System.out.println("Se elimino la Investigacion: " + investigacion.toString());
						auxiliarLista.eliminar(investigacion);
					}else{
						System.out.println("La Investigacion esta reservada, no se puede borrar");
					}
					salida = true;
				}										
			auxiliarNodo = auxiliarNodo.getReferenciaSiguiente();
			}
		}while(auxiliarNodo != null && salida == false);
		if(!salida){
			System.out.println("No hay en Sistema ninguna Investigacion con ese Titulo ingresado");
		}
	}
	
	//Metodo para buscar una Investigacion por Titulo en la lista doblemente enlazada
	public static void buscarInvestigacionPorTitulo(ListaSimple listaAlfabeto){
		Investigacion investigacion = new Investigacion();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Scanner sc = new Scanner(System.in);
		int busqueda =0;
		
		System.out.print("Ingrese el Titulo de la Investigacion: ");
		String titulo = sc.nextLine();
		titulo = titulo.toLowerCase();
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() != null){
				NodoDoble auxiliarDoble = new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null){
					if(auxiliarDoble.getDato() instanceof Investigacion){
						investigacion = (Investigacion)auxiliarDoble.getDato();
						String cadena = investigacion.getTitulo().toLowerCase();
						if(cadena.indexOf(titulo) != -1){
							System.out.println(auxiliarDoble.getDato().toString());
							busqueda++;
						}						
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null);
		if(busqueda==0){
			System.out.println("No se encontro ninguna Investigacion con ese Titulo");
		}
	}
	
	//Metodo para buscar una Investigacion por el Autor en la lista doblemente enlazada
	public static void buscarInvestigacionPorAutor(ListaSimple listaAlfabeto){
		Investigacion investigacion = new Investigacion();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Scanner sc = new Scanner(System.in);
		int busqueda = 0;
		
		System.out.print("Ingrese el Autor de la Investigacion: ");
		String autor = sc.nextLine();
		autor = autor.toLowerCase();
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() != null){
				NodoDoble auxiliarDoble = new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null){
					if(auxiliarDoble.getDato() instanceof Investigacion){
						investigacion = (Investigacion)auxiliarDoble.getDato();
						if(autor.equals(investigacion.getAutor().toLowerCase())){
							System.out.println(auxiliarDoble.getDato().toString());
							busqueda++;
						}
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null);
		if(busqueda==0){
			System.out.println("No se encontro ninguna Investigacion con ese Autor");
		}
	}
	
	//Metodo para buscar una Investigacion por el Campo en la lista doblemente enlazada
	public static void buscarInvestigacionPorCampo(ListaSimple listaAlfabeto){
		Investigacion investigacion = new Investigacion();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Scanner sc = new Scanner(System.in);
		int busqueda =0;
		
		System.out.print("Ingrese el Campo de la Investigacion: ");
		String campo = sc.nextLine();
		campo = campo.toLowerCase();
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() !=  null){
				NodoDoble auxiliarDoble = new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null){
					if(auxiliarDoble.getDato() instanceof Investigacion){
						investigacion = (Investigacion)auxiliarDoble.getDato();
						if(campo.equals(investigacion.getCampo().toLowerCase())){
							System.out.println(auxiliarDoble.getDato().toString());
							busqueda++;
						}
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null);
		if(busqueda==0){
			System.out.println("No se encontro ninguna Investigacion de ese Campo");
		}
	}
	
	//Metodo para generar la carga de las letras del alfabeto en la Lista Simplemente Enlazada
	public static ListaSimple generarListaAlfabetica(){
		ListaSimple listaAlfabetica = new ListaSimple();
		for(int i=65; i<=(65+26); i++){
			if(i==79){
				listaAlfabetica.insertar('Ñ');
			}else if(i<79){
				char caracter = (char) i;				
				listaAlfabetica.insertar(caracter);
			}else if(i>79){
				char caracter = (char) (i-1);				
				listaAlfabetica.insertar(caracter);
			}
		}
		return listaAlfabetica;		
	}
	
	//Metodo para buscar una letra en la listaAlfabeto
	public static ListaDoble buscarListaDoble(ListaSimple listaAlfabeto, char caracter){
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		ListaDoble auxiliar2;
		char caracterAuxiliar = (char)auxiliar.getDato();
		while(caracter !=  caracterAuxiliar){
			auxiliar = auxiliar.getReferenciaSiguiente();
			caracterAuxiliar = (char)auxiliar.getDato();
		}
		auxiliar2 = auxiliar.getReferenciaAListaElementos(); 
		return auxiliar2;
	}
	
	//Metodo para mostrar todos los Elementos cargados
	public static void mostrarElementos(ListaSimple listaAlfabeto){
		System.out.println("\nLista de Elementos");
		Nodo auxiliarNodo = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		do{
			ListaDoble auxiliarLista = auxiliarNodo.getReferenciaAListaElementos();
			System.out.println("Letra " + auxiliarNodo.getDato());	
				auxiliarLista.listarAscendente();
			auxiliarNodo = auxiliarNodo.getReferenciaSiguiente();
		}while(auxiliarNodo != null);		
	}
	
	//Metodo para mostrar todos los Libros Cargados
	public static void mostrarLibros(ListaSimple listaAlfabeto){	
		System.out.println("\nLista de Libros");
		Nodo auxiliarNodo = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		do{
			ListaDoble auxiliarLista = auxiliarNodo.getReferenciaAListaElementos();
			NodoDoble auxiliarNodoDoble = auxiliarLista.getPrimero();
			System.out.println("Letra " + auxiliarNodo.getDato());	
			while(auxiliarNodoDoble != null){
				if(auxiliarNodoDoble.getDato() instanceof Libro){
					System.out.println(auxiliarNodoDoble.getDato().toString());
				}
				auxiliarNodoDoble = auxiliarNodoDoble.getReferenciaSiguiente();
			}
			auxiliarNodo = auxiliarNodo.getReferenciaSiguiente();
		}while(auxiliarNodo != null);		
	}
	
	//Metodo para mostrar todos las Investigaciones Cargadas
	public static void mostrarInvestigacion(ListaSimple listaAlfabeto){
		System.out.println("\nLista de Investigaciones");
		Nodo auxiliarNodo = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		do{
			ListaDoble auxiliarLista = auxiliarNodo.getReferenciaAListaElementos();
			NodoDoble auxiliarNodoDoble = auxiliarLista.getPrimero();
			System.out.println("Letra " + auxiliarNodo.getDato());	
			while(auxiliarNodoDoble != null){
				if(auxiliarNodoDoble.getDato() instanceof Investigacion){
					System.out.println(auxiliarNodoDoble.getDato().toString());
				}
				auxiliarNodoDoble = auxiliarNodoDoble.getReferenciaSiguiente();
			}
			auxiliarNodo = auxiliarNodo.getReferenciaSiguiente();
		}while(auxiliarNodo != null);		
	}
	
	//Metodo para Reservar un Libro
	public static void reservarLibro(ListaSimple listaAlfabeto, ColaLista listaReserva){
		Libro libro = new Libro();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Long ISBN = libro.ingresarISBN();
		int busqueda = 0;
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() != null){
				NodoDoble auxiliarDoble = new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null && busqueda ==0){				
					if(auxiliarDoble.getDato() instanceof Libro){
						libro = (Libro)auxiliarDoble.getDato();
						if(ISBN.equals(libro.getISBN())){
							if(libro.getReserva() == false){
								System.out.println("El Libro: " + libro.getTitulo() + ", fue reservado");
								libro.reservar();
								listaReserva.encolar(libro);
							}else{
								System.out.println("El Libro ya se encuentra reservado");
							}
							busqueda++;
						}
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null && busqueda == 0);
		if(busqueda==0){
			System.out.println("No se encontro ningun Libro con ese ISBN");
		}
	}
	
	//Metodo para Reservar una Investigacion
	public static void reservarInvestigacion(ListaSimple listaAlfabeto, ColaLista listaReserva){
		Investigacion investigacion = new Investigacion();
		Nodo auxiliar = new Nodo(listaAlfabeto.getPrimero().getDato(), listaAlfabeto.getPrimero().getReferenciaSiguiente(), listaAlfabeto.getPrimero().getReferenciaAListaElementos());
		Scanner sc = new Scanner(System.in);
		int busqueda = 0;
		
		System.out.print("Ingrese el Titulo de la Investigacion: ");
		String titulo = sc.nextLine();
		titulo = titulo.toLowerCase();
		
		do{
			ListaDoble auxiliarLista = auxiliar.getReferenciaAListaElementos();
			if(auxiliarLista.getPrimero() != null){
				NodoDoble auxiliarDoble = new NodoDoble(auxiliarLista.getPrimero().getDato(), auxiliarLista.getPrimero().getReferenciaSiguiente());
				while(auxiliarDoble != null && busqueda ==0){				
					if(auxiliarDoble.getDato() instanceof Investigacion){
						investigacion = (Investigacion)auxiliarDoble.getDato();
						if(titulo.equals(investigacion.getTitulo().toLowerCase())){
							if(investigacion.getReserva() == false){
								System.out.println("La Investigacion: " + investigacion.getTitulo() + ", fue reservado");
								investigacion.reservar();
								listaReserva.encolar(investigacion);
							}else{
								System.out.println("La Investigacion ya se encuentra reservada");
							}
							busqueda++;
						}
					}
					auxiliarDoble = auxiliarDoble.getReferenciaSiguiente();
				}
			}
			auxiliar = auxiliar.getReferenciaSiguiente();
		}while(auxiliar != null && busqueda == 0);
		if(busqueda==0){
			System.out.println("No se encontro ninguna Investigacion con ese Titulo");
		}
	}
	
	//Metodo para Mostrar todas las Reservas
	public static void mostrarReservas(ColaLista listaReserva){ 
		if(listaReserva.esVacia()){
			System.out.println("No hay Reservas registradas");
		}else{
			NodoCola auxiliar = new NodoCola(listaReserva.getPrimero().getDato(), listaReserva.getPrimero().getReferencia());
			System.out.println("Lista de Reservas");
			do{
				System.out.println(auxiliar.getDato().toString());
				auxiliar = auxiliar.getReferencia();
			}while(auxiliar != null);
		}
	}
	
	//Metodo para Mostrar la siguiente Reserva
	public static void mostrarProximaReserva(ColaLista listaReserva){
		if(listaReserva.esVacia()){
			System.out.println("No hay Reservas registradas");
		}else{
			System.out.println("Proxima Reserva:");
			System.out.println(listaReserva.getPrimero().getDato().toString());
		}
	}
	
	//Metodo para realizar la entrega de la Reserva 
	public static void entregarReserva(ColaLista listaReserva, ListaSimple listaAlfabeto){
		if(listaReserva.esVacia()){
			System.out.println("No hay Reservas registradas");
		}else{
			System.out.println("La siguiente Reserva fue entregada:");
			System.out.println(listaReserva.getPrimero().getDato().toString());
			ElementoBibliotecario auxiliar = (ElementoBibliotecario) listaReserva.getPrimero().getDato();
			auxiliar.anularReserva();
			listaReserva.desencolar();
			
			
			String titulo = auxiliar.getTitulo();
			ListaDoble auxiliarLista = Operaciones.buscarListaDoble(listaAlfabeto, titulo.charAt(0)); 
			NodoDoble auxiliarNodo = auxiliarLista.getPrimero();
			boolean salida = false;
			
			if(auxiliar instanceof Libro){
				Libro libro;
				do{
					if(auxiliarNodo != null && auxiliarNodo.getDato() instanceof Libro){
						libro = (Libro)auxiliarNodo.getDato();
						if(titulo.equals(libro.getTitulo())){
							if(libro.getReserva() == false){
								libro = (Libro)auxiliarNodo.getDato();
								System.out.println("El Libro: " + libro.toString() + " se elimino del catalogo");
								auxiliarLista.eliminar(libro);
							}else{
								System.out.println("El Libro esta reservado, no se puede borrar");
							}
							salida = true;
						}										
					auxiliarNodo = auxiliarNodo.getReferenciaSiguiente();
					}
				}while(auxiliarNodo != null && salida == false);
				if(!salida){
					System.out.println("No hay en Sistema ningun Libro con ese Titulo ingresado");
				}
			}else{
				Investigacion investigacion;
				do{
					if(auxiliarNodo != null && auxiliarNodo.getDato() instanceof Investigacion){
						investigacion = (Investigacion)auxiliarNodo.getDato();
						if(titulo.equals(investigacion.getTitulo())){
							if(investigacion.getReserva() == false){						
								investigacion = (Investigacion)auxiliarNodo.getDato();
								System.out.println("La Investigacion: " + investigacion.toString() + " se elimino del catalogo");
								auxiliarLista.eliminar(investigacion);
							}else{
								System.out.println("La Investigacion esta reservada, no se puede borrar");
							}
							salida = true;
						}										
					auxiliarNodo = auxiliarNodo.getReferenciaSiguiente();
					}
				}while(auxiliarNodo != null && salida == false);
				if(!salida){
					System.out.println("No hay en Sistema ninguna Investigacion con ese Titulo ingresado");
				}
			}
		}
	}
	
	//Metodo para anular la Proxima Reserva
	public static void anularProximaReserva(ColaLista listaReserva){
		if(listaReserva.esVacia()){
			System.out.println("No hay Reservas registradas");
		}else{
			System.out.println("La siguiente Reserva fue anulada:");
			System.out.println(listaReserva.getPrimero().getDato().toString());
			listaReserva.desencolar();
		}
	}
}
