package com.fjnu.math.first;

public class Translation {
	public static void main(String [] args) {
	int [] arr = new int []{100,80,50,85,91,61,59,23,69,76};
	String [] code = new String []{"优秀","良好","中","合格","不合格"};
	int [][] array = new int [5][10];       //存放下标
	int [] flag = new int []{0,0,0,0,0};    //存放每个等级的数目
	for(int i=0;i<10;i++) { 
		int k=arr[i]/10;
		switch(k) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:	
			array[4][flag[4]]=i;
			flag[4]++;
			break;
		case 6:
			array[3][flag[3]]=i;
			flag[3]++;
			break;
		case 7:
			array[2][flag[2]]=i;
			flag[2]++;
			break;
		case 8:
			array[1][flag[1]]=i;
			flag[1]++;
			break;
		case 9:
		case 10:
			array[0][flag[0]]=i;
			flag[0]++;
			break;
		}
	}
	for(int i=0;i<5;i++) {
		System.out.print(code[i]+": ");
		for(int j=0;j<flag[i];j++) {
			System.out.print(arr[array[i][j]]+" ");
		}
		System.out.println("");
	}
	
  }
}
