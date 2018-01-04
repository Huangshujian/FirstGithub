package com.fjnu.math.seven_third;

public class PizzaStore extends Thread{  			//接收披萨订单生产披萨
	
	SimplePizzaFactory Factory;
	String pizzaType ;
	/**  
	 * 披萨商店接收订单函数
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
	 * 构造函数：初始化披萨商店	
	 * @param Factory
	 */
	public PizzaStore(SimplePizzaFactory Factory,String type){
		this.Factory=Factory;
		this.pizzaType = type;
	}
 
}
/*Public Pizza orderPizza(String type)根据披萨类型type完成披萨制作，
 * 并返回一个Pizza实例(实际上要返回一个其子类实例)。制作过程包括（pizza.prepare(); 
 * pizza.bake(); pizza.cut(); pizza.box()）*/
