
public class UnsortedDoubleLinkedList<T> {
private UnsortedDoubleLinkedListNode<T> header;
	
	
//Constructor
	public UnsortedDoubleLinkedList() {
	header=null;
}

//getSize
	public Integer getSize() {
		UnsortedDoubleLinkedListNode<T> currentItem = header;
		Integer size = 0;
		if(currentItem==null)
		{
			size=null;
		}
		else
		{
			size++;
			while(currentItem.getNext()!=null)
			{
				size++;
				currentItem = currentItem.getNext();
			}
		}
		return size;
	}
	
	
//get
	public T get(int index) throws Exception{
		
		if(header==null || index < 0) {
			throw new OutOfBoundsException();
		}
		 else if (index==0) {
			T rtnValue = header.getValue();
			return rtnValue;
		} else {
			UnsortedDoubleLinkedListNode<T> currentNode = header;
			int currentIndex=1;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex==index && currentNode.getNext()!=null) {
				UnsortedDoubleLinkedListNode<T> nextNode = currentNode.getNext();
				T rtnValue = nextNode.getValue();
				return rtnValue;
			} else {
				throw new OutOfBoundsException();
			}
		}
	}

	
//remove
	public T remove(int index) throws Exception{
		if(header==null || index < 0) {
			throw new OutOfBoundsException();
		} else if (index==0) {
			T rtnValue = header.getValue();
			header = header.getNext();
			return rtnValue;
		} else {
			UnsortedDoubleLinkedListNode<T> currentNode = header;
			int currentIndex=1;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex==index && currentNode.getNext()!=null) {
				UnsortedDoubleLinkedListNode<T> nextNode = currentNode.getNext();
				T rtnValue = nextNode.getValue();
				currentNode.setNext(nextNode.getNext());
				return rtnValue;
			} else {
				throw new OutOfBoundsException();
			}
		}
	}
	
	
//insert
	public int insert(T value,int index) {
		int currentIndex = 0;
		if(header==null) {
			header = new UnsortedDoubleLinkedListNode<T>(value,null,null);
		} else if (index<=0) {
			header = new UnsortedDoubleLinkedListNode<T>(value,header,null);
		} else {
			UnsortedDoubleLinkedListNode<T> currentNode = header;
			currentIndex++;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			UnsortedDoubleLinkedListNode<T> insertedNode = new UnsortedDoubleLinkedListNode<T>(value,currentNode.getNext(),currentNode);
			currentNode.setNext(insertedNode);
		}
		
		
		return currentIndex;
	}
	
//add
	public int add(T value) {
		
		UnsortedDoubleLinkedListNode<T> currentNode = header;
		int index=0;
		
		if(header==null)
		{
			header = new UnsortedDoubleLinkedListNode<T>(value, null,  null);
		}
		else
		{
			while ( currentNode.getNext()!=null)
			{
				currentNode = currentNode.getNext();
			}
			UnsortedDoubleLinkedListNode<T> insertedNode = new UnsortedDoubleLinkedListNode<T>(value,currentNode.getNext(),currentNode);
			currentNode.setNext(insertedNode);
			currentNode.setPrevious(currentNode);
		}
		
	return index;
	}
	
	

//toString
	public String toString() {
		int index=0;
		String toString = "";
		if(header == null) {
			toString = "List is empty";
		} else {
			UnsortedDoubleLinkedListNode<T> current = header;
			index++;
			for(int i=0; i<index; i++) {
				if(current!=null)
				{
					toString+=current.getValue()+", ";
					current = current.getNext();
					index++;
				}
			}
		}

		return toString;
	}
		
//toStringRecursion
	public String toStringRecursion() {
		if(header == null) {
			return "List is empty";
		} else {
			String rtn  = "";
			UnsortedDoubleLinkedListNode<T> current = header;
			while(current!=null) {
				rtn+=current.getValue()+", ";
				current = current.getNext();
			}
			return rtn;
		}
	}
	
	
}
