package unPaquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Carrera {
	private Corredor[] corredores;
	private int[] corredoresGanadores;
	private Categoria[] cantCategoriasF;
	private Categoria[] cantCategoriasM;
	private int[][] ganadores;
	private String path;
	public Carrera(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path+".in"));
		this.path = path;
		corredores = new Corredor[sc.nextInt()];
		cantCategoriasF = new Categoria[sc.nextInt()];
		cantCategoriasM = new Categoria[sc.nextInt()];
		corredoresGanadores = new int[sc.nextInt()];
		ganadores = new int[cantCategoriasF.length + cantCategoriasM.length][4];
		for (int i = 0; i < cantCategoriasF.length; i++) {
			cantCategoriasF[i] = new Categoria(sc.nextInt(),sc.nextInt());
			ganadores[i][0] = i+1;
			
		}
		for (int i = 0; i < cantCategoriasM.length; i++) {
			cantCategoriasM[i] = new Categoria(sc.nextInt(),sc.nextInt());
			ganadores[cantCategoriasF.length+i][0] = i+1;
		}
		for (int i = 0; i < corredores.length; i++) {
			corredores[i] = new Corredor(sc.nextInt(),sc.next().charAt(0));
		}
		for (int i = 0; i < corredoresGanadores.length; i++) {
			corredoresGanadores[i] = sc.nextInt();
		}
		sc.close();
	}

	
	public void mostrarTodo() {
		for (int i = 0; i < cantCategoriasF.length; i++) {
			System.out.println(cantCategoriasF[i].getEdadMinima() + " " + cantCategoriasF[i].getEdadMaxima());
		}
		for (int i = 0; i < cantCategoriasM.length; i++) {
			System.out.println(cantCategoriasM[i].getEdadMinima() + " " + cantCategoriasM[i].getEdadMaxima());
		}
		for (int i = 0; i < corredores.length; i++) {
			System.out.println(corredores[i].getEdad() + " " + corredores[i].getSexo());
		}
		for (int i = 0; i < corredoresGanadores.length; i++) {
			System.out.println(corredoresGanadores[i]);
		}
	}
	
	public void resolver() {
		Corredor corredorAux;
		int filaGanadora;
		int j = 1;
		for (int i = 0; i < corredoresGanadores.length; i++) {
			corredorAux =  corredores[corredoresGanadores[i]-1];
			filaGanadora = getFila(corredorAux);
			while(j < ganadores[0].length && ganadores[filaGanadora][j] != 0) {
				j++;
			}
			if (j != ganadores[0].length) {
				ganadores[filaGanadora][j] = corredoresGanadores[i];
			}
			j=0;
		}
	}


	private int getFila(Corredor corredorAux) {
		int i = 0;
		if(corredorAux.getSexo() == 'F') {
			while( i < cantCategoriasF.length && !(cantCategoriasF[i].getEdadMinima() <= corredorAux.getEdad() && cantCategoriasF[i].getEdadMaxima() >= corredorAux.getEdad())) {
				i++;
			}
		} else {
			while( i < cantCategoriasM.length && !(cantCategoriasM[i].getEdadMinima() <= corredorAux.getEdad() && cantCategoriasM[i].getEdadMaxima() >= corredorAux.getEdad())) {
				i++;
			}
			i += cantCategoriasF.length;
		}
		return i;
	}
	
	public void mostrarResultado() {
		for (int i = 0; i < ganadores.length; i++) {
			System.out.println(Arrays.toString(ganadores[i]));
		}
	}


	public void imprimirSolucion() throws IOException {
		PrintWriter wr = new PrintWriter(new FileWriter(path+".out"));
		for (int i = 0; i < ganadores.length; i++) {
			for (int j = 0; j < ganadores[0].length; j++) {
				if(j != ganadores[0].length-1) {
					wr.print(String.valueOf(ganadores[i][j]) + " ");
				} else {
					wr.print(String.valueOf(ganadores[i][j]));
				}
			}
			wr.println();
		}
		wr.close();
	}
	
	
	
}
