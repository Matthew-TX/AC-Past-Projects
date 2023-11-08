public class UnsortedDoubleLinkedListNode<T> {
	private T value;
	private UnsortedDoubleLinkedListNode<T> next;
	private UnsortedDoubleLinkedListNode<T> back;
	
	public UnsortedDoubleLinkedListNode(T value, UnsortedDoubleLinkedListNode<T> next, UnsortedDoubleLinkedListNode<T> back ) {
		this.value = value;
		this.next = next;
		this.back = back;
	}

	public UnsortedDoubleLinkedListNode<T> getPrevious() {
		return back;
	}

	public void setPrevious(UnsortedDoubleLinkedListNode<T> back) {
		this.back = back;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public UnsortedDoubleLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(UnsortedDoubleLinkedListNode<T> next) {
		this.next = next;
	}
	

}
