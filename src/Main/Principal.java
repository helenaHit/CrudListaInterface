package Main;

import java.util.Scanner;

import Dominio.Autos;
import Implementacion.LogicaMetodos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lectura = null;
		
		String marca;
		String modelo;
		float precio;
		int stock, menuPrinc,subMenu,indice;
		
		Autos autos = null;
		LogicaMetodos impl = new LogicaMetodos();
		
		
		//Menu principal
		do {
			System.out.println(".::MENU PRINCIPAL::.");
			System.out.println("1---ALTA");
			System.out.println("2---MOSTRAR");
			System.out.println("3---BUSAR");
			System.out.println("4---EDITAR");
			System.out.println("5---ELIMINAR");
			System.out.println("6---BUSCAR POR MODELO");
			System.out.println("7---BUSCAR POR MARCA");
			System.out.println("8---CALCULAR DINERO INVERTIDO");
			System.out.println("9---EDITAR BUSCANDO POR MODELO");//EDITAR EL STOCK
			System.out.println("10---ELIMINAR BUSCANDO POR MODELO");
			System.out.println("11---SALIR");
			
			
			lectura = new Scanner(System.in);
			menuPrinc= lectura.nextInt();
			
			switch (menuPrinc) {
			case 1:
				try {
					System.out.println("Ingresa marca");
					lectura = new Scanner(System.in);
					marca = lectura.nextLine();
					
					System.out.println("Ingresa modelo");
					lectura = new Scanner(System.in);
					modelo = lectura.nextLine();
					
					System.out.println("Ingresa precio");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();
					
					System.out.println("Ingresa stock");
					lectura = new Scanner(System.in);
					stock = lectura.nextInt();
					
					
					
					//invocar el objeto que ya creamos
					autos= new Autos(marca, modelo, precio, stock);
					//guardamos el objeto
					impl.guardar(autos);
					
				} catch (Exception e) {
					System.out.println("Error al guardar datos "+e.getMessage());
				}
				
				break;

			case 2:
				try {
					System.out.println(impl.mostrar());
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 3:
				try {
					System.out.println("Ingresa el indice del registro a buscar");
					lectura = new Scanner(System.in);
					indice= lectura.nextInt();
					
					//buscamos el indice
					//dentro dl objeto auto guardamos el objeto encontrado
					autos = impl.buscarXindice(indice);
					System.out.println("se encontro el indice" + autos);
				} catch (Exception e) {
					System.out.println("Error al buscar"+e.getMessage());
				}

				break;

			case 4:
				System.out.println("Ingresa el indice a editar");
				lectura = new Scanner(System.in);
				indice = lectura.nextInt();
				
				//despues de buscar el indice que vamos a editar.... 
				autos = impl.buscarXindice(indice);
				System.out.println("se encontro el indice" + autos);
				
				//....agregamos submenu para ediar
				
				do {
					System.out.println(".::SUBMENU::.");
					System.out.println("1--EDITAR MARCA");
					System.out.println("2---EDITRA MODELO");
					System.out.println("3---MENU PRINCIPAL");
					
					lectura = new Scanner(System.in);
					subMenu= lectura.nextInt();
					
					switch (subMenu) {
					case 1:
						System.out.println("ingresa marca");
						lectura = new Scanner(System.in);
						marca = lectura.nextLine();
			
						
						//actualizar el objeto
						autos.setMarca(marca);
						//actualizamos la lista
						impl.editar(indice, autos);
						System.out.println("Se edito marca");
						break;

					case 2:
						System.out.println("Ingresa modelo");
						lectura = new Scanner(System.in);
						modelo = lectura.nextLine();
						
						//actualizar el objeto auto
						autos.setModelo(modelo);
						//actualizar lista
						impl.editar(indice, autos);
						System.out.println("se actuaizo modelo");
						break;
					
					case 3:
						break;
					}	
				} while (subMenu<3);	
								
				break;
			case 5:
				try {
					System.out.println("ingresa indice a eliminar");
					lectura = new Scanner(System.in);
					indice= lectura.nextInt();
				
					impl.eliminar(indice);
					System.out.println("Se elimno con exito");
					
				} catch (Exception e) {
					System.out.println("error al eliminar"+e.getMessage());
				}	
				break;

			case 6:
				System.out.println("buscar por modelo");
				lectura = new Scanner(System.in);
				modelo = lectura.nextLine();
				
				autos = impl.buscarXmodelo(modelo);
				break;
			case 7:
				System.out.println("buscar por marca");
				lectura = new Scanner(System.in);
				marca = lectura.nextLine();
				
				autos = impl.buscarXmarca(marca);
				break;
			case 8:
				try {
					System.out.println("TOTAL DE DINERO EN PRODUCTOS");
					 impl.dineroInvertiddo();
				
				} catch (Exception e) {
					System.out.println("fallo calculo");
				}
				break;
			case 9:
				System.out.println("Ingresa modelo para ditar");
				lectura = new Scanner(System.in);
				modelo = lectura.nextLine();
				//PRIMERO BUSCAMOS
				autos = impl.buscarXmodelo(modelo);
				//System.out.println("se encontro el registro" + autos);
				
				if(autos!=null) {
					//PEDIMOS EL NUEVO VALOR
					System.out.println("ingresa nuevo modelo");
					lectura = new Scanner(System.in);
					modelo = lectura.nextLine();
		
					autos.setModelo(modelo);
					impl.editarXmodelo(autos);
				}
				
				
				break;
			case 10:
				System.out.println("Eliminar por modelo");
				lectura = new Scanner(System.in);
				modelo = lectura.nextLine();
				
				impl.eliminarXmodelo(modelo);
				break; 	
			
			case 11:
				break;
			}
			
					
		} while (menuPrinc<11);
	}

}
