package com.fjnu.math.third;

public class Main {
	public static void main(String[] args){		
        SimplePizzaFactory Factory=new SimplePizzaFactory();
		PizzaStore Store=new PizzaStore(Factory);
		Store.orderPizza("cheersePizza");
		//�����Ϊ��cheersePizza��pepperoniPizza��clamPizza;�������
	} 
}
