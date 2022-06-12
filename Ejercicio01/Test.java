import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		LinkedList<Integer> lint = new LinkedList<Integer>();

		// // LLENANDO LA LISTA
		// lint.insertFirst(10);
		// System.out.println(lint);
		// lint.insertFirst(14);
		// System.out.println(lint);
		// lint.insertFirst(7);
		// System.out.println(lint);
		// lint.insertFirst(23);
		// System.out.println(lint);
		// lint.insertFirst(18);
		// System.out.println(lint);
		// lint.insertFirst(6);
		// System.out.println(lint);
		// lint.insertFirst(19);
		// System.out.println(lint);
		// lint.insertFirst(25);
		// System.out.println(lint);

		ArrayList<LinkedList<Integer>> casos = new ArrayList<LinkedList<Integer>>();
		Scanner sc = new Scanner( System.in );
	    System.out.print( "Introduzca el tamaño máximo del último arreglo: " );
	    int tamano = sc.nextInt();
	    
	    for(int n = 1; n <= tamano; n++) 
	    	casos.add(generarPeorCaso(n));
	    
		for(LinkedList<Integer> caso: casos) 
			System.out.println(caso);
	}
	
	public static LinkedList<Integer> generarPeorCaso(int t) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < t; i++) {
			list.insertLast(t-i);
		}
		return list;
	}
}
