class SimpleStack<V> {

	private Node top;

	//inner member class - class defined directly inside its outer class
	//and has access to all the members of that outer class
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
}

