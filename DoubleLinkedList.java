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

    public Node<E> get(int indice) {//Se extrae un nodo segun un indice
        if(indice >= tamano)//Si el indice es mayor que el tamaño de la lista se retorna un null
            return null;
        Node <E> aux = root;//Se utiliza una variable auxiliar que almacenara el nodo root
        for(int i=0;i<indice;i++)//recorrera la lista hasta encontrar el nodo en la posicion del indice
            aux = aux.getNext();//Por cada iteracion aux almacenara el nextNode del nodo actual
        return aux;//se retorna el nodo en el indice indicado
    }

    public void remove(int indice) {//Remueve el nodo en el indice dado
       if(indice<tamano) {
           if(indice==0){//Caso: Se remueve el nodo cabeza
               root=root.getNext();//El nextNode de la cabeza sera la nueva cabeza de la lista
               root.setPrevious(null);//El previousNode de la nueva Cabeza ahora sera null
           }
           else {//Caso: Nodo distintos a la cabeza
               Node<E> anterior=this.get(indice).getPrevious(); //Se almacena en anterior el previosNode del nodo en el indice dado
               anterior.setNext(this.get(indice).getNext());//Este previousNode se conectara al nextNode
               if(anterior.getNext() != null)//Caso: Nodo en el indice dado no es el ultimo
                   anterior.getNext().setPrevious(anterior);//Existe un elemento en nextNode(distinto a null) por lo que se debe establecer su previousNode
           }
           tamano--;//Se reduce el contador del tamaño de la lista
       }
   }


    //Metodos auxiliares--------------------------------------

    public boolean isEmpty(){//Verifica si la lista esta vacia
        return this.root == null;
    }
}
