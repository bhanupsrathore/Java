import java.util.Iterator;

class SmartStack<V> implements Iterable<V> {

	private Node top;

	class Node {
		
		V value;
		Node below;

		Node(V val) {
			value = val;
			below = top;
		}
	}

	public void push(V item) {
		top = new Node(item);
	}	

	public V pop() {
		V item = top.value;
		top = top.below;
		return item;
	}

	public boolean empty() {
		return top == null;
	}

	public Iterator<V> iterator() {
		//returning an instance of an anonymous inner local class (closure) which implements Iterator 
		return new Iterator<V>() {

			private Node current = top;

			public boolean hasNext() {
				return current != null;
			}		

			public V next() {
				V item = current.value;
				current = current.below;
				return item;
			}
		};
	}
}

