public class UnsortedLinkedListNode<T> {
	private T value;
	private UnsortedLinkedListNode<T> next;
	
	public UnsortedLinkedListNode(T value, UnsortedLinkedListNode<T> next) {
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public UnsortedLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(UnsortedLinkedListNode<T> next) {
		this.next = next;
	}
	

}
