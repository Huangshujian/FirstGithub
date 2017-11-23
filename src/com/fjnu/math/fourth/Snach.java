
package com.fjnu.math.fourth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 树俭啊
 */  
public class Snach {
	
	Task task;
	List<Task> list;
	List<Task> DealList;                    //处理对列
	Files file;
	int CurrentTime;                        //当前时间
	private int TimeMessage[][];       		//接收获取的任务时间
	/**
	 * 构造函数
	 */
	public Snach() {
		task = new Task();
		list = new ArrayList<Task>();
		DealList = new LinkedList<Task>();  
		CurrentTime = 1;
		file = new Files("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\input.txt");
		TimeMessage = new int [100][3];
		file.ReadFile();  				   //读取文件
		file.GetTimeMessage(TimeMessage);  //把数据放在TimeMessage里面
		for(int i=0;i<100;i++) {
			task = new Task();
			task.SetTimedate(TimeMessage[i]);
			list.add(task);
		}
	}
	
	public void SnachM() {
		//每进行一秒都得看下谁复合抢占资格
		int TaskNum=0;
		DealList.add(list.get(0));
		TaskNum++;
		for(;;) {
			
			//Collections.sort(list);
			//if(list.get(TaskNum).s)
			/*进行排序 找到动态服务时间最小的任务*/
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
			//判断该任务是否是刚加的 设置开始时间
			if(DealList.get(0).GetDnyServTime()==DealList.get(0).GetServiceTime()) {
				DealList.get(0).SetStartTime(CurrentTime);
			}
			//找到后 动态服务时间－1
			DealList.get(0).SetDnyServTime(DealList.get(0).GetDnyServTime()-1);
			//判断该任务是否做完 DnyServTime==0的时候任务结束
			if(DealList.get(0).GetDnyServTime()==0) {  //服务时间满
				DealList.get(0).sumTime(DealList.get(0).GetStartTime());
				DealList.remove(0); //移除处理队列
			}
			CurrentTime++;
			if(TaskNum<100) {
				
				DealList.add(list.get(TaskNum));
				TaskNum++;
				//每秒进入等待队列
			}
			if(DealList.size()==0) {
				break;
			}
		}
	}
	
	/**
	 * List排序测试
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
