public class LinkedList<E> {
	private Node<E> first;

	public LinkedList() {

	}

	public boolean isEmpty() {
		return this.first == null;
	}
	
	public int length() {
		int count = 0;
		Node<E> aux = this.first;
		while (aux != null)
			count++;
		return count;
	}
	
	public Node<E> get(int index) {
		int count = 0;
		Node<E> aux = this.first;
		while(count != index) {
			aux = aux.getNext();
			count++;
		}
		return aux;
	}
	public void insertFirst(E x) {
		// 2 MANERAS

		// ( 1 )
//		Node<E> temp = new Node<E>(x);
//		temp.setNext(this.first); // El nuevo nodo apunta a la cabeza
//		this.first = temp;

		// ( 2 )
		this.first = new Node<E>(x, this.first);
	}

	public void insertLast(E x) {
		if (isEmpty())
			insertFirst(x);
		else {
			Node<E> aux = this.first;
			// Cuando encontremos un nodo que tenga un next Nulo
			for (; aux.getNext() != null; aux = aux.getNext());// Omitimos la inicializaci�n (est� arriba) por eso ";"
			aux.setNext(new Node<E>(x));
		}

	}

	public boolean search(E x) {
		Node<E> aux = this.first;
		while (aux != null && !aux.getData().equals(x)) {
			aux = aux.getNext();
		}
		// Si la lista no est� vac�a -> this.first es distinto nulo
		if (aux != null)
			return true;
		return false;
	}

	public void remove(E x) {
		// Si la lista no est� vac�a
		if (!this.isEmpty()) {
			Node<E> aux = this.first;
			//Si se quiere borrar el primer elemento
			if(aux.getData().equals(x)) {
				this.first = aux.getNext(); // El primero se vuelve el siguiente
				//aux.setNext(null); // Cortamos el enlace
			} else {
				while(aux.getNext() != null && !aux.getNext().getData().equals(x))
					aux = aux.getNext();
				// Si aux.getNext() is null es porque recorri� toda la lista y no encontr� el elemento
				if(aux.getNext() != null) 
					aux.setNext(aux.getNext().getNext());
			}
		}
	}
	
	// Como no hay posici�n inferimos 
	public void insert(E x, int p) { // Para un p mayor a el n�mero de elementos
		int index = 0;
		Node<E> aux = this.first;
		Node<E> newNode = new Node<E>(x); // Nuevo nodo
		if (p <= 0)
			insertFirst(x);
		// Buscamos posicionar aux en el index p-1 (una posici�n anterior)
		else {
			while (aux.getNext() != null && index != (p - 1)) {
				aux = aux.getNext();
				index++; // index de mi aux	
			}
		}
		// Enlazamos el nuevo nodo con el siguiente de aux
		newNode.setNext(aux.getNext());
		// Enlazamos el nodo anterior a �ndice p con newNode
		aux.setNext(newNode);	
	}

	public String toString() {
		String str = "";
		for (Node<E> aux = this.first; aux != null; aux = aux.getNext()) {
			str += aux.getData() + ", ";
		}
		return str;
	}
}
