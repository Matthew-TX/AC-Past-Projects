

public class QueueThread extends Thread{
	
	static Integer maxsize=5;
	static Integer currentsize=0;
	static Integer sleepTime=0;
	static Integer producerWaitUser;
	static Integer consumerWaitUser;
	static Queue<Integer> q = new Queue<>();
	
	public Integer x;
	
	
	public synchronized void push(Integer x)
	{
		if(currentsize<maxsize)
		{
			currentsize++;
			q.push(x);
			
			try {
				Thread.sleep(producerWaitUser);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			
		}
	}
	
	public synchronized void pop()
	{
		if(currentsize==0)
		{
			System.out.println("null");
		}
		else if (currentsize>0)
		{
			currentsize--;
			q.pop();
		}
		
		try {
			Thread.sleep(consumerWaitUser);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized static void clear()
	{
		q.clear();
	}
	
	public  synchronized static String toString(int i)
	{
		return q.toString();

	}
	
	public void run() {
		
	}
	
	


	
		

}
