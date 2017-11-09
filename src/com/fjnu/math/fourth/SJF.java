
package com.fjnu.math.fourth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ����
 * ����ҵ�����㷨
 */
public class SJF {
	//��һ��ִ�� ִ������ڵȴ������е���С����ʱ�俪ʼ����
	Task task;
	List<Task> list;
	List<Task> WaitList;                    //�ȴ�����
	List<Task> DealList;                    //������� 
	Files file;
	int CurrentTime;                        //��ǰʱ��
	private int TimeMessage[][];       		//���ջ�ȡ������ʱ����Ϣ
	private int SortTimeMessage[][];        //������������Ϣ
	
	/**
	 * ���캯��  1.��ʼ����Ա����  
	 *        2.��ȡ�ļ��е�ʱ�����ݲ���ֵ��TimeMessage[]��
	 */       
	SJF() {
		task = new Task();  
		WaitList = new LinkedList<Task>();
		list = new ArrayList<Task>();
		DealList = new LinkedList<Task>();
		CurrentTime = 1;
		file = new Files("F:\\ѧϰ\\����\\JAVA�������������\\practice\\1.txt");
		TimeMessage = new int [100][3];
		SortTimeMessage = new int [100][3];
		file.ReadFile();  				   //��ȡ�ļ�
		file.GetTimeMessage(TimeMessage);  //�����ݷ���TimeMessage����
		for(int i=0;i<100;i++) {
			task = new Task();
			task.SetTimedate(TimeMessage[i]);
			WaitList.add(task);
			list.add(task);
		}
	}
	
	/**
	 * ͨ��������ĳ��̽������������������������ȷ����㷨���м���
	 * ֻ����һ������
	 */
	public void SjfFrist() {
		FCFS fcfs = new FCFS();
		Sort();
		fcfs.ChangeMessage(SortTimeMessage);
		fcfs.FcfsFrist();
	}
	/**
	 * �ȴ���������񵽴�����У�û������һ�������ɾ���������񣬲����´Ӷ�������
	 * ����ʱ����̲��һ�δ��ɣ���Ǳ���flag��������,��ӵ��������ѭ����ʼ�Ĳ���
	 */
	public void SjfSecond() {
		int DnyServTime = 1;//����Ķ�̬����ʱ�䣬�ó�ʼ��Ϊ��һ������Ķ�̬����ʱ�䣬��ʾ��ǰ����»���Ҫ�����ʱ��
		int flag=0;         //�������һ�������޷��������Դ˱����Ϊ���һ�����������
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
			if(CurrentTime<100)  {      //��ʾ����δȫ������ȴ�����
				MinValue = 6;
				MinIndex = i;
				for(int j=CurrentTime;j>=0;j--) {  //�ҳ���̬����ֵ��С��ֵ �Լ��±�
					//�ѵ�һ�������ʱ��
					if(list.get(j).GetDnyServTime()<=MinValue&&list.get(j).GetFlag()!=0) {
						MinValue = list.get(j).GetDnyServTime();
						MinIndex = j;
					}
				}//�Ѳ�����0����Сֵ�ҳ���
			}
			else {  ////��ʾ����ȫ�����ڵȴ�������
				MinValue = 6;
				MinIndex = i;
				for(int j=99;j>=0;j--) {  //�ҳ���̬����ֵ��С��ֵ �Լ��±�
					//�ѵ�һ�������ʱ��
					if(list.get(j).GetDnyServTime()<=MinValue&&list.get(j).GetFlag()!=0) {
						MinValue = list.get(j).GetDnyServTime();
						MinIndex = j;
					}
				}//�Ѳ�����0����Сֵ�ҳ���
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
