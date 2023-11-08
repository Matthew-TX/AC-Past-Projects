import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortedTest {

	@Test
	void getSizeTest() throws Exception
	{
		SortedLinkedList<Integer> sorted = new SortedLinkedList<>();
		assertNull(sorted.getSize(), "empty list");
		
		sorted.add(1);
		sorted.add(-564);
		sorted.add(1);
		sorted.add(0);
		sorted.add(1);
		sorted.add(15461);
		
		assertEquals(4, sorted.getSize());
	}
	
	
	@Test
	void addTest() throws Exception 
	{
		SortedLinkedList<Integer> sorted = new SortedLinkedList<>();
		
		try { sorted.get(-23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("-23 is out of bounds");
		}
		
		Integer actual = -7105 ;
		Integer expected = -7105;
		sorted.add(actual);
		assertEquals(expected, sorted.get(0));
		
		actual = 0;
		expected = actual;
		sorted.add(actual);
		assertEquals(expected, sorted.get(1));
		
		actual = 48791;
		expected = actual;
		sorted.add(actual);
		assertEquals(expected, sorted.get(2));
		
		try { sorted.get(23); }
		catch(OutOfBoundsException e)
		{
			System.err.println("23 is out of bounds");
		}
		
	}
	
	
	
	@Test
	void getValue()
	{
		SortedLinkedList<Integer> sorted = new SortedLinkedList<>();	
		sorted.add(1);
		sorted.add(-564);
		sorted.add(1);
		sorted.add(0);
		sorted.add(1);
		sorted.add(15641);
		
		assertNull(sorted.getValue(3));
		
		assertEquals(sorted.getValue(65),65);

}
}