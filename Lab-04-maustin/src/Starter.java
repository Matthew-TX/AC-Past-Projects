
public class Starter {
	public static <T> void main(String[] args) {

		
		String type = "Integer";
		
		UnsortedDoubleLinkedList<Integer> dll = new UnsortedDoubleLinkedList<>();
		
		System.out.println(dll.toString());
		
		dll.add(7);
		System.out.println(dll.toString());
		
		dll.add(-73);
		System.out.println(dll.toString());
		
		dll.add(89);
		System.out.println(dll.toString());

		dll.add(2131313);
		System.out.println(dll.toString());	
		
	}

}
