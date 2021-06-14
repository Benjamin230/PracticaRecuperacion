package Composiciones;
import Composiciones.Comosicion1;
import Exenciones.*;
import interfacee.*;

public class Composicion2 implements Interfas<Comosicion1>{

	private Comosicion1 grupo []=null;
	private int ultimo=0;
	private final int INC=5;
	
	public Composicion2() {
		super();
		this.grupo=new Comosicion1[INC];
		this.ultimo=-1;
	} 
	private void crecerArreglo() {
	    Comosicion1 temporal[]=new Comosicion1[this.grupo.length+INC];
	    for(int i=0;i<this.grupo.length;i++)	
	    grupo=temporal;
	    }
	
	public boolean addComosicion1(Comosicion1 Comosicion1) {
		// TODO Auto-generated method stub
		boolean bandera=false;
		if(!existeComosicion1(Comosicion1)) {
			if(isFull())
				crecerArreglo();
			int i=0;
			for(;i<=this.ultimo;i++)
				if(Comosicion1.compareTo(grupo[i])<0) {
					break;
				}
			for(int j=this.ultimo;j>=i;j--)
				grupo[j+1]=grupo[j];
			grupo[i]=Comosicion1;
			this.ultimo++;
			bandera=true;
			}
		return bandera;
	}

	public boolean existeComosicion1(Comosicion1 Comosicion1) {
		// TODO Auto-generated method stub
		boolean existe=false;
		for(int i=0;i<=this.ultimo;i++)
			if(Comosicion1.compareTo(grupo[i])==0) {
				existe=true;
				break;
			}
		return existe;
	}

	public Comosicion1 getComosicion1(int pos) {
		// TODO Auto-generated method stub
		Comosicion1 cb=null;
		if(!this.isFree()&& pos<=this.ultimo)
			cb=grupo[pos];
		return cb;
	}
	
	public boolean delete(Comosicion1 Comosicion1){
		boolean delete=false;
		if(this.existeComosicion1(Comosicion1)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(Comosicion1.compareTo(grupo[i])==0)
					break;
			for(;i<this.ultimo;i++)
				grupo[i]=grupo[i+1];
			this.ultimo--;
			delete=true;
		}
		return delete;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.ultimo+1;
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return this.ultimo==-1;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.ultimo+1==this.grupo.length;
	}
	@Override
	public boolean addComposicion(Comosicion1 composicion) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean existeComposicion(Comosicion1 composicion) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Comosicion1 getComposicion(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	}
	
	


