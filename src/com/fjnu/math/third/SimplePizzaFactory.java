package com.fjnu.math.third;

public class SimplePizzaFactory {
	public Pizza createPizza(String taste){//����������������
		if(taste==null){ 
			System.out.println("��������޷�����");
			return null;
		} 
		else if(taste.equalsIgnoreCase("cheerse")){
			System.out.println("����cheerse����");
			return new CheesePizza();
		}
		else if(taste.equalsIgnoreCase("pepperoni")){
			System.out.println("����pepperoni����");
			return new PepperoniPizza();
		}
		else if(taste.equalsIgnoreCase("clam")){
			System.out.println("����clam����");
			return new ClamPizza();
		}
		return null;		
	}	
}
