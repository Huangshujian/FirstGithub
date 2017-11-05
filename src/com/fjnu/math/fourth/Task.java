package com.fjnu.math.fourth;

/**
 * @author 树俭啊
 */
public class Task {
	
	private int ServiceTime;     	  //服务时间
	private int TaskId;               //任务ID  到达时间  服务时间
	private int StartingTime;		  //开始时间
	private int FinishingTime;        //完成时间 = 开始时间+服务时间
	private int TurnAroundTime;       //周转时间 = 完成时间-到达时间
	private int ArriveTime;           //到达时间
	private double WeightTurnAround;  //带权周转时间 = 周转时间/服务时间
	private int DnyServTime;          //动态服务时间
	private int flag;
	public void Show() {
		System.out.println("任务ID  开始时间   服务时间    完成时间      周 转 时 间       带权 周转 时间");
		System.out.println(TaskId+"      "+StartingTime+"      "+ServiceTime+"    "+"   "+FinishingTime+"       "
				+TurnAroundTime+"         "+WeightTurnAround);
	}
	/** 
	 * 构造函数 初始化成员变量
	 */  
	Task() {
		flag=1;
		TaskId = 0;
		StartingTime = 0;
		FinishingTime = 0;
		TurnAroundTime = 0;
		WeightTurnAround = 0;
		ArriveTime=0;
		ServiceTime=0;
	}
	
	public int GetFlag() {
		return flag;
	}
	public void SetFlag(int flag) {
		this.flag = flag;
	}
	/**
	 * 获取服务时间
	 * @return ServiceTime
	 */
	public int GetServiceTime() {
		return ServiceTime;
	}
	
	/**
	 * 获取动态服务时间
	 * @return DnyServTime
	 */
	public int GetDnyServTime() {
		return DnyServTime;
	}
	
	/**
	 * 获取任务的到达时间
	 * @return ArriveTime
	 */
	public int GetArriveTime() {
		return ArriveTime;
	}
	
	/**
	 * 设置任务的动态时间
	 * @param flagTime
	 */
	public void SetDnyServTime(int flagTime) {
		DnyServTime=flagTime;
	}
	
	public int GetFinshiTime() {
		return FinishingTime;
	}
	
	/**
	 * 设置四个主要时间值
	 * @param time
	 */
	public void SetTimedate(int [] time) {
		this.TaskId = time[0];
		this.ArriveTime = time[1];
		this.ServiceTime = time[2];
		this.DnyServTime = ServiceTime;  
	}
	
	/**
	 * 通过获取的开始时间 求出题目要求的时间
	 * @param StartTime
	 */
	public void sumTime( int StartTime) {
		StartingTime=StartTime;         
		FinishingTime=StartingTime+ServiceTime;  			 //完成时间
		TurnAroundTime=FinishingTime-ArriveTime; 			 //周转时间
		WeightTurnAround=(TurnAroundTime*1.0)/ServiceTime;   //带权周转
		Show();
	}
}
