import com.panayotis.gnuplot.JavaPlot; 

public class test {

    public static void main(String[] args) {

        DoubleLinkedList<E> list = new DoubleLinkedList<>();
        JavaPlot p = new JavaPlot();

        p.addPlot("sin(x)");

        p.plot();

    }

}
