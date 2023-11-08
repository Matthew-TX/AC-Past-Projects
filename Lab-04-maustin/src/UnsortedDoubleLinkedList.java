import java.util.ArrayList;
import java.util.Iterator;



public class UnsortedDoubleLinkedList<T> extends OrderedDataStructure<T> {
private UnsortedDoubleLinkedListNode<T> header;

/**
 *  creates an empty list
 */
UnsortedDoubleLinkedList()
{
	this.header = null;
}


/**
 * Adds values from an array to this data structure
 * @param values the array of values that will be added to this data structure
 */
UnsortedDoubleLinkedList(ArrayList<T> values)
{
	for(T value: values)
	{
		this.add(value);
	}
	
}
	

/**
 * Node to be used for this data structure
 */
	@SuppressWarnings("hiding")
	private class UnsortedDoubleLinkedListNode<T> {
		private T value;
		private UnsortedDoubleLinkedListNode<T> next;
		private UnsortedDoubleLinkedListNode<T> back;
		
		/**
		 * Creates a Node
		 * @param value the value of this node
		 * @param next the node after this node
		 * @param back the previoius node to current
		 */
		public UnsortedDoubleLinkedListNode(T value, UnsortedDoubleLinkedListNode<T> next, UnsortedDoubleLinkedListNode<T> back ) {
			this.value = value;
			this.next = next;
			this.back = back;
		}
		
		
		/**
		 * returns the previous node in the structure or null if there is no next
		 * @return returns the previous node in the structure or null
		 */
		@SuppressWarnings("unused")
		public UnsortedDoubleLinkedListNode<T> getPrevious() {
			return back;
		}

		/**
		 * sets the previous node in the structure 
		 * @return sets the previous node in the structure 
		 */
		public void setPrevious(UnsortedDoubleLinkedListNode<T> back) {
			this.back = back;
		}

		/**
		 * gets the value of the current node
		 * @return returns the value of the current node
		 */
		public T getValue() {
			return value;
		}

		/**
		 * sets the value of the current node
		 * @return sets the value of the current node
		 */
		@SuppressWarnings("unused")
		public void setValue(T value) {
			this.value = value;
		}

		/**
		 * gets the next node
		 * @return returns the next node
		 */
		public UnsortedDoubleLinkedListNode<T> getNext() {
			return next;
		}

		/**
		 * sets the next node
		 */
		public void setNext(UnsortedDoubleLinkedListNode<T> next) {
			this.next = next;
		}
		

	}

	
	/**
	 * returns the current size of the structure
	 * @return returns the size of the structure or 0 if the list is empty
	 */
	public int getSize() {
		UnsortedDoubleLinkedListNode<T> currentItem = header;
		int size = 0;
		if(currentItem==null)
		{
			size=0;
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
	
	
	/**
	 * returns the value at the given index
	 * @param index decides which node's value will be returned
	 */
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

	
	/**
	 * removes a node from the list and fixes the list
	 * @param index used to decide which node will be removed
	 * @return returns the deleted node's value
	 * @throws Exception throws an exception if the index is less than 0 or the header is null
	 */
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
	
	
	/**
	 * inserts a node at a point
	 * @param value value of the node to be inserted
	 * @param index where the node should be inserted
	 * @return returns the inserted node
	 */
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
	
	/**
	 * adds a node to the list
	 * @ param value adds a node of T type to the list
	 */
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
	
	

////toString
//	public String toString() {
//		int index=0;
//		String toString = "";
//		if(header == null) {
//			toString = "List is empty";
//		} else {
//			UnsortedDoubleLinkedListNode<T> current = header;
//			index++;
//			for(int i=0; i<index; i++) {
//				if(current!=null)
//				{
//					toString+=current.getValue()+", ";
//					current = current.getNext();
//					index++;
//				}
//			}
//		}
//
//		return toString;
//	}
//		
////toStringRecursion
//	public String toStringRecursion() {
//		if(header == null) {
//			return "List is empty";
//		} else {
//			String rtn  = "";
//			UnsortedDoubleLinkedListNode<T> current = header;
//			while(current!=null) {
//				rtn+=current.getValue()+", ";
//				current = current.getNext();
//			}
//			return rtn;
//		}
//	}

	/**
	 * prints the list as a string
	 */
public String toString()
{
	String returnString="";
	for(T value: this)
	{
		returnString += value + ",";
	}
	return returnString;
}
	
/**
 * creates a new array list with values from this data structure
 */
public ArrayList<T> toArrayList()
{
	ArrayList<T> newArrayList = new ArrayList<>();
	
	for(T value: this)
	{
		newArrayList.add(value);
	}
	return newArrayList;
}

/**
 * returns the list one element at a time
 */
public Iterator<T> iterator() 
{
		Iterator<T> rtnIter = new Iterator<T>() 
		{
			private UnsortedDoubleLinkedListNode<T> current = header;
			
			/**
			 * returns true or false depending on if the current node is empty
			 */
			public boolean hasNext() 
			{
				if (current!= null) 
				{
					return true;	
				}
				else 
				{
					return false;	
				}
			}
			
			/**
			 * gets the next node and returns the current node's value
			 */
			public T next() {
				UnsortedDoubleLinkedListNode<T> currentvalue = current;
				current = current.getNext();
				return currentvalue.getValue();
			}
		};
		return rtnIter;
	}
	
}
