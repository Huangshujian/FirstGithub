/**
 * 
 */
package com.fjnu.math.seven;

/**
 * 
 * @param 1继承Thread类 2实现Runnable接口
 * @version
 * @return 
 */
/*
public class Mythread extends Thread{ 
	private String toSay;
	public Mythread(String st) {
		this.toSay = st;
	}
	public void run() {
		try {
			for(int i=1;i<10;i++) {
				System.out.println(toSay);
				sleep(1000);
				
			}
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
	}

}*/
public class Mythread implements Runnable{
	private String toSay;
	
	/**
	 * @param toSay
	 */
	public Mythread(String toSay) {

		this.toSay = toSay;
	}

	/* （非 Javadoc）
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		try {
			for(int i=1;i<10;i++) {
				System.out.println(toSay);
				Thread.sleep(1000);
				
			}
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
		
	}
	
}
