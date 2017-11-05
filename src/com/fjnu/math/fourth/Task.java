package com.fjnu.math.fourth;

/**
 * @author ����
 */
public class Task {
	
	private int ServiceTime;     	  //����ʱ��
	private int TaskId;               //����ID  ����ʱ��  ����ʱ��
	private int StartingTime;		  //��ʼʱ��
	private int FinishingTime;        //���ʱ�� = ��ʼʱ��+����ʱ��
	private int TurnAroundTime;       //��תʱ�� = ���ʱ��-����ʱ��
	private int ArriveTime;           //����ʱ��
	private double WeightTurnAround;  //��Ȩ��תʱ�� = ��תʱ��/����ʱ��
	private int DnyServTime;          //��̬����ʱ��
	private int flag;
	public void Show() {
		System.out.println("����ID  ��ʼʱ��   ����ʱ��    ���ʱ��      �� ת ʱ ��       ��Ȩ ��ת ʱ��");
		System.out.println(TaskId+"      "+StartingTime+"      "+ServiceTime+"    "+"   "+FinishingTime+"       "
				+TurnAroundTime+"         "+WeightTurnAround);
	}
	/** 
	 * ���캯�� ��ʼ����Ա����
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
	 * ��ȡ����ʱ��
	 * @return ServiceTime
	 */
	public int GetServiceTime() {
		return ServiceTime;
	}
	
	/**
	 * ��ȡ��̬����ʱ��
	 * @return DnyServTime
	 */
	public int GetDnyServTime() {
		return DnyServTime;
	}
	
	/**
	 * ��ȡ����ĵ���ʱ��
	 * @return ArriveTime
	 */
	public int GetArriveTime() {
		return ArriveTime;
	}
	
	/**
	 * ��������Ķ�̬ʱ��
	 * @param flagTime
	 */
	public void SetDnyServTime(int flagTime) {
		DnyServTime=flagTime;
	}
	
	public int GetFinshiTime() {
		return FinishingTime;
	}
	
	/**
	 * �����ĸ���Ҫʱ��ֵ
	 * @param time
	 */
	public void SetTimedate(int [] time) {
		this.TaskId = time[0];
		this.ArriveTime = time[1];
		this.ServiceTime = time[2];
		this.DnyServTime = ServiceTime;  
	}
	
	/**
	 * ͨ����ȡ�Ŀ�ʼʱ�� �����ĿҪ���ʱ��
	 * @param StartTime
	 */
	public void sumTime( int StartTime) {
		StartingTime=StartTime;         
		FinishingTime=StartingTime+ServiceTime;  			 //���ʱ��
		TurnAroundTime=FinishingTime-ArriveTime; 			 //��תʱ��
		WeightTurnAround=(TurnAroundTime*1.0)/ServiceTime;   //��Ȩ��ת
		Show();
	}
}
