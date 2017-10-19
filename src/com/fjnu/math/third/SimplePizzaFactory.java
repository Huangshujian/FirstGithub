package com.fjnu.math.third;

public class SimplePizzaFactory {
	public Pizza createPizza(String taste){//披萨工厂生产披萨
		if(taste==null){ 
			System.out.println("输入错误，无法生产");
			return null;
		} 
		else if(taste.equalsIgnoreCase("cheerse")){
			System.out.println("生产cheerse披萨");
			return new CheesePizza();
		}
		else if(taste.equalsIgnoreCase("pepperoni")){
			System.out.println("生产pepperoni披萨");
			return new PepperoniPizza();
		}
		else if(taste.equalsIgnoreCase("clam")){
			System.out.println("生产clam披萨");
			return new ClamPizza();
		}
		return null;		
	}	
}
