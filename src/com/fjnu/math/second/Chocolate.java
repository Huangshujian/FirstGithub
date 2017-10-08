package com.fjnu.math.second;



public class Chocolate {
	private static Chocolate onlyChocolate;
	private boolean empty;
	private boolean boiled;
	private Chocolate() {
		empty = true;
		boiled =false;
	}
	public static Chocolate getChocolate() {
		if(onlyChocolate == null) {
			onlyChocolate = new Chocolate();
		}
		return onlyChocolate;
	}
	
	public void fill() {
		if(empty) {
			System.out.println("正在向锅炉中添加巧克力和牛奶混合物");
			empty = false;
		}
		else {
			System.out.println("锅炉已满，填装失败");
		}
	}
	
	public void boil() {
		if(!empty && !boiled) {
			System.out.println("正在将锅炉煮沸");
			boiled = true;
		}
	}
	
	public void drain() {
		if(!empty && boiled) {
			System.out.println("正在排出煮沸的巧克力和牛奶混合物");
			boiled = false;
			empty = true;
		}
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return empty;
	}
	
	public boolean isBoiled() {
		// TODO Auto-generated method stub
		return boiled;
	}
}
