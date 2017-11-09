
package com.fjnu.math.fourth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @author 树俭啊
 */
public class FCFS {
	Task task;
	List<Task> list;
	List<Task> DealList;                    //处理对列
	Files file;
	int CurrentTime;                        //当前时间
	private int TimeMessage[][];       		//接收获取的任务时间
	  
	/**
	 * 构造函数  1.初始化成员变量  
	 *        2.读取文件中的时间数据并赋值到TimeMessage[]中
	 */       
	FCFS() {
		task = new Task();
		list = new ArrayList<Task>();
		DealList = new LinkedList<Task>();  
		CurrentTime = 1;
		file = new Files("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\1.txt");
		TimeMessage = new int [100][3];
		file.ReadFile();  				   //读取文件
		file.GetTimeMessage(TimeMessage);  //把数据放在TimeMessage里面
		
	}
	public void SetTask() {
		
		for(int i=0;i<100;i++) {
			task = new Task();
			task.SetTimedate(TimeMessage[i]);
			list.add(task);    
		}
	}
	
	public void ChangeMessage(int [][] SortTime) {
		for(int i=0;i<100;i++) {
			TimeMessage[i][0] = SortTime[i][0];
			TimeMessage[i][1] = SortTime[i][1];
			TimeMessage[i][2] = SortTime[i][2];
		}
	}
	
	/**
	 * 只有一个处理队列的情况下的先来先服务算法
	 * StartTime：任务的执行开始时间
	 */
	public void FcfsFrist() {	
		SetTask();
		int StartTime=0;
		for(int i=0;i<100;i++) {
			task = new Task();
			task = list.get(i);
			task.sumTime(StartTime);
			StartTime=StartTime+task.GetServiceTime();
		}
	}
	
	/**
	 *  把两个任务放到执行队列中，进行比较，最先完成的任务移除队列并重新添加一个任务
	 *  比较的方式：在当前时间下两任务的动态服务时间大小
	 *  List中，移除任意一个元素，它后面的元素向前移
	 *  CurrFronStartTime/CurrLastStartTime:为两个任务当前时间下的服务时间（需要完成的时间）
	 *  做完一个任务 更新新当前时间
	 */
	public void FcfsSecond() {	
		SetTask();
		int DnyServTime = 1;
		int flag=0;
		DealList.add(list.get(0));
		
		/**
		 * @CurrentTime=1 当前时间为1，从第二个任务开始
		 */
		for(int i=1;i<list.size();i++) { 
			DealList.add(list.get(i)); 
			Task taskFront = new Task();
			Task taskLast = new Task();
			taskFront = DealList.get(0);
			taskLast = DealList.get(1);
			int CurrFronServTime,CurrLastServTime;
			/** 
			 * 由于从第二个任务开始，第一个任务的CurrFronStartTime！= DnyServTime
			 * 后面的任务 CurrStartTime = DnyServTime 动态服务时间
			 */
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
			if(i==99) {	
				if(flag==1) {  
					taskLast.sumTime(CurrentTime+taskLast.GetDnyServTime()-taskLast.GetServiceTime());
				}
				else {
					taskFront.sumTime(CurrentTime+taskFront.GetDnyServTime()-taskFront.GetServiceTime());
				}
			}
		}
	}

}
