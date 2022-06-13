
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import com.panayotis.gnuplot.JavaPlot;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		ArrayList<LinkedList<Integer>> casos = new ArrayList<LinkedList<Integer>>();
		String archivo1 = "insertionsort.txt";
	    PrintWriter oS = new PrintWriter(archivo1); 
		Scanner sc = new Scanner( System.in );
	    	System.out.print( "Introduzca el tamaño máximo del último arreglo: " );
	    	int tamano = sc.nextInt();
	    
	    	for(int n = 1; n <= tamano; n++) 
	    		casos.add(generarPeorCaso(n));
	    
	    	Iterator<LinkedList<Integer>> lista = casos.iterator();
		    
		    while(lista.hasNext()){      	
		    	oS.println(String.valueOf(LinkedList.insertionSort(lista.next())));        	
		    }
		    
		    oS.close();
		    JavaPlot p = new JavaPlot();
			p.addPlot("\"C:/Users/Home/eclipse-workspace/Ejercicio01/insertionsort.txt\" with lines");
			p.plot();
			
		
	}
	
	
	
	public static LinkedList<Integer> generarPeorCaso(int t) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < t; i++) {
			list.insertLast(t-i);
		}
		return list;
	}


}
