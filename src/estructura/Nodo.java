/**
 * Clase: Nodo
 * 
 * @author Hector Marion
 * 
 * Version: 08.07.2018.2
 */

package estructura;

public class Nodo{
	
	//Atributos de la Clase
	private Object dato;
	private Nodo referenciaSiguiente;
	private ListaDoble referenciaAListaElementos;
	
	//Constructores de la clase
	public Nodo(){
		
	}
	
	public Nodo(Object dato){
		ListaDoble listaDoble = new ListaDoble();
		this.dato = dato;
		this.referenciaSiguiente = null;
		this.referenciaAListaElementos = listaDoble;
	}
	
	public Nodo(Object dato, Nodo referencia){
		ListaDoble listaDoble = new ListaDoble();
		this.dato = dato;
		this.referenciaSiguiente = referencia;
		this.referenciaAListaElementos = listaDoble;
	}
	
	public Nodo(Object dato, Nodo referencia, ListaDoble lista){
		this.dato = dato;
		this.referenciaSiguiente = referencia;
		this.referenciaAListaElementos = lista;
	}

	//Getters y Setters
	public Object getDato(){
		return dato;
	}

	public void setDato(Object dato){
		this.dato = dato;
	}

	public Nodo getReferenciaSiguiente() {
		return referenciaSiguiente;
	}

	public void setReferenciaSiguiente(Nodo referencia) {
		this.referenciaSiguiente = referencia;
	}

	public ListaDoble getReferenciaAListaElementos() {
		return referenciaAListaElementos;
	}

	public void setReferenciaAListaElementos(ListaDoble referenciaAListaElementos) {
		this.referenciaAListaElementos = referenciaAListaElementos;
	}
	
	

}
