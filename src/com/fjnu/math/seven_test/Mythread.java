/**
 * 
 */
package com.fjnu.math.seven_test;

/**
 *  
 * @param
 * @version
 * @return 
 */
public class Mythread extends Thread{ 
	public static int SumAll=0;
	private int StartId;
	
	public void run() {
		try {
			Sum();
			sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
	}
	private void Sum() {
		int sum=0;
		for(int i=StartId;i<(StartId+25);i++) {
			sum = sum + i;
		}
		SumAll = SumAll+sum;
		System.out.println(StartId+"~"+(StartId+24)+"µÄºÍÎª£º"+sum);
	}
	/**
	 * @param startId
	 */
	public Mythread(int startId) {
		this.StartId = startId;
	}
	

}
