package com.fjnu.math.fourth;
import java.util.Scanner;
/** 
 * @author  ����
 */
public class Main {

	public static void main(String[] args) {
		int num=0;
		Scanner in = new Scanner(System.in);
		System.out.println("-----------�㷨ѡ��------------------");
		System.out.println("1.SJF����ҵ�����㷨(һ��������)");
		System.out.println("2.SJF����ҵ�����㷨(����������)");
		System.out.println("3.FCFS�����ȷ����㷨(һ��������)");
		System.out.println("4.FCFS�����ȷ����㷨(����������)");
		System.out.println("5.����ʱ����ռ�㷨");
		System.out.println("6.�������������ļ�");
		System.out.println("7.��ȡ�����ļ�");
		System.out.print("Please Enter You Choose : ");
		num = in.nextInt();
		SJF Sjf = new SJF();
		FCFS FcFs = new FCFS();
		File file = new File("F:\\ѧϰ\\����\\JAVA�������������\\practice\\1.txt");
		if(num==1) {
			System.out.println("--���������Ϣ�Ⱥ�������ʱ��--");
			Sjf.SjfFrist();
		}
		else if( num==2) {
			System.out.println("--���������Ϣ�Ⱥ�������ʱ��--");
			Sjf.SjfSecond();
		}
		else if(num==3) {
			System.out.println("--���������Ϣ�Ⱥ�������ʱ��--");
			FcFs.FcfsFrist();
		}
		else if(num==4) {
			System.out.println("--���������Ϣ�Ⱥ�������ʱ��--");
			FcFs.FcfsSecond();
		}
		else if(num==5) {
			
		}
		else if(num==6) {
			file.WriteFile();
		}
		else if(num==7) {
			int [][] TimeMessage = new int[100][3];
			file.ReadFile();
			file.GetTimeMessage(TimeMessage);
			System.out.println("����ID"+" "+"����ʱ��"+" "+"����ʱ��");
			for(int i=0;i<TimeMessage.length;i++) {
				System.out.println(TimeMessage[i][0]+"   "+
			TimeMessage[i][1]+"   "+TimeMessage[i][2]);
			}
		}
		else
			System.out.println("Error!!");
		in.close();
		
	}

}
