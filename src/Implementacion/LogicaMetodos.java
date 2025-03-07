package Implementacion;

import java.util.ArrayList;
import java.util.List;

import Dominio.Autos;
import Interface.MetodoDos;
import Interface.Metodos;

public class LogicaMetodos implements Metodos, MetodoDos{

	List<Autos> registros = new ArrayList<Autos>();
	@Override
	public void guardar(Autos autos) {
		// TODO Auto-generated method stub
		boolean bandera = false;
				for(Autos a: registros) {
					if(a.getModelo().equals(autos.getModelo())) {
						System.out.println("El registro ya existe");
						bandera = true;
						break;
					}
				}
				if(!bandera) {
					registros.add(autos);
					System.out.println("Se guardo con exito");
				}
					
				
	}

	@Override
	public List<Autos> mostrar() {
		// TODO Auto-generated method stub
		
		return registros;
	}

	@Override
	public Autos buscarXindice(int indice) {
		// TODO Auto-generated method stub
		return registros.get(indice);
	}

	@Override
	public void editar(int idice, Autos autos) {
		// TODO Auto-generated method stub
		registros.set(idice, autos);
		
	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		registros.remove(indice);
	}

	
	//-----NUEVOS METODOS AGREGADOS PARA IMPLEMENTARR
	
	@Override
	public Autos buscarXmodelo(String modelo) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		Autos autos = null;
		for(int i= 0;i<registros.size();i++ ) {
			if(modelo.equals(registros.get(i).getModelo())) {
				autos = registros.get(i);
				System.out.println("producto encontrado : "+autos);
				bandera=true;
			}
		}
		if(!bandera) {
			System.out.println("---no se encontró producto--");
			 
		}
		
		return autos;
	}

	@Override
	public Autos buscarXmarca(String marca) {
		// TODO Auto-generated method stub
		
		boolean bandera = false;
		Autos autos = null;
		for(int i= 0;i<registros.size();i++ ) {
			if(marca.equals(registros.get(i).getMarca())) {
				autos = registros.get(i);
				System.out.println("Marca encontrada : "+autos);
				bandera=true;
			}
		}
		if(!bandera) {
			System.out.println("--no se encontró producto--");
			
		}
		return autos;
	}

	//
	@Override
	public void dineroInvertiddo() {
		// TODO Auto-generated method stub
		
		float total=0;	
		
		for(int i =0 ; i<registros.size(); i++) {
			total += registros.get(i).getPrecio() * registros.get(i).getStock();		
		}
		System.out.println("Tolat de dinero: "+total);
		
	}

	@Override
	public void editarXmodelo(Autos autos) {
		// TODO Auto-generated method stub
		
		
		for(int i=0;i<registros.size();i++){
			if(registros.get(i).getModelo().equals(autos.getModelo())) {
				registros.set(i, autos);
				System.out.println("Se edito exitosamente");
				break;
			}
		}
	}

	@Override
	public void eliminarXmodelo(String modelo) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		for(int i= 0; i<registros.size();i++) {
			if(registros.get(i).getModelo().equals(modelo)) {
				registros.remove(i);
				System.out.println("Se elimino con exito");
				bandera=true;
			}
		}
		if(bandera==false) {
			System.out.println("No se encontro registro");
		
		}
	}

}
