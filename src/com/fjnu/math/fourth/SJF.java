
package com.fjnu.math.fourth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 树俭啊
 * 短作业优先算法
 */
public class SJF {
	//第一个执行 执行完毕在等待队列中的最小服务时间开始工作
	Task task;
	List<Task> list;
	List<Task> WaitList;                    //等待对列
	List<Task> DealList;                    //处理队列 
	Files file;
	int CurrentTime;                        //当前时间
	private int TimeMessage[][];       		//接收获取的任务时间信息
	private int SortTimeMessage[][];        //排序后的任务信息
	
	/**
	 * 构造函数  1.初始化成员变量  
	 *        2.读取文件中的时间数据并赋值到TimeMessage[]中
	 */       
	SJF() {
		task = new Task();  
		WaitList = new LinkedList<Task>();
		list = new ArrayList<Task>();
		DealList = new LinkedList<Task>();
		CurrentTime = 1;
		file = new Files("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\1.txt");
		TimeMessage = new int [100][3];
		SortTimeMessage = new int [100][3];
		file.ReadFile();  				   //读取文件
		file.GetTimeMessage(TimeMessage);  //把数据放在TimeMessage里面
		for(int i=0;i<100;i++) {
			task = new Task();
			task.SetTimedate(TimeMessage[i]);
			WaitList.add(task);
			list.add(task);
		}
	}
	
	/**
	 * 通过对任务的长短进行排序，排序后的任务按照先来先服务算法进行计算
	 * 只处理一个任务
	 */
	public void SjfFrist() {
		FCFS fcfs = new FCFS();
		Sort();
		fcfs.ChangeMessage(SortTimeMessage);
		fcfs.FcfsFrist();
	}
	/**
	 * 先存放两个任务到处理队列，没处理完一个任务就删除掉该任务，并重新从队列中找
	 * 服务时间最短并且还未完成（标记变量flag）的任务,添加到处理队列循环开始的操作
	 */
	public void SjfSecond() {
		int DnyServTime = 1;//任务的动态服务时间，该初始化为第一个任务的动态服务时间，表示当前情况下还需要服务的时间
		int flag=0;         //由于最后一个任务无法操作，以此标记作为最后一个处理的任务
		int MinValue=0,MinIndex=1;
		
		DealList.add(list.get(0));
		list.get(0).SetFlag(0);
		for(int i=1;i<list.size();i++) { 
			DealList.add(list.get(MinIndex)); 
			list.get(MinIndex).SetFlag(0);
			Task taskFront = new Task();
			Task taskLast = new Task();
			taskFront = DealList.get(0);
			taskLast = DealList.get(1);
			int CurrFronServTime,CurrLastServTime;
			if(CurrentTime==1) {  
				CurrFronServTime = taskFront.GetDnyServTime()-CurrentTime;
				CurrLastServTime = taskLast.GetDnyServTime();
			}
			else {
				CurrFronServTime = taskFront.GetDnyServTime();
				CurrLastServTime = taskLast.GetDnyServTime();
			}
			if(CurrFronServTime>CurrLastServTime) {   
				//两者动态服务时间比较 谁最小 表示谁先做完 
				CurrentTime =CurrLastServTime +CurrentTime;  
				DnyServTime = CurrFronServTime-CurrLastServTime;  
				taskFront.SetDnyServTime(DnyServTime);  //把动态服务时间传进去
				taskLast.sumTime(CurrentTime-taskLast.GetServiceTime());
				DealList.remove(1);
				flag=1;
			}
			else {
				CurrentTime =CurrFronServTime +CurrentTime;   
				DnyServTime = CurrLastServTime-CurrFronServTime;
				taskLast.SetDnyServTime(DnyServTime);
				taskFront.sumTime(CurrentTime-taskFront.GetServiceTime());
				DealList.remove(0);
			}
			if(CurrentTime<100)  {      //表示任务还未全部到达等待队列
				MinValue = 6;
				MinIndex = i;
				for(int j=CurrentTime;j>=0;j--) {  //找出动态任务值最小的值 以及下标
					//把第一个任务的时间
					if(list.get(j).GetDnyServTime()<=MinValue&&list.get(j).GetFlag()!=0) {
						MinValue = list.get(j).GetDnyServTime();
						MinIndex = j;
					}
				}//把不等于0的最小值找出来
			}
			else {  ////表示任务全部都在等待队列中
				MinValue = 6;
				MinIndex = i;
				for(int j=99;j>=0;j--) {  //找出动态任务值最小的值 以及下标
					//把第一个任务的时间
					if(list.get(j).GetDnyServTime()<=MinValue&&list.get(j).GetFlag()!=0) {
						MinValue = list.get(j).GetDnyServTime();
						MinIndex = j;
					}
				}//把不等于0的最小值找出来
			}
			if(i==99) {	
				if(flag==1) { 
					taskLast.sumTime(CurrentTime-taskLast.GetServiceTime()+taskLast.GetDnyServTime());
				}
				else {
					taskFront.sumTime(CurrentTime-taskLast.GetServiceTime()+taskLast.GetDnyServTime());
				}
			}
		}
	}
	public void Sort() {
		for(int i=0;i<WaitList.size();i++) { 
			SortTimeMessage[i][0] = TimeMessage[i][0];
			SortTimeMessage[i][1] = TimeMessage[i][1];
			SortTimeMessage[i][2] = TimeMessage[i][2];
		}
		int StartTime = SortTimeMessage[0][2];   
		for(int i=1;i<WaitList.size();i++) {
			
			if(StartTime>WaitList.size()-1) {
				StartTime = WaitList.size()-1;
			}
			for(int j=i;j<=StartTime;j++)  {
				for(int k=StartTime;k>i;k--) {
					if(SortTimeMessage[k-1][2]>SortTimeMessage[k][2]) {
						int [] temp = SortTimeMessage[k];
						SortTimeMessage[k] = SortTimeMessage[k-1];
						SortTimeMessage[k-1] = temp;
					}
				}	
			}
			if(StartTime == WaitList.size()-1)
				break;
			StartTime = StartTime + SortTimeMessage[i][2];
		}
	}
}
