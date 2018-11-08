/**
 * Clase: NodoDoble
 * 
 * @author Hector Marion
 * 
 * Version: 27.06.2018.1
 */

package estructura;

public class NodoDoble{

	//Atributos de la Clase
	private Object dato;
	private NodoDoble referenciaSiguiente;
	private NodoDoble referenciaAnterior;
	
	
	//Constructor de la clase
	public NodoDoble() {
		this.dato = null;
		this.referenciaAnterior = null;
		this.referenciaSiguiente = null;
	}
	
	public NodoDoble(Object dato) {
		this.dato = dato;
		this.referenciaAnterior = null;
		this.referenciaSiguiente = null;
	}
	
	public NodoDoble(Object dato, NodoDoble referencia) {
		this.dato = dato;
		this.referenciaAnterior = null;
		this.referenciaSiguiente = referencia;
	}
	
	//Getters y Setters
	public Object getDato(){
		return dato;
	}	

	public void setDato(Object dato){
		this.dato = dato;
	}
	
	public NodoDoble getReferenciaSiguiente(){
		return referenciaSiguiente;
	}
	
	public void setReferenciaSiguiente(NodoDoble referenciaSiguiente){
		this.referenciaSiguiente = referenciaSiguiente;
	}
	
	public NodoDoble getReferenciaAnterior(){
		return referenciaAnterior;
	}
	
	public void setReferenciaAnterior(NodoDoble referenciaAnterior){
		this.referenciaAnterior = referenciaAnterior;
	}
		
}
