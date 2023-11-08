
public class SortedLinkedList<T extends Comparable<T>> {
	private UnsortedLinkedListNode<T> header;
	
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
		
		
	
//add
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
	
//getValue
		public Integer getValue(Integer search)
		{
			UnsortedLinkedListNode<T> current = header;
			if(header==null)
			{
				search = null;
			}
			else if(current.getValue() != search)
			{
				while(current.getValue() != search && current.getNext()!=null)
				{
					current = current.getNext();
				}
				
				if(current.getValue()!=search)
				{
					return null;
				}
				else if (current.getValue()==search)
				{
					return search;
				}
			}
			
			
			return search;
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
