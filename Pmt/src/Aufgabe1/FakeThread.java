package Aufgabe1;


public class FakeThread implements Runnable {
String string;
int i;
	public FakeThread(String string, int i) {
		this.string=string;
		this.i=i;
	}
	public FakeThread(String string) {
		this(string,0);
	}

	@Override
	public void run() {
	char[] c = string.toCharArray();
		
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
	}

	}

