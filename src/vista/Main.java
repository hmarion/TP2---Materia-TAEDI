/**
 * Clase: Main
 * 
 * Clase en la que se ejecuta el programa.
 * 
 * @author Hector Marion
 * 
 * Version: 16.07.2018.2
 */

package vista;

import java.util.Scanner;	

import estructura.ColaLista;
import estructura.ListaSimple;

public class Main {
	
	public static void main(String[] args) {
		
		int opcion1 = 1; //Opcion para utilizar en el menu principal	
		ListaSimple listaAlfabeto; //Lista Simplemente enlazada para cargar las letras del alfabeto
		listaAlfabeto = Operaciones.generarListaAlfabetica();
		ColaLista listaReserva = new ColaLista();
		
		while(opcion1 != 0){ 		
			try{				
				Scanner sc = new Scanner(System.in);
				Menu.menuPrincipal(); //Impresion del Menu Principal
				opcion1 = sc.nextInt(); 
				
				switch(opcion1){				
					
					case 1: //Menu de Libros
						int opcion2 = 1; //Opcion para utilizar el menu de Libros
						
						while(opcion2 != 0){
							sc = new Scanner(System.in);
							
							Menu.menuLibro(); //Impresion del Menu de Libros
							opcion2 = sc.nextInt();
							switch(opcion2){							
								
								case 1: //Opcion para insertar un Libro
									Operaciones.ingresarLibro(listaAlfabeto); //Metodo para ingresar un Libro a la lista de Libros
									break;
									
								case 2: //Opcion para eliminar un Libro
									Operaciones.eliminarLibro(listaAlfabeto); //Metodo para eliminar un Libro de la lista de Libros
									break;
									
								case 3: //Opcion para buscar un Libro
									int opcion2_1 = 1;
									
									while(opcion2_1 !=0){
										sc = new Scanner(System.in);
										
										Menu.menuBusquedaLibro(); //Impresion del Menu de busqueda de Libros
										opcion2_1 = sc.nextInt();
										switch(opcion2_1){
											
											case 1:
												Operaciones.buscarLibroPorISBN(listaAlfabeto); //Metodo para buscar un Libro por ISBN
												break;
											
											case 2:
												Operaciones.buscarLibroPorTitulo(listaAlfabeto); //Metodo para buscar un Libro por Titulo
												break;
											
											case 3:
												Operaciones.buscarLibroPorAutor(listaAlfabeto); //Metodo para buscar un Libro por Autor
												break;	
												
											case 4:
												Operaciones.buscarLibroPorGenero(listaAlfabeto); //Metodo para buscar un Libro por Genero
												break;
												
											case 0: //Opcion para salir del menu de busqueda de Libros
												break;
											
											default:
												System.out.println("La opcion ingresada es incorrecta");
										}
									}
									break;
									
								case 4: //Opcion para imprimir los Libros
									Operaciones.mostrarLibros(listaAlfabeto);
									break;
									
								case 0: //Salir del menu de Libros
									break;
									
								default:
									System.out.println("La opcion ingresada es incorrecta");
							}
						}
						break;
						
					case 2: //Menu de Investigaciones
						int opcion3 = 1; //Opcion para utilizar el menu de Investigaciones
						
						while(opcion3 != 0){
							sc = new Scanner(System.in);
							
							Menu.menuInvestigacion(); //Impresion del Menu de Investigaciones
							opcion3 = sc.nextInt();
							
							switch(opcion3){
							
								case 1: //Opcion para insertar una Investigacion
									Operaciones.ingresarInvestigacion(listaAlfabeto); //Metodo para ingresar una Investigacion a la Lista de Investigaciones
									break;
									
								case 2: //Opcion para eliminar una Investigacion
									Operaciones.eliminarInvestigacion(listaAlfabeto); //Metodo para eliminar una Investigacion
									break;
									
								case 3: //Opcion para buscar una Investigacion
									int opcion3_1 = 1;
									while(opcion3_1 !=0){
										sc = new Scanner(System.in);
										
										Menu.menuBusquedaInvestigacion(); //Impresion del Menu de Busqueda de las Investigaciones
										opcion3_1 = sc.nextInt();
										switch(opcion3_1){
											
											case 1:
												Operaciones.buscarInvestigacionPorTitulo(listaAlfabeto); //Metodo para buscar una Investigacion por el Titulo
												break;
											
											case 2:
												Operaciones.buscarInvestigacionPorAutor(listaAlfabeto); //Metodo para buscar una Investigacion por el Autor
												break;	
												
											case 3:
												Operaciones.buscarInvestigacionPorCampo(listaAlfabeto); //Metodo para buscar una Investigacion por el Campo
												break;
												
											case 0: //Opcion para salir del Menu de busqueda de Investigaciones
												break;
											
											default:
												System.out.println("La opcion ingresada es incorrecta");
										}
									}
									break;
									
								case 4: //Opcion para imprimir las Investigaciones
									Operaciones.mostrarInvestigacion(listaAlfabeto);
									break;
									
								case 0: //Salir del menu de Investigaciones
									break;
									
								default:
									System.out.println("La opcion ingresada es incorrecta");
							}
						}
						break;
						
					case 3: //Opcion de Rerservas
						int opcion2_3 =1; //opcion para usar el menu de reservas
						
						while(opcion2_3 != 0){
							sc = new Scanner(System.in);
							
							Menu.menuReservas(); //Impresion del Menu de Reservas
							opcion2_3 = sc.nextInt();
							
							switch(opcion2_3){
								
								case 1: //Opcion para Reservar un Libro
									Operaciones.reservarLibro(listaAlfabeto, listaReserva);
									break;
									
								case 2: //Opcion para Reservar una Investigacion
									Operaciones.reservarInvestigacion(listaAlfabeto, listaReserva);
									break;
									
								case 3: //Opcion para Mostrar todas las Reservas
									Operaciones.mostrarReservas(listaReserva);
									break;
								
								case 4: //Opcion para Mostrar la Proxima Reserva
									Operaciones.mostrarProximaReserva(listaReserva);
									break;
									
								case 5: //Opcion para Entregar una reserva
									Operaciones.entregarReserva(listaReserva, listaAlfabeto);
									break;
									
								case 6: //Opcion para Anular la proxima reserva
									Operaciones.anularProximaReserva(listaReserva);
									break;
									
								case 0: //Salir del menu de Investigaciones
									break;
									
								default:
									System.out.println("La opcion ingresada es incorrecta");
							}
						}
						break;
						
					case 0: //Salir del Programa
						System.out.println("Gracias por utilizar nuestro programa!");
						break;
						
					default:
						System.out.println("La opcion ingresada es incorrecta");
				}
			}catch(Exception e){
				System.out.println("Ingreso un caracter no valido");
			}
		}
	}
}
