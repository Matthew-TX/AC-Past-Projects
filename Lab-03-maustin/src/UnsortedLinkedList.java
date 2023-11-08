
public class UnsortedLinkedList<T> {
private UnsortedLinkedListNode<T> header;
	
	
//Constructor
	public UnsortedLinkedList() {
	header=null;
}

//getSize
	public Integer getSize() {
		UnsortedLinkedListNode<T> currentItem = header;
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
			UnsortedLinkedListNode<T> currentNode = header;
			int currentIndex=1;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex==index && currentNode.getNext()!=null) {
				UnsortedLinkedListNode<T> nextNode = currentNode.getNext();
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
			UnsortedLinkedListNode<T> currentNode = header;
			int currentIndex=1;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex==index && currentNode.getNext()!=null) {
				UnsortedLinkedListNode<T> nextNode = currentNode.getNext();
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
			header = new UnsortedLinkedListNode<T>(value,null);
		} else if (index<=0) {
			header = new UnsortedLinkedListNode<T>(value,header);
		} else {
			UnsortedLinkedListNode<T> currentNode = header;
			currentIndex++;
			while(currentIndex<index && currentNode.getNext()!=null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			UnsortedLinkedListNode<T> insertedNode = new UnsortedLinkedListNode<T>(value,currentNode.getNext());
			currentNode.setNext(insertedNode);
		}
		
		
		return currentIndex;
	}
	
//add
	public int add(T value) {
		
		UnsortedLinkedListNode<T> currentItem = header;
		int index=0;
		
		if(header==null)
		{
			header = new UnsortedLinkedListNode<T>(value, null);
		}
		else
		{
			while ( currentItem.getNext()!=null)
			{
				currentItem = currentItem.getNext();
				index++;
			}
			UnsortedLinkedListNode<T> insertedNode = new UnsortedLinkedListNode<T>(value,currentItem.getNext());
			currentItem.setNext(insertedNode);
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
			UnsortedLinkedListNode<T> current = header;
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
			UnsortedLinkedListNode<T> current = header;
			while(current!=null) {
				rtn+=current.getValue()+", ";
				current = current.getNext();
			}
			return rtn;
		}
	}
	
	
}
