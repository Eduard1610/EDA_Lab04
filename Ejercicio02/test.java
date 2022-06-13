import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.panayotis.gnuplot.JavaPlot; 

public class test {

    public static DoubleLinkedList <Integer> peorCaso(int n){
        DoubleLinkedList <Integer> lista = new DoubleLinkedList <Integer>();
        for(int i = n; i > 0; i--){
            lista.add(i);
        }
        return lista;
    }

    public static void main(String [] args) throws IOException{
        int tamano;
        Scanner teclado = new Scanner( System.in );
        System.out.print( "Introduzca el tamaño máximo del último arreglo: " );
        tamano = teclado.nextInt();

        ArrayList<DoubleLinkedList<Integer>> casos = new ArrayList<>();
        String archivoInsercion = "insercion.txt";
        PrintWriter oS = new PrintWriter(archivoInsercion);

        for(int n=1; n<=tamano; n++)
            casos.add(peorCaso(n));
        Iterator<DoubleLinkedList<Integer>> puntero = casos.iterator();
        while(puntero.hasNext())
            oS.println(String.valueOf(puntero.next().insertionSort()));
        oS.close();

        JavaPlot p = new JavaPlot();
        p.addPlot("\"insercion.txt\" with lines");
        p.plot();
    }

}

