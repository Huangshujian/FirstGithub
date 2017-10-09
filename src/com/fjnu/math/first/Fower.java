package com.fjnu.math.first;

public class Fower {
	public static void main(String [] args) {
		int a,b,c;
		for(int i=100;i<=999;i++) {
			a=i/100;
			b=(i/10)%10;
			c=(i%100)%10;
			if(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)==i)
				System.out.print(i+" ");
		}		
	}
}
