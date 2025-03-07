package Interface;

import java.util.List;

import Dominio.Autos;

public interface Metodos {

	
	public void guardar(Autos autos);
	
	public List<Autos> mostrar();
	
	public Autos buscarXindice(int indice);
	
	public void editar(int idice, Autos autos);
	
	public void eliminar(int indice);
}
