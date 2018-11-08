/**
 * Interface: ICola
 * 
 * Interface con los metodos utilizados por una Cola
 * 
 * @author Hector Marion
 * 
 * Version: 10.06.2018.2
 */

package estructura;

public interface ICola {

	public boolean esVacia();
	
	public void vaciar();
	
	public void encolar(Object o);
	
	public Object primero();
	
	public void desencolar();
	
}
