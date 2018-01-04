/**
 * 
 */
package com.fjnu.math.seven;

/**
 * 
 * @param
 * @version
 * @return 
 */
public class Main implements Runnable{

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	/*public static void main(String[] args) throws InterruptedException {
		Mythread test1 = new Mythread("hello");
		Mythread test2 = new Mythread("world");
		test1.start();
		test1.join();
		test2.start();
		test2.join();

	}*/
	/*public static void main(String[] args) throws InterruptedException {
		Mythread test1 = new Mythread("hello");
		Mythread test2 = new Mythread("world");
		Thread t1 = new Thread(test1);
		Thread t2 = new Thread(test2);
		t1.start();
		t2.start();

	}*/

	
	/*public static Thread [] jobs = new Thread[3];
	private int threadID;
	*/
	/**
	 * @param threadID
	 */
	/*public Main(int threadID) {
		this.threadID = threadID;
	}*/
	/* （非 Javadoc）
	 * @see java.lang.Runnable#run()
	 */
	/*@Override
	public void run() {
		// TODO 自动生成的方法存根
			try {
				System.out.println("Thread"+this.threadID+":start");
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println(e);
			}	
			System.out.println("Thread"+this.threadID+":End");
		
	}
	public static void  main(String [] args) throws InterruptedException {
		for(int i=0;i<jobs.length;i++) {
			jobs[i] = new Thread(new Main(i));
			jobs[i].start();
			//jobs[i].join();
		}
	}*/
	private int num = 10;

	/* （非 Javadoc）
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true) {
				synchronized(this) {
					if(num>0) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						System.out.println("tickets:"+--num);
					}
				}
		}
		
	}
	public static void main(String [] args) {
		Main  test = new Main();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		Thread t3 = new Thread(test);
		Thread t4 = new Thread(test);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	

}
