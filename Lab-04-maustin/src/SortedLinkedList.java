import java.util.ArrayList;
import java.util.Iterator;

public class SortedLinkedList<T extends Comparable<T>> implements Iterable <T>{
	private UnsortedLinkedListNode<T> header;
	
	/**
	 *  creates an empty list
	 */
SortedLinkedList()
{
	this.header = null;
}


/**
 * Adds values from an array to this data structure
 * @param values the array of values that will be added to this data structure
 */
SortedLinkedList(ArrayList<T> values)
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
	private class UnsortedLinkedListNode<T> {
		private T value;
		private UnsortedLinkedListNode<T> next;
		/**
		 * Creates a Node
		 * @param value the value of this node
		 * @param next the node after this node
		 */
		public UnsortedLinkedListNode(T value, UnsortedLinkedListNode<T> next) {
			this.value = value;
			this.next = next;
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
		public UnsortedLinkedListNode<T> getNext() {
			return next;
		}

		/**
		 * sets the next node
		 */
		public void setNext(UnsortedLinkedListNode<T> next) {
			this.next = next;
		}
		
	}
	
	/**
	 * returns the current size of the structure
	 * @return returns the size of the structure or 0 if the list is empty
	 */
	public Integer getSize() {
		UnsortedLinkedListNode<T> currentItem = header;
		Integer size = 0;
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
		
		
	
	/**
	 * adds a node to the list
	 * @ param value adds a node of T type to the list
	 */
public int add(T value) {
	
	UnsortedLinkedListNode<T> current = header;
	int index=0;
	
	if(header==null)
	{
		header = new UnsortedLinkedListNode<T>(value, null);
		index = 0;
	}
	else 
	{

		int comparisonValue=value.compareTo(header.getValue());
		if (comparisonValue==-1)
		{
			header = new UnsortedLinkedListNode<T>(value,header);
		}
		else if (comparisonValue==1)
		{
			while ( comparisonValue==1 && current.getNext()!=null )
			{	
				index++;
				comparisonValue=value.compareTo(current.getNext().getValue());
				if(comparisonValue==1)
				{
					current = current.getNext();
				}
				
			}
			if(comparisonValue==-1)
			{
				UnsortedLinkedListNode<T> added = new UnsortedLinkedListNode<T>(value, current.getNext());
				current.setNext(added);
			
			}
			else if (comparisonValue == 1)
			{
				UnsortedLinkedListNode<T> added = new UnsortedLinkedListNode<T>(value, current.getNext());
				current.setNext(added);
				
			}
			
			
		}
		else
		{
			index = 0;
		}
	}
	
	
return index;
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
	
	/**
	 * gets the value of the current node
	 * @return returns the value of the current node
	 */
		public T getValue(T value)
		{
			UnsortedLinkedListNode<T> current = header;
			if(current.getValue()!=value && current.getNext()!=null)
			{
				current = current.getNext();
				
			}
			else if (current.getValue() == value)
			{
				value = current.getValue();
			}
			else 
			{
				value = null;
			}
			
			return value;
		}
	
////toString
//	public String toString() {
//		int index=0;
//		String toString = "";
//		if(header == null) {
//			toString = "List is empty";
//		} else {
//			UnsortedLinkedListNode<T> current = header;
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
//			UnsortedLinkedListNode<T> current = header;
//			while(current!=null) {
//				rtn+=current.getValue()+", ";
//				current = current.getNext();
//			}
//			return rtn;
//		}
//	}
		
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
		 * returns the list one element at a time
		 */
@Override
public Iterator<T> iterator() {
			Iterator<T> rtnIter = new Iterator<T>() {
		private UnsortedLinkedListNode<T> current = header;
		
		/**
		 * returns true or false depending on if the current node is empty
		 */
		@Override
		public boolean hasNext() {
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
		@Override
		public T next() {
			UnsortedLinkedListNode<T> currentvalue = current;
			current = current.getNext();
			return currentvalue.getValue();
		}
		
	};
	// TODO Auto-generated method stub
	return rtnIter;
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




		
		
		
}
