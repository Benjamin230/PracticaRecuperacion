package Escri;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LectordeObjetos {

	private ObjectInputStream informacion;
	
	public LectordeObjetos(String informacion) throws FileNotFoundException, IOException {
		this.informacion= new ObjectInputStream(new FileInputStream(informacion));
	}
	
	public Object readObject() throws ClassNotFoundException, IOException {
		Object aux=null;
		aux= informacion.readObject();
		return aux;
	}
	
	public void close() throws IOException {
		informacion.close();
	}
}
