import java.util.ArrayList;

public abstract class OrderedDataStructure<T> implements Iterable<T> {
	
	

	@SuppressWarnings("unused")
	private Object header;

	abstract T get(int index) throws Exception;
	abstract int add(T value);
	
	OrderedDataStructure()
	{
		this.header = null;
	}
	
	
	
	OrderedDataStructure(ArrayList<T> values)
	{
		for(T value: values)
		{
			this.add(value);
		}
		
	}

	public int getSize()
	{
		int size = this.getSize();
		return size;
	}
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> newArrayList = new ArrayList<>();
		
		for(T value: this)
		{
			newArrayList.add(value);
		}
		return newArrayList;
	}
	
	public String toString()
	{
		String returnString="";
		for(T value: this)
		{
			returnString += value + ",";
		}
		return returnString;
	}
	
}
