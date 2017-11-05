package com.fjnu.math.fourth;
import java.util.Scanner;
/** 
 * @author  树俭啊
 */
public class Main {

	public static void main(String[] args) {
		int num=0;
		Scanner in = new Scanner(System.in);
		System.out.println("-----------算法选择------------------");
		System.out.println("1.SJF短作业优先算法(一个处理器)");
		System.out.println("2.SJF短作业优先算法(两个处理器)");
		System.out.println("3.FCFS先来先服务算法(一个处理器)");
		System.out.println("4.FCFS先来先服务算法(两个处理器)");
		System.out.println("5.服务时间抢占算法");
		System.out.println("6.重新生成数据文件");
		System.out.println("7.读取数据文件");
		System.out.print("Please Enter You Choose : ");
		num = in.nextInt();
		SJF Sjf = new SJF();
		FCFS FcFs = new FCFS();
		File file = new File("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\1.txt");
		if(num==1) {
			System.out.println("--任务输出信息先后根据完成时间--");
			Sjf.SjfFrist();
		}
		else if( num==2) {
			System.out.println("--任务输出信息先后根据完成时间--");
			Sjf.SjfSecond();
		}
		else if(num==3) {
			System.out.println("--任务输出信息先后根据完成时间--");
			FcFs.FcfsFrist();
		}
		else if(num==4) {
			System.out.println("--任务输出信息先后根据完成时间--");
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
			System.out.println("任务ID"+" "+"到达时间"+" "+"服务时间");
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
