import java.util.Scanner;

public class Queue<T> {
	UnsortedLinkedListNode<T> header = null;
	int maxSize;
	int currentSize;
		
	//Constructor
		public Queue(int size) throws Exception
		{
			header=null;
			this.maxSize = size;
			this.currentSize = 0;
			while (maxSize<=0)
				{
					Scanner scan = new Scanner(System.in);
					System.out.println("You cannot have a queue less than or equal to 0, please enter a bigger size than 0. ");
					int newSize = scan.nextInt();
					scan.nextLine();
					this.maxSize = newSize;
					if (maxSize> 0)
					{
						scan.close();
					}
				}
			
		}
		
	//push
		public void push(T value) throws Exception
		{
			UnsortedLinkedListNode<T> current = header;
			currentSize++;
			if(header == null) {
				header = new UnsortedLinkedListNode<T>(value, null);
			}
			
			else if(maxSize>1 && currentSize<=maxSize)
			{
				while (current.getNext()!=null)
				{
					current = current.getNext();
				}
				UnsortedLinkedListNode<T> pushed = new UnsortedLinkedListNode<T>(value, null);
				current.setNext(pushed);
			}
			
			else if (currentSize>maxSize)
			{
				currentSize--;
				while ( current.getNext()!=null && (current.getNext().getNext()!=null ))
				{
					current = current.getNext();
				}
				header = new UnsortedLinkedListNode<T>(value, header);
				current.setNext(null);
				
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
				currentSize--;
				while (current.getNext()!=null && current.getNext().getNext()!=null )
				{
					current = current.getNext();
				}
				popValue=current.getValue();
				current.setNext(null);
			} 
			
			else if (header!=null)
			{
				currentSize--;
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
	
	
	
