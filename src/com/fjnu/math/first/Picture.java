package com.fjnu.math.first;

public class Picture {
	public static void main(String [] args) {
		int num=7,k,z=0;
		char flag='*';
		for(int i=1;i<=num;i++) {
			if(i>(num+1)/2) {    //�ж�ÿһ�������* ����
				k=num+1-i;
				z=i-(num+1)/2;
			}
			else {
				k=i;
				z=(num+1)/2-i;
			}	
			for(int j=1;j<=z;j++) {        //���ÿһ�еĿո�   ��ĿΪz
				System.out.print(" ");
			}
			for(int j=1;j<=(2*k-1);j++) {    //���ÿһ��*����Ŀ  ��ĿΪ��2*k-1��
				System.out.print(flag);
			}
			
			System.out.println("");
		}
		/*
		     *         1           3       
		    ***        2            2
		   *****       3             1
		  *******       4            0
		   *****        5            1
		    ***         6            2
	         *          7           3
	         */
	}
}
