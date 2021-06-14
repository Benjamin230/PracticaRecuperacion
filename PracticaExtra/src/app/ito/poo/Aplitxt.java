package app.ito.poo;
import Escri.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import Composiciones.*;


import Exenciones.*;

public class Aplitxt {
	static LectordeArchivos ar;
	static Archivo1 ar2;

	static Composicion2 c;
	static Scanner en=new Scanner (System.in);
	private static Comosicion1 co= new Comosicion1( null, null, 0, 0, null, null, null);
	
	static Comosicion1 capturaDatos() throws ExisteEx {
		en.nextLine();
		System.out.print("Escribe el Tema de la cancion");
		String titulo=en.nextLine();
		co.setTemadeComposicion(titulo);
		System.out.println(" genero de la cancion");
		co.setGenero(en.nextLine());
		System.out.println("minutos que dura la cancion");
		co.setTiempoMinutos(en.nextInt());en.nextLine();
		System.out.println("segundos que dura la cancion");
		co.setTiempoSegundos(en.nextInt());en.nextLine();
		System.out.println("Escribe la fecha de la composicion");
		co.setFechadeRegistro(LocalDate.parse(en.nextLine()));
		System.out.println("Escribe la fecha de estreno");
		co.setFechaEstreno(LocalDate.parse(en.nextLine()));
		co.setCantantes("null");
		for(int i=0;i<c.getSize();i++) {
			if(titulo.equalsIgnoreCase(c.getComposicion(i).getTemadeComposicion()))
				throw new ExisteEx("Has guardado un tema existente");
				
		}
		return co;
	}
	static void agregarComposicion() throws ExisteEx {
		Comosicion1 cb;
cb=capturaDatos();
if(c.addComposicion(cb))
		System.out.println("Tu cancion se agrego con exito!!");
		
	}
	
	static Comosicion1 aleatorio(String aleatorio) {
		co=null; int i=0;
		for(;i<c.getSize();i++) {
			co=c.getComposicion(i);
			System.out.println(c.getComposicion(i)+"\n Es la composicion?:  "+aleatorio);en.nextLine();
			if (en.nextLine().equalsIgnoreCase("Si")) 
				break;
			co=null;
		}
		return co;
	}
	
	static void agregaInterprete() {
		if(!c.isFree()) {
			co=aleatorio("Ingresando");
				System.out.println("Introduce el nombre del Cantante ");
				co.agregarInterpret(en.nextLine());
			}else
			System.out.println("No existe ninguna Cancion");
		
	}
	static void eliminaInterprete() {
		if(!c.isFree()) {
			co=aleatorio("Eliminando");
				System.out.println("introduce el nombre del Cantante para eliminarlo");
				co.eliminarInterpret(en.nextLine());
			
		}else
			System.out.println("No hay Canciones existentes");
	}
	static void listado() {
		if(!c.isFree()) {
			System.out.println("Listado de Canciones ");
			for(int i=0;i<c.getSize();i++) 
				System.out.println(c.getComposicion(i));
		}else
			System.out.println("No se encontro ninguna Cancion");
			
	}
	
	
	static void ElimiaComposicion()throws EliminarEx{
		   if(!c.isFree()) {
				  Comosicion1 a=aleatorio("Eliminando Cancion....");
				  if(a.getCantantes().equalsIgnoreCase("")||a.getCantantes().equalsIgnoreCase(null)) {
				 if(a!=null) { 
					  c.delete(a);
					 System.out.println("La Cancion fué Borrado");
				 		}else 
					  System.out.println("Ocurrio un error al eliminar la Cancion");
				 }else
					 throw new EliminarEx("Para Eliminar una Cancion, no debe");
			}else	  
				  System.out.println("No existe ninguna Cancion");
	}
	
	
	
	static void menuConsultas () {
		int ln=0;
		while(true) {
			  System.out.println(" 1.- Añadir Cantante");  
			  System.out.println(" 2.- Eliminar Cantante");  
			  System.out.println(" 3.- salir");
			  ln=en.nextInt();	
			  switch(ln){
			  	case 1:agregaInterprete(); break;
			  	case 2:eliminaInterprete();break;
		     }if(ln>2)
		    	 break;
			  
		}
	}
	
	static void menuPrincipal() throws EliminarEx, ExisteEx, FileNotFoundException {
		int l;
		boolean bandera =true;
		while(bandera){
			  System.out.println(" 1.- Agrega nueva Cancion "); 
			  System.out.println(" 2.- lista de Canciones");    
			  System.out.println(" 3.- Eliminar Cancion ");  
			  System.out.println(" 4.- Menu de consultas internas");  
			  System.out.println(" 5.-salir");
			  l=en.nextInt();
			  switch(l){
			  	case 1:agregarComposicion();break;
			  	case 2:listado();break;
			  	case 3:ElimiaComposicion();break;
			  	case 4:	menuConsultas();break;	  	
			  	case 5:Registrar(); abrirArchivo();bandera =false; break;
		     }
		}
	}
	static void Registrar() throws FileNotFoundException {
		  if(c.isFree()) 
			System.out.println("No se encuentra nignun registro");
		  else {			  
			    ar2 = new Archivo1("Composiciones.txt");
			  for(int i=0;i<c.getSize();i++) {
				  ar2.writeString(c.getComposicion(i).getTemadeComposicion());
				  ar2.writeString(c.getComposicion(i).getGenero());
				  ar2.writeString(c.getComposicion(i).getCantantes());
				  ar2.writeInt(c.getComposicion(i).getTiempoMinutos());
				  ar2.writeInt(c.getComposicion(i).getTiempoSegundos());
				  ar2.writeString(c.getComposicion(i).getFechadeRegistro().toString());
				  if(c.getComposicion(i).getFechadeRegistro()==null)
					  ar2.writeStringLn("null \n");
				  else
				  ar2.writeStringLn(c.getComposicion(i).getFechadeRegistro().toString()+"\n");
				  
				  ar2.writeString(c.getComposicion(i).getFechadeEstreno().toString());
				  if(c.getComposicion(i).getFechadeEstreno()==null)
					  ar2.writeStringLn("null \n");
				  else
				  ar2.writeStringLn(c.getComposicion(i).getFechadeEstreno().toString()+"\n");
			  }
			  ar2.close();  			  
		  }

	  }
	static  void  abrirArchivo ()  throws FileNotFoundException {
		ar =  new  LectordeArchivos ( " Composiciones.txt " );
	}

	
	static void Comenzar() {
		c=new Composicion2();
	}
	static void run2() throws EliminarEx, ExisteEx, FileNotFoundException {
		Comenzar();
		menuPrincipal();
	}	
}