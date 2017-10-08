package com.fjnu.math.second;


public class Main {
	public static void main(String[] args) {
		
		Chocolate a =Chocolate.getChocolate();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.fill();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.boil();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.drain();
		System.out.println(a.isEmpty()+","+a.isBoiled());
	}
}
