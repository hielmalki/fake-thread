package Aufgabe1;

public class Interput {

	
	public static void main (String [] args) {
	testinterupt();
	}
	public static void testinterupt () {
		 
		
		Thread th = new Thread (new Runnable()
		
		{
	
		
          
       

			@Override
			public void run()  {
			
		
	try {
	Thread.sleep(200000);
	
	}
		catch (InterruptedException e) {
			
			System.out.println("InterruptedException reached");
		}
			}
			
		});
		
		th.start();
	try {
		
		th.sleep(10);
		
	}
		
		catch (InterruptedException e) {
			
		}
	th.interrupt();
		
		
	}
}
