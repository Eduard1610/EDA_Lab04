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

   public long insertionSort(){//Ordena la lista
        Node <E> key;//variable auxiliar - almacenara un nodo
	      int i;
        long nano_startTime = System.nanoTime();//Inicio de contador de tiempo de ejecucion
	      for (int j=1; j< tamano; j=j+1) {
            key = this.get(j);//Se almacena el nodo en j (empezando desde la posicion 1)
            i=j-1;
            while(i>-1 && this.get(i).getData().compareTo(key.getData())>0)//Evalua si los nodos en i son menores al nodo en j
                i--;//Si es cierto se reduce el indice i
            if(i != j-1){//En caso de que hubo alguna reduccion en el indice i
                this.remove(j);//Se remueve el nodo en j (este aun se encuentra almacenado en key)
                tamano++;//debido al remove, la lista se tomara como una lista de n-1 elementos, sin embargo, no se esta eliminando permanentemente sino que solo se hara un reordenamiento de nodos
                if(i == -1){//Caso: La comparacion llego hasta el primer elementos
                    key.setNext(this.root);//el nextNode de key sera el nodo root
                    this.root.setPrevious(key);//el previousNode de root sera key
                    this.root = key;//El nuevo nodo root sera key
                }
                else{//Caso: La comparacion llego a un nodo distinto del nodo root
                    this.get(i+1).setPrevious(key);//Se hace las vinculacion respectivas de nextNode y previousNode
                    key.setPrevious(this.get(i));//Ademas se considera que el indice i señala a una posicion anterior
                    key.setNext(this.get(i+1));// en la que deberia insertarse el nodo con indice j
                    this.get(i).setNext(key);
                }
            }
	      }
        long nano_endTime = System.nanoTime();//Fin de contador de tiempo de ejecucion
	      return nano_endTime - nano_startTime;//devuelve el tiempo total de ejecucion
    }


    //Metodos auxiliares--------------------------------------

    public boolean isEmpty(){//Verifica si la lista esta vacia
        return this.root == null;
    }
    public String toString(){//Imprime los elementos de la lista
        String str = "";
        for(int i = 0; i < tamano; i++){
            str += this.get(i).getData() + " ";
        }
        return str;
    }
}
