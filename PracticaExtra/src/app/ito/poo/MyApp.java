package app.ito.poo;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Exenciones.*;
public class MyApp {
	public static void main(String[]Ags) throws EliminarEx, ExisteEx, FileNotFoundException {
		Scanner lector=new Scanner(System.in);
		System.out.println("Buenos Dias Estrellitas del Cielo, el Mundo les dice holaaa \n Eligue el tipo de formato:\n\n1.- Subirlas con un formato txt"
				+ "\n2.- Subirlas con datos binarios \n3.- Cancelar");
		int a=lector.nextInt();lector.nextLine();
		switch(a) {
		
		case 1: Aplibinario.run();break;
		case 2: Aplitxt.run2();break;
		case 3:break;
		
		}
		
	}
}