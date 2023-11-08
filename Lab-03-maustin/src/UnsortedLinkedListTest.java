import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnsortedLinkedListTest {

	@Test
	void addTest() throws Exception 
	{
		UnsortedLinkedList<Integer> ull = new UnsortedLinkedList<>();
		
		try { ull.get(-23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("-23 is out of bounds");
		}
		
		Integer actual = -7105 ;
		Integer expected = -7105;
		ull.add(actual);
		assertEquals(expected, ull.get(0));
		
		actual = 0;
		expected = actual;
		ull.add(actual);
		assertEquals(expected, ull.get(1));
		
		actual = 48791;
		expected = actual;
		ull.add(actual);
		assertEquals(expected, ull.get(2));
		
		try { ull.get(23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("23 is out of bounds");
		}
		
	}
	
	@Test
	void insertTest() throws Exception 
	{
		UnsortedLinkedList<Integer> ull = new UnsortedLinkedList<>();
		
		try { ull.get(-23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("-23 is out of bounds");
		}
		
		Integer actual = -7105 ;
		Integer expected = -7105;
		ull.insert(actual,0);
		assertEquals(expected, ull.get(0));
		
		actual = 0;
		expected = actual;
		ull.insert(actual,1);
		assertEquals(expected, ull.get(1));
		
		actual = 48791;
		expected = actual;
		ull.insert(actual,2);
		assertEquals(expected, ull.get(2));
		
		try { ull.get(23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("23 is out of bounds");
		}
		
	}
	
	@Test
	void getSizeTest() throws Exception
	{
		UnsortedLinkedList<Integer> ull = new UnsortedLinkedList<>();
		assertNull(ull.getSize(), "empty list");
		
		ull.add(1);
		ull.add(-564);
		ull.add(1);
		ull.add(0);
		ull.add(1);
		ull.add(15461);
		
		assertEquals(6, ull.getSize());
	}
	
	@Test
	void removeTest() throws Exception
	{
		UnsortedLinkedList<Integer> ull = new UnsortedLinkedList<>();
		try {
			ull.remove(0);
		}
		catch ( OutOfBoundsException e)
		{
			System.err.println("Out of Bounds");
		}
		
		try {
			ull.remove(-11);
		}
		catch ( OutOfBoundsException e)
		{
			System.err.println("Out of Bounds");
		}
		
		try {
			ull.remove(34);
		}
		catch ( OutOfBoundsException e)
		{
			System.err.println("Out of Bounds");
		}
		
		ull.add(1);
		ull.add(-564);
		ull.add(1);
		ull.add(0);
		ull.add(1);
		ull.add(15461);
		
		ull.remove(0);
		
		assertEquals(-564,ull.get(0));
		
		ull.remove(2);
		
		assertEquals(1,ull.get(2));
		
		ull.remove(3);
		
		assertEquals(1,ull.get(2));
		
		
		
		
	}
	
	
}
