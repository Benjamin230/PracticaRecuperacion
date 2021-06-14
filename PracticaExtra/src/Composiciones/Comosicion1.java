package Composiciones;
import java.time.LocalDate;

import Exenciones.ExisteEx;
public class Comosicion1 implements Comparable<Comosicion1>{

	
	private String temadeComposicion="";
	private String genero="";
	private int tiempoSegundos=0,tiempoMinutos=0;
	private String cantantes="";
	private java.time.LocalDate fechadeRegistro=null;
	private java.time.LocalDate fechadeEstreno=null;
	
	
	
	public Comosicion1(String temadeComposicion, String genero,int tiempoSegundos, int tiempoMinutos,
			String cantantes, LocalDate fechadeRegistro, LocalDate fechadeEstreno) {
		super();
		this.genero=genero;
		this.temadeComposicion = temadeComposicion;
		this.tiempoSegundos = tiempoSegundos;
		this.tiempoMinutos = tiempoMinutos;
		this.cantantes = cantantes;
		this.fechadeRegistro = fechadeRegistro;
		this.fechadeEstreno = fechadeEstreno;
	}
	
	public boolean agregarInterpret(String a ) {
		boolean agregar=false;
		if(a!=null&&!a.equalsIgnoreCase("")) { 
		this.cantantes=a;
		agregar=true;
		}else
			agregar =false;
		return agregar;
	}
	
	public boolean eliminarInterpret(String a){
		boolean elimina=false;
		if(a.equalsIgnoreCase(this.cantantes)) {
			this.cantantes="";
			elimina=true;
		}else
				elimina=false;
		return elimina;
	}
	


	@Override
	public int compareTo(Comosicion1 o)  {
		// TODO Auto-generated method stub
		int compare=0;
		if(this.temadeComposicion.equals(o.getTemadeComposicion()))
			compare=0;
		else if(!this.temadeComposicion.equalsIgnoreCase(o.getTemadeComposicion()))
			compare=1;
		return compare;
	}

	
	public void setGenero(String genero) {
		this.genero=genero;
	}
	public String getGenero() {
		return genero;
		
	}
	public String getTemadeComposicion() {
		return temadeComposicion;
	}


	public void setTemadeComposicion(String temadeComposicion) {
		this.temadeComposicion = temadeComposicion;
	}


	public int getTiempoSegundos() {
		return tiempoSegundos;
	}


	public void setTiempoSegundos(int tiempoSegundos) {
		this.tiempoSegundos = tiempoSegundos;
	}


	public int getTiempoMinutos() {
		return tiempoMinutos;
	}


	public void setTiempoMinutos(int duracionMin) {
		this.tiempoMinutos = duracionMin;
	}


	public String getCantantes() {
		return cantantes;
	}


	public void setCantantes(String cantantes) {
		this.cantantes = cantantes;
	}


	public java.time.LocalDate getFechadeRegistro() {
		return fechadeRegistro;
	}


	public void setFechadeRegistro(java.time.LocalDate fechaRegistro) {
		this.fechadeRegistro = fechaRegistro;
	}


	public java.time.LocalDate getFechadeEstreno() {
		return fechadeEstreno;
	}


	public void setFechaEstreno(java.time.LocalDate fechaEstreno) {
		this.fechadeEstreno = fechaEstreno;
	}


	@Override
	public String toString() {
		return "Composicion [temadeComposicion=" + temadeComposicion+", genero="+genero
				+ ", tiempoSegundos=" + tiempoSegundos + ", tiempoMinutos=" + tiempoMinutos + ", cantantes="  +cantantes
				+ ", fechaRegistro=" + fechadeRegistro + ", fechaEstreno=" + fechadeEstreno + "]";
	}



	
	
	
}