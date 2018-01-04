package com.fjnu.math.seven_third;

public class Main {
	public static void main(String[] args){
		
		String [] pizzaName = new String [] {"cheersePizza","pepperoniPizza","clamPizza"};
		Thread [] PizzaThread = new Thread[3]; 
		
        SimplePizzaFactory Factory=new SimplePizzaFactory();
        
        for(int i=0;i<3;i++) {
        	PizzaThread[i] = new Thread(new PizzaStore(Factory,pizzaName[i]));
        	PizzaThread[i].start();
        	try {
        		PizzaThread[i].join();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }
		//输入可为：cheersePizza、pepperoniPizza、clamPizza;三种类别
	}  
}
