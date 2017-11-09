
package com.fjnu.math.fourth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * @author ����
 */
public class FCFS {
	Task task;
	List<Task> list;
	List<Task> DealList;                    //�������
	Files file;
	int CurrentTime;                        //��ǰʱ��
	private int TimeMessage[][];       		//���ջ�ȡ������ʱ��
	  
	/**
	 * ���캯��  1.��ʼ����Ա����  
	 *        2.��ȡ�ļ��е�ʱ�����ݲ���ֵ��TimeMessage[]��
	 */       
	FCFS() {
		task = new Task();
		list = new ArrayList<Task>();
		DealList = new LinkedList<Task>();  
		CurrentTime = 1;
		file = new Files("F:\\ѧϰ\\����\\JAVA�������������\\practice\\1.txt");
		TimeMessage = new int [100][3];
		file.ReadFile();  				   //��ȡ�ļ�
		file.GetTimeMessage(TimeMessage);  //�����ݷ���TimeMessage����
		
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
	 * ֻ��һ��������е�����µ������ȷ����㷨
	 * StartTime�������ִ�п�ʼʱ��
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
	 *  ����������ŵ�ִ�ж����У����бȽϣ�������ɵ������Ƴ����в��������һ������
	 *  �Ƚϵķ�ʽ���ڵ�ǰʱ����������Ķ�̬����ʱ���С
	 *  List�У��Ƴ�����һ��Ԫ�أ��������Ԫ����ǰ��
	 *  CurrFronStartTime/CurrLastStartTime:Ϊ��������ǰʱ���µķ���ʱ�䣨��Ҫ��ɵ�ʱ�䣩
	 *  ����һ������ �����µ�ǰʱ��
	 */
	public void FcfsSecond() {	
		SetTask();
		int DnyServTime = 1;
		int flag=0;
		DealList.add(list.get(0));
		
		/**
		 * @CurrentTime=1 ��ǰʱ��Ϊ1���ӵڶ�������ʼ
		 */
		for(int i=1;i<list.size();i++) { 
			DealList.add(list.get(i)); 
			Task taskFront = new Task();
			Task taskLast = new Task();
			taskFront = DealList.get(0);
			taskLast = DealList.get(1);
			int CurrFronServTime,CurrLastServTime;
			/** 
			 * ���ڴӵڶ�������ʼ����һ�������CurrFronStartTime��= DnyServTime
			 * ��������� CurrStartTime = DnyServTime ��̬����ʱ��
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
				//���߶�̬����ʱ��Ƚ� ˭��С ��ʾ˭������ 
				CurrentTime =CurrLastServTime +CurrentTime;  
				DnyServTime = CurrFronServTime-CurrLastServTime;  
				taskFront.SetDnyServTime(DnyServTime);  //�Ѷ�̬����ʱ�䴫��ȥ
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
