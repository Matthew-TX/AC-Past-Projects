import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Boolean againBoolean=false;
		int randomPush = (int)(Math.random()*100);
		
		do {
		//Producer Wait
		System.out.println("How many miliseconds would you like the producers to wait for?");
		QueueThread.producerWaitUser = scan.nextInt();
		scan.nextLine();
		
		//Consumer Wait
		System.out.println("How many miliseconds would you like the consumers to wait for?");
		QueueThread.consumerWaitUser = scan.nextInt();
		scan.nextLine();
		
		//Get maxSize
		System.out.println("How long would you like the queue to be?");
		Integer maxSizeUser= scan.nextInt();
		scan.nextLine();
		QueueThread.maxsize=maxSizeUser;
		
		//Get producer thread number
		System.out.println("How many producer threads should there be?");
		Integer producersUser = scan.nextInt();
		scan.nextLine();
	
		//Get consumer thread number
		System.out.println("How many consumer threads would you like?");
		Integer consumerUser = scan.nextInt();
		scan.nextLine();
		
		// Producer Threads
		QueueThread[] producerArray = new QueueThread [producersUser];	

		QueueThread producer = new QueueThread();
		
		for(int i=0; i<producerArray.length; i++)
		{
			producerArray[i] = producer;
			producerArray[i].push(randomPush);
		}
		
		// Consumer Threads
		QueueThread[] consumerArray = new QueueThread [consumerUser];	
		QueueThread consumer = new QueueThread();
		
		for(int i=0; i<consumerArray.length; i++)
		{
			consumerArray[i] = consumer;
			consumerArray[i].pop();
		}
		

		System.out.println("Your queue is " + QueueThread.toString(1));
		System.out.println("The size of your queue is " + QueueThread.maxsize);
		System.out.println("Would you like to make another queue? (y/n)");
		System.out.println("");
		
		String againString = scan.nextLine();
		
		if(againString.equalsIgnoreCase("y")) {
			QueueThread.currentsize=0;
			againBoolean=true;
			QueueThread.clear();
			
		}
		else
		{
			againBoolean=false;
			
		}
		
		
		} while(againBoolean);
	
		System.out.println("End");
		
		
		
		
	}

}
