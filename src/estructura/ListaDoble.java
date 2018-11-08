/**
 * Clase: ListaDoble
 * 
 * @author Hector Marion
 * 
 * Version: 03.07.2018.1
 */

package estructura;

public class ListaDoble implements IListaDoble{

	//Atributos de la Clase
	private NodoDoble primero;
	private NodoDoble ultimo;
	
	//Getters y Setters
	public NodoDoble getPrimero(){
		return primero;
	}

	public void setPrimero(NodoDoble primero){
		this.primero = primero;
	}	
	
	public NodoDoble getUltimo(){
		return ultimo;
	}
	
	public void setUltimo(NodoDoble ultimo){
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
		this.ultimo = null;
	}

	@Override
	public void insertar(Comparable dato){
		NodoDoble nuevo = new NodoDoble(dato);
		NodoDoble auxiliar = this.primero;
		NodoDoble auxiliarAnterior = this.primero;
		
		if(esVacia()){
			this.primero = nuevo;
			this.ultimo = nuevo;
		}else if(dato.compareTo(auxiliar.getDato()) < 0){
			nuevo.setReferenciaSiguiente(this.primero);
			this.primero.setReferenciaAnterior(nuevo);
			this.setPrimero(nuevo);
		}else if(dato.compareTo(this.ultimo.getDato()) >= 0){
			this.ultimo.setReferenciaSiguiente(nuevo);
			nuevo.setReferenciaAnterior(this.ultimo);
			nuevo.setReferenciaSiguiente(null);
			this.setUltimo(nuevo);
		}else{
			while((auxiliar != null) && (dato.compareTo(auxiliar.getDato()) >= 0)){
				auxiliarAnterior = auxiliar;
				auxiliar = auxiliar.getReferenciaSiguiente();
			}
			auxiliarAnterior.setReferenciaSiguiente(nuevo);
			nuevo.setReferenciaAnterior(auxiliarAnterior);
			nuevo.setReferenciaSiguiente(auxiliar);
			auxiliar.setReferenciaAnterior(nuevo);
		}
	}
	
	@Override
	public void listarAscendente(){
		NodoDoble auxiliar = this.primero;
		
		while(auxiliar != null){
			System.out.println(auxiliar.getDato().toString());
			auxiliar = auxiliar.getReferenciaSiguiente();
		}
	}

	@Override
	public Object eliminar(Object dato){
		NodoDoble auxiliar = this.primero;
		NodoDoble auxiliarAnterior = null;
		NodoDoble auxiliarSiguiente = null;
		Object salida = null;
		
		if(this.primero == this.ultimo){
			if(auxiliar.getDato().equals(dato)){
				salida = this.primero.getDato();
				vaciar();
			}
		}else if(this.primero.getDato().equals(dato)){
			salida = this.primero.getDato();
			this.primero = this.primero.getReferenciaSiguiente();
		}else if(this.ultimo.getDato().equals(dato)){
			salida = this.ultimo.getDato();
			this.ultimo = this.ultimo.getReferenciaAnterior();
			this.ultimo.setReferenciaSiguiente(null);
		}else while(auxiliar != null && !auxiliar.getDato().equals(dato)){
			auxiliarAnterior = auxiliar;
			auxiliar = auxiliar.getReferenciaSiguiente();
			if(auxiliar.getReferenciaSiguiente() != null){
				auxiliarSiguiente = auxiliar.getReferenciaSiguiente();
			}else{
				auxiliarSiguiente = null;
			}
			if(auxiliar != null){
				salida = auxiliar.getDato();
				auxiliarAnterior.setReferenciaSiguiente(auxiliarSiguiente);
				if(auxiliarSiguiente != null){
					auxiliarSiguiente.setReferenciaAnterior(auxiliarAnterior);
				}
			}
		}
		return salida;
	}
	
	

}
