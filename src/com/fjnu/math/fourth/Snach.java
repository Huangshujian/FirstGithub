
package com.fjnu.math.fourth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ����
 */  
public class Snach {
	
	Task task;
	List<Task> list;
	List<Task> DealList;                    //�������
	Files file;
	int CurrentTime;                        //��ǰʱ��
	private int TimeMessage[][];       		//���ջ�ȡ������ʱ��
	/**
	 * ���캯��
	 */
	public Snach() {
		task = new Task();
		list = new ArrayList<Task>();
		DealList = new LinkedList<Task>();  
		CurrentTime = 1;
		file = new Files("F:\\ѧϰ\\����\\JAVA�������������\\practice\\input.txt");
		TimeMessage = new int [100][3];
		file.ReadFile();  				   //��ȡ�ļ�
		file.GetTimeMessage(TimeMessage);  //�����ݷ���TimeMessage����
		for(int i=0;i<100;i++) {
			task = new Task();
			task.SetTimedate(TimeMessage[i]);
			list.add(task);
		}
	}
	
	public void SnachM() {
		//ÿ����һ�붼�ÿ���˭������ռ�ʸ�
		int TaskNum=0;
		DealList.add(list.get(0));
		TaskNum++;
		for(;;) {
			
			//Collections.sort(list);
			//if(list.get(TaskNum).s)
			/*�������� �ҵ���̬����ʱ����С������*/
			Collections.sort(DealList, new Comparator<Task>(){
		         @Override
		         public int compare(Task o1, Task o2) {
		             if(o1.GetDnyServTime()>o2.GetDnyServTime()){
		                 return 1;
		             }
		             if(o1.GetDnyServTime()==o2.GetDnyServTime()){
		                 return 0;
		             }
		             return -1;
		         }          
		     });
			//�жϸ������Ƿ��Ǹռӵ� ���ÿ�ʼʱ��
			if(DealList.get(0).GetDnyServTime()==DealList.get(0).GetServiceTime()) {
				DealList.get(0).SetStartTime(CurrentTime);
			}
			//�ҵ��� ��̬����ʱ�䣭1
			DealList.get(0).SetDnyServTime(DealList.get(0).GetDnyServTime()-1);
			//�жϸ������Ƿ����� DnyServTime==0��ʱ���������
			if(DealList.get(0).GetDnyServTime()==0) {  //����ʱ����
				DealList.get(0).sumTime(DealList.get(0).GetStartTime());
				DealList.remove(0); //�Ƴ��������
			}
			CurrentTime++;
			if(TaskNum<100) {
				
				DealList.add(list.get(TaskNum));
				TaskNum++;
				//ÿ�����ȴ�����
			}
			if(DealList.size()==0) {
				break;
			}
		}
	}
	
	/**
	 * List�������
	 */
	public void  temp() {
		Collections.sort(list, new Comparator<Task>(){
	         @Override
	         public int compare(Task o1, Task o2) {
	             if(o1.GetDnyServTime()>o2.GetDnyServTime()){
	                 return 1;
	             }
	             if(o1.GetServiceTime()==o2.GetServiceTime()){
	                 return 0;
	             }
	             return -1;
	         }
		});
		for(int i=0;i<100;i++) {
			System.out.println(list.get(i).GetArriveTime()+"  "
					+list.get(i).GetServiceTime());
		}
		
	}
}
