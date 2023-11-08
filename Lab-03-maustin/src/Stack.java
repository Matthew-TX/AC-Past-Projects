public class Stack<T> {
UnsortedLinkedListNode<T> header = null;

//Constructor
	public Stack() {
	header=null;
}

//push
	public void push(T value) 
	{
		UnsortedLinkedListNode<T> current = header;
		if(header == null) {
			header = new UnsortedLinkedListNode<T>(value, null);
		}

		else
			
		{
			while (current.getNext()!=null)
			{
				current = current.getNext();
			}
			UnsortedLinkedListNode<T> pushed = new UnsortedLinkedListNode<T>(value, null);
			current.setNext(pushed);
		}
	}
	
	
	//pop
			public T pop() 
			{
				UnsortedLinkedListNode<T> current = header;
				T popValue = null;
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
		
//top
				public T top() 
				{
					T popValue=null;
					UnsortedLinkedListNode<T> current = header;
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



}
