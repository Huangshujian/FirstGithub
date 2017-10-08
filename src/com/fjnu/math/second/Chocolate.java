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
			System.out.println("�������¯������ɿ�����ţ�̻����");
			empty = false;
		}
		else {
			System.out.println("��¯��������װʧ��");
		}
	}
	
	public void boil() {
		if(!empty && !boiled) {
			System.out.println("���ڽ���¯���");
			boiled = true;
		}
	}
	
	public void drain() {
		if(!empty && boiled) {
			System.out.println("�����ų���е��ɿ�����ţ�̻����");
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
