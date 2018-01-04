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
public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		int [] Id = new int []{1,26,51,76}; 
		for(int i=0;i<Id.length;i++) {
			Mythread my = new Mythread(Id[i]);
			my.start();
			try {
				my.join();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		System.out.println("总和为："+Mythread.SumAll);
	}

}
