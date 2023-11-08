import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnsortedDoubleLinkedListTest {


	@Test
	void addTest() throws Exception 
	{
		UnsortedDoubleLinkedList<Integer> dull = new UnsortedDoubleLinkedList<>();
		
		try { dull.get(-23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("-23 is out of bounds");
		}
		
		Integer actual = -7105 ;
		Integer expected = -7105;
		dull.add(actual);
		assertEquals(expected, dull.get(0));
		
		actual = 0;
		expected = actual;
		dull.add(actual);
		assertEquals(expected, dull.get(1));
		
		actual = 48791;
		expected = actual;
		dull.add(actual);
		assertEquals(expected, dull.get(2));
		
		try { dull.get(23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("23 is out of bounds");
		}
		
	}
	
	@Test
	void insertTest() throws Exception 
	{
		UnsortedDoubleLinkedList<Integer> dull = new UnsortedDoubleLinkedList<>();
		
		try { dull.get(-23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("-23 is out of bounds");
		}
		
		Integer actual = -7105 ;
		Integer expected = -7105;
		dull.insert(actual,0);
		assertEquals(expected, dull.get(0));
		
		actual = 0;
		expected = actual;
		dull.insert(actual,1);
		assertEquals(expected, dull.get(1));
		
		actual = 48791;
		expected = actual;
		dull.insert(actual,2);
		assertEquals(expected, dull.get(2));
		
		try { dull.get(23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("23 is out of bounds");
		}
		
	}
	
	@SuppressWarnings("unused")
	@Test
	void getSizeTest() throws Exception
	{
		UnsortedDoubleLinkedList<Integer> dull = new UnsortedDoubleLinkedList<>();
		assertNull(dull.getSize(), "empty list");
		
		dull.add(1);
		dull.add(-564);
		dull.add(1);
		dull.add(0);
		dull.add(1);
		dull.add(15461);
		
		assertEquals(6, dull.getSize());
	}
	
	@Test
	void removeTest() throws Exception
	{
		UnsortedDoubleLinkedList<Integer> dull = new UnsortedDoubleLinkedList<>();
		try {
			dull.remove(0);
		}
		catch ( OutOfBoundsException e)
		{
			System.err.println("Out of Bounds");
		}
		
		try {
			dull.remove(-11);
		}
		catch ( OutOfBoundsException e)
		{
			System.err.println("Out of Bounds");
		}
		
		try {
			dull.remove(34);
		}
		catch ( OutOfBoundsException e)
		{
			System.err.println("Out of Bounds");
		}
		
		dull.add(1);
		dull.add(-564);
		dull.add(1);
		dull.add(0);
		dull.add(1);
		dull.add(15461);
		
		dull.remove(0);
		
		assertEquals(-564,dull.get(0));
		
		dull.remove(2);
		
		assertEquals(1,dull.get(2));
		
		dull.remove(3);
		
		assertEquals(1,dull.get(2));
		
		
		
		
	}
	
}
