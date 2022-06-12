public class DoubleLinkedList <E extends Comparable<E>>{
    private Node <E> root;//Nodo cabeza
    private Node <E> last;//Nodo final
    public int tamano;//tamaño de la lista
    public DoubleLinkedList(){
        root = null;
        last = null;
        tamano = 0;
    }
}
