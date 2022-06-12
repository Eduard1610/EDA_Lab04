public class DoubleLinkedList <E extends Comparable<E>>{
    private Node <E> root;//Nodo cabeza
    private Node <E> last;//Nodo final
    public int tamano;//tamaño de la lista
    public DoubleLinkedList(){
        root = null;
        last = null;
        tamano = 0;
    }
    public void add(E x){
        Node <E> aux = new Node(x);
        if(isEmpty())//Si esta vacia la lista
            this.root = aux;//El nodo cabeza sera el nodo agregado
        else{//Si tiene por lo menos un elemento
            this.last.setNext(aux);//El nextNode de last sera el nuevo nodo creado
            aux.setPrevious(this.last);//Se establece que previousNode sera el last
        }
        this.last = aux;//Se establece que el nodo creado sera ahora el ultimo de la lista
        tamano++;//Se incrementa la cantidad del tamaño de la lista
    }

    //Metodos auxiliares--------------------------------------

    public boolean isEmpty(){//Verifica si la lista esta vacia
        return this.root == null;
    }
}
