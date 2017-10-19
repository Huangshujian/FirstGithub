package com.fjnu.math.third;

public class PizzaStore {  			//��������������������
	
	SimplePizzaFactory Factory;
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
	/**
	 * ���캯������ʼ�������̵�	
	 * @param Factory
	 */
	public PizzaStore(SimplePizzaFactory Factory){
		this.Factory=Factory;
	}
 
}
/*Public Pizza orderPizza(String type)������������type�������������
 * ������һ��Pizzaʵ��(ʵ����Ҫ����һ��������ʵ��)���������̰�����pizza.prepare(); 
 * pizza.bake(); pizza.cut(); pizza.box()��*/
