package app.ito.poo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.Scanner;

import Composiciones.*;
import Exenciones.*;

public class Aplibinario {
static RandomAccessFile rasf;
static Scanner en=new Scanner (System.in);
static Composicion2 c;
private static Comosicion1 co= new Comosicion1( null, null, 0, 0, null, null, null);
	
	   
	
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
	

	
	static Comosicion1 capturaDatos() throws ExisteEx {
		en.nextLine();
		System.out.print("Escribe el tema de la Cancion");
		String titulo =en.nextLine();
		co.setTemadeComposicion(titulo);
		System.out.println("Escribe el genero de la Cancion");
		co.setGenero(en.nextLine());
		System.out.println("minutos que dura la cancion");
		co.setTiempoMinutos(en.nextInt());en.nextLine();
		System.out.println("segundos que dura la cancion");
		co.setTiempoSegundos(en.nextInt());en.nextLine();
		System.out.println("Escribe la fecha de la Cacion");
		co.setFechadeRegistro(LocalDate.parse(en.nextLine()));
		System.out.println("Escribe la fecha de estreno");
		co.setFechaEstreno(LocalDate.parse(en.nextLine()));
		co.setCantantes("null");
		for(int i=0;i<c.getSize();i++) {
			if(titulo.equalsIgnoreCase(c.getComposicion(i).getTemadeComposicion()))
				throw new ExisteEx("Has introducido un tema existente");
				
		}
		return co;
	}
	
	static void ElimiaComposicion()throws EliminarEx{
		   if(!c.isFree()) {
				  Comosicion1 a=aleatorio("Eliminando Cancion...");
				  if(a.getCantantes().equalsIgnoreCase("")||a.getCantantes().equalsIgnoreCase(null)) {
				 if(a!=null) { 
					  c.delete(a);
					 System.out.println("La composicion fué eliminada");
				 		}else 
					  System.out.println(" error al eliminar la Cancion");
				 }else
					 throw new EliminarEx("Para Eliminar una Cacnion  no debe");
			}else	  
				  System.out.println("No existe ninguna Cancion");
	}
	
	
	static void agregarComposicion() throws ExisteEx {
		Comosicion1 cb;
cb=capturaDatos();
if(c.addComposicion(cb))
		System.out.println("La Cancion se agrego con exito!!");
	


for(int i=0;i<c.getSize();i++) {
	System.out.println("posicion"+(i+1) +c.getComposicion(i));
}
System.out.println("Cual es la posicion donde quieres actualizar el Cantante");

	}
	static void agregaInterprete() {
		if(!c.isFree()) {
			co=aleatorio("Ingresando");
				System.out.println("Introduce el nombre del Cantante");
				co.agregarInterpret(en.nextLine());
			}else
			System.out.println("No existe ninguna Cacion");
		
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
	
	static void menuPrincipal() throws EliminarEx, ExisteEx {
		int l;
		boolean bandera =true;
		while(bandera){
			  System.out.println(" 1.- Agrega una Cancion "); 
			  System.out.println(" 2.-  lista de Canciones");    
			  System.out.println(" 3.- Elimina Cancion");  
			  System.out.println(" 4.- Menu de consultas internas");  
			  System.out.println(" 5.-salir");
			  l=en.nextInt();
			  switch(l){
			  	case 1:agregarComposicion();break;
			  	case 2:listado();break;
			  	case 3:ElimiaComposicion();break;
			  	case 4:	menuConsultas();break;	  	
			  	case 5:bandera =false; break;
		     }
		}
	}
	
		 
	
	static void Comenzar() {
		c=new Composicion2();
	}
	static void run() throws EliminarEx, ExisteEx {
		Comenzar();
		menuPrincipal();
	}
	static void RegistraInfo() throws IOException {
		  if(!c.isFree()) {
			  rasf = new RandomAccessFile("CuentasBancarias.dat","rw");
			  for(int i=0;i<c.getSize();i++) {
				  rasf.writeUTF(c.getComposicion(i).getTemadeComposicion());
				  rasf.writeUTF(c.getComposicion(i).getGenero());
				  rasf.writeUTF(c.getComposicion(i).getCantantes());
				  rasf.writeInt(c.getComposicion(i).getTiempoMinutos());
				  rasf.writeInt(c.getComposicion(i).getTiempoSegundos());
				  
				  rasf.writeUTF(c.getComposicion(i).getFechadeRegistro().toString());
				  if(c.getComposicion(i).getFechadeRegistro()==null)
					  rasf.writeUTF("null \n");
				  else
				  rasf.writeUTF(c.getComposicion(i).getFechadeRegistro().toString()+"\n");
				 
				  rasf.writeUTF(c.getComposicion(i).getFechadeEstreno().toString());
				  if(c.getComposicion(i).getFechadeEstreno()==null)
					  rasf.writeUTF("null \n");
				  else
				  rasf.writeUTF(c.getComposicion(i).getFechadeEstreno().toString()+"\n");
			  }
			}
	  }
}