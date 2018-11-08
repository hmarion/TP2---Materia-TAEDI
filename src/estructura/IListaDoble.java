/**
 * Interface: ICola
 * 
 * Interface con los metodos utilizados por una Cola
 * 
 * @author Hector Marion
 * 
 * Version: 08.07.2018.2
 */

package estructura;

public interface IListaDoble{

	public boolean esVacia();
	
	public void vaciar();
	
	public void listarAscendente();
	
	public void insertar(Comparable dato);
	
	public Object eliminar(Object dato);
}
