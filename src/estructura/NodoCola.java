/**
 * Clase: NodoCola
 * 
 * @author Hector Marion
 * 
 * Version: 14.07.2018.1
 */

package estructura;

public class NodoCola{
	
	//Atributos de la Clase
	private Object dato;
	private NodoCola referencia;
	
	//Constructores de la clase
	public NodoCola(){
		
	}
	
	public NodoCola(Object dato){
		this.dato = dato;
		this.referencia = null;
	}
	
	//Constructor para Nodo de Pila
	public NodoCola(Object dato, NodoCola referencia){
		this.dato = dato;
		this.referencia = referencia;
	}

	//Getters y Setters
	public Object getDato() {
		return dato;
	}

	public void setDato(Object dato) {
		this.dato = dato;
	}

	public NodoCola getReferencia() {
		return referencia;
	}

	public void setReferencia(NodoCola referencia) {
		this.referencia = referencia;
	}

}
