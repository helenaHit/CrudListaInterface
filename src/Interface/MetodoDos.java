package Interface;

import Dominio.Autos;

public interface MetodoDos {

	public Autos buscarXmodelo(String modelo);
	
	public Autos buscarXmarca(String marca);
	
	//metodo dinero invertido
	public void dineroInvertiddo();
	
	
	//editarxmodelo
	public void editarXmodelo(Autos autos ) ;
		

	//eiminar buscando por modelo
	public void eliminarXmodelo(String modelo);
	
}
