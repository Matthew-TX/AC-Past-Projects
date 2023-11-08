public class Queue<Integer> {
	UnsortedLinkedListNode<Integer> header = null;
		
		
	/**
	 * adds a value to the queue
	 * @param x the value of the element to be added
	 */
		synchronized public void push(Integer x) 
		{
			UnsortedLinkedListNode<Integer> current = header;
			if(header == null) {
				header = new UnsortedLinkedListNode<Integer>(x, null);
			}
			else if (header!=null)
			{
				header = new UnsortedLinkedListNode<Integer>(x, header);
			}
			
		}
				
				
	/**
	 * removes an element from the queue and returns the value of the removed element
	 * @return returns the value of the removed element
	 */
		synchronized public Integer pop() 
		{
			UnsortedLinkedListNode<Integer> current = header;
			Integer popValue = null;
			if(header==null || current == null)
			{
				popValue = null;
			} 
			
			else if (current.getNext()!=null)
			{	
				while (current.getNext()!=null && current.getNext().getNext()!=null )
				{
					current = current.getNext();
				}
				popValue=current.getValue();
				current.setNext(null);
			} 
			
			else if (header!=null)
			{
				header = null;
				popValue=null;
				
			}
			
			return popValue;
		}
		
	/**
	 * returns the top element
	 * @return returns the top element
	 */
		synchronized public Integer top() 
				{
					Integer popValue=null;
					UnsortedLinkedListNode<Integer> current = header;
					if(header == null)
					{
						popValue=null;
					}
					else
					{
						while (current.getNext()!=null)
						{
							current = current.getNext();
						}
						popValue = current.getValue();
					}
					
					return popValue;
				}
	
	/**
	 * lists all elements as a string
	 * @return returns all elements as a string 
	 */
		synchronized public String toString() {
			int index=0;
			String toString = "";
			if(header == null) {
				toString = "null";
			} else {
				UnsortedLinkedListNode<Integer> current = header;
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
		
		synchronized public void clear() 
		{
			header=null;
		}
	
	
	
	}
	
	
	
