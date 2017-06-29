package Aufgabe1;


public class Threads {

	public static final Object object= new Object();
	
	public static void main(String [] args) {
		Threads thread1=new Threads ();
		thread1.runThreads1();
		thread1.runThreads2();
		thread1.runThreads3();
	}
	
	public void runThreads1 () {
		Thread t1 = new Thread(new FakeThread("Hello World",0) );
		Thread t2=new Thread (new FakeThread("  HSRM rules ",100));
		Thread t3= new Thread(new FakeThread("What am i doing",200));
		
		try {
			t1.start();
			t2.start();
			t3.start(); 
			t1.join();
			t2.join();
			t3.join();
		}
	catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	}
		public void runThreads2 () {
			Thread t1 = new Thread(new FakeThread(" Hello World",500) );
			Thread t2=new Thread (new FakeThread(" HSRM rules ",1));
			Thread t3= new Thread(new FakeThread("What am i doing",700));
			
			try {
				t1.start();
				t2.start();
				t3.start(); 
				t1.join();
				t2.join();
				t3.join();
			}
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}	
		public void runThreads3 () {
		
			Thread t1 = new Thread (new Runnable() {
			
				

				@Override
				public void run() {
					synchronized (object) {
						char []cha="Hello World".toCharArray();
						for (int i=0; i<cha.length;i++) {
							System.out.println(cha[i]);
						}
					}
				
					
				}
				
			});
			
			Thread t2=new Thread(new Runnable() {

				@Override
				public void run() {
				synchronized (object) {
					char [] cha="HSRM rules".toCharArray();
					for (int i=0; i<cha.length;i++) {
						System.out.println(cha[i]);
					}
				}
					
				}
				
			});
			
			Thread t3=new Thread (new Runnable() {

				@Override
				public void run() {
				synchronized (object) {
					char [] cha="what am i doing".toCharArray();
					for (int i=0; i<cha.length;i++) {
						System.out.println(cha[i]);
					}
				}
					
				}
				
			});
			
		}
		
		
		
		
	
}
