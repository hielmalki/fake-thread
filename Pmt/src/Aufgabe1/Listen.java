package Aufgabe1;

import java.util.*;

public class Listen {


	List <String> iststringsource;
	List <String> istthreadqueue; 
	boolean blnfinished=false; 
	
	public Listen(boolean blnfinished) {
	
		iststringsource = new LinkedList<>();
		istthreadqueue = new LinkedList<>();
		
		iststringsource.add("Haloo");
		iststringsource.add("hey you");
		iststringsource.add("window");
		iststringsource.add("door");
		iststringsource.add("night");
		iststringsource.add("light");		
		iststringsource.add("hallo World");
		iststringsource.add("come back");
		iststringsource.add("hey!");
		this.blnfinished=blnfinished;
		
		blnfinished=false; 
		
	}
	public void testthreadinfotransmission () {
		
		
		Thread threadpush= new Thread (new Runnable() {
			
			@Override
			public void run() {
				String temp;
				for(int i=0;i<iststringsource.size();i++) {
	          	temp=iststringsource.get(i);
					
	
				
				try {
					Thread.sleep(50);
					System.out.println("weitergeben von String"+temp);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (istthreadqueue) {
					
					istthreadqueue.add(temp);
			}
			}
			}
			boolean blnfinished=true;
		});
		
		
		Thread threadpull= new Thread ( new Runnable() {

			@Override
			public void run() {
						while (blnfinished==false) {
			synchronized (istthreadqueue) {
				String temp=istthreadqueue.get(0);
				System.out.println("String empfangen"+temp);
				istthreadqueue.remove(temp);
				
			}
		}
			}
			
		});
	}
	
	
	public static void main(String [] args) {
	
		Listen t1= new Listen (true);
		//Listen t2 = new Listen(false);
	t1.testthreadinfotransmission();
	
	
	}
	
}
