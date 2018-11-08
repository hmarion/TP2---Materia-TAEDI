/**
 * Clase: ListaSimple
 * 
 * @author Hector Marion
 * 
 * Version: 03.07.2018.1
 */

package estructura;

public class ListaSimple implements IListaSimple{

	//Atributos de la Clase
	private Nodo primero;
	private Nodo ultimo;
	
	
	//Getters y Setters
	public Nodo getPrimero(){
		return primero;
	}

	public void setPrimero(Nodo primero){
		this.primero = primero;
	}
	
	public Nodo getUltimo(){
		return ultimo;
	}
	
	private void setUltimo(Nodo ultimo){
		this.ultimo = ultimo;
	}
	
	
	@Override
	//Metodo para verificar que la lista esta vacia
	public boolean esVacia(){
		if(primero == null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	//Metodo para vaciar la lista
	public void vaciar(){
		this.primero = null;
	}

	@Override
	public void insertar(char i){
		Nodo nuevo = new Nodo(i);
		
		if(esVacia()){
			this.primero = nuevo;
			this.ultimo = nuevo;
		}else{
			this.ultimo.setReferenciaSiguiente(nuevo);
			this.ultimo = nuevo;
		}
	}
	
	@Override
	public void listarAscendente(){
		Nodo auxiliar = this.primero;
		
		while(auxiliar != null){
			System.out.println(auxiliar.getDato().toString());
			auxiliar = auxiliar.getReferenciaSiguiente();
		}
	}

}
