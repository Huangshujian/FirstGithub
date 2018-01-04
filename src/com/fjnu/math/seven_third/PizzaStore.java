package com.fjnu.math.seven_third;

public class PizzaStore extends Thread{  			//��������������������
	
	SimplePizzaFactory Factory;
	String pizzaType ;
	/**  
	 * �����̵���ն�������
	 * @param taste
	 * @return
	 */
	public Pizza orderPizza(String taste) {
		Pizza pizza=null;
		if(taste.equalsIgnoreCase("cheersePizza")) {
			 pizza = Factory.createPizza("cheerse");
		}
		else if(taste.equalsIgnoreCase("pepperoniPizza")) {
			 pizza= Factory.createPizza("pepperoni");
		}
		else if(taste.equalsIgnoreCase("clamPizza")) {
			 pizza= Factory.createPizza("clam");
		}
		if(pizza==null){
			return null;
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;		
	}	
	public void run() {
		try {
			 orderPizza(pizzaType);
				sleep(1000);	
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
	}
	/**
	 * ���캯������ʼ�������̵�	
	 * @param Factory
	 */
	public PizzaStore(SimplePizzaFactory Factory,String type){
		this.Factory=Factory;
		this.pizzaType = type;
	}
 
}
/*Public Pizza orderPizza(String type)������������type�������������
 * ������һ��Pizzaʵ��(ʵ����Ҫ����һ��������ʵ��)���������̰�����pizza.prepare(); 
 * pizza.bake(); pizza.cut(); pizza.box()��*/
