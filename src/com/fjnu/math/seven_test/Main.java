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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		System.out.println("�ܺ�Ϊ��"+Mythread.SumAll);
	}

}
