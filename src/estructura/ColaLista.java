/**
 * Clase: ColaLista
 * 
 * Clase de la estructura Cola utilizada en una lista enlazada
 * 
 * @author Hector Marion
 * 
 * Version: 14.07.2018.1
 */

package estructura;

public class ColaLista implements ICola{

	//atributos de la clase
	private NodoCola primero;
	
	//Getters y setters
	public NodoCola getPrimero() {
		return primero;
	}

	public void setPrimero(NodoCola primero) {
		this.primero = primero;
	}

	//Metodo para verificar si la Cola esta vacia
	@Override
	public boolean esVacia() {
		if(primero == null){
			return true;
		}else{
			return false;
		}
	}

	//Metodo para vaciar la Cola
	@Override
	public void vaciar() {
		primero = null;
	}

	//Metodo para ingresar un Objeto en la cola
	@Override
	public void encolar(Object o) {
		NodoCola nuevo = new NodoCola(o);
		if(esVacia()){
			primero = nuevo;
		}else{
			NodoCola auxiliar = primero;
			while(auxiliar.getReferencia() != null){
				auxiliar = auxiliar.getReferencia();
			}
			auxiliar.setReferencia(nuevo);
		}
		
	}

	//Obtener el Primer elemento de la Cola
	@Override
	public Object primero() {
		if(esVacia()){
			return "La lista esta vacia";
		}else{
			return primero.getDato();
		}
	}

	//Metodo para eliminar el primer elemento
	@Override
	public void desencolar() {
		if(esVacia()){
			System.out.println("La lista esta vacia");
		}else{
			primero = primero.getReferencia();
		}
	}

}
