package com.fjnu.math.fourth;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author 树俭啊
 */
public class File {
	
	FileWriter writer;
	FileReader reader;
	BufferedReader br;
	private int [] ServiceTime;       //服务时间
	private Random random;            //随机化参数
	private int [][] TimeMessage;
	
	/**
	 * 构造函数
	 * @param Pathname 文件路径名
	 */
	File(String Pathname) {
		//task = new Task();
		try {
            this.reader = new FileReader(Pathname);
            this.br = new BufferedReader(reader);
            this.writer = new FileWriter(Pathname,true);  //没有true 表示覆盖写入的文件
		}catch(FileNotFoundException e) {
            e.printStackTrace();
      }
      catch(IOException e) {
            e.printStackTrace();
      }
	  random = new Random();
	  ServiceTime = new int []{6,1,3,2,9};
	  TimeMessage = new int [100][3];
	}
	
	/**
	 * 随机产生0-4的数作为ServicerTime的下标
	 * @return 返回新生成的任务的服务时间
	 */
	public int RandomParam() {
		int k=0;			
		k=random.nextInt(4);
		return ServiceTime[k];
	}
	
	/**
	 * 生成100组（TaskId ArriveTime ServiceTime）数据
	 * 写入文件夹中
	 */
	public void WriteFile() {
		for(int i=1;i<=100;i++) {
			String TaskID = ""+i;
			String ArrivalTime  = ""+(i-1);
			String ServiceTime  = ""+this.RandomParam();
			String WriterString=TaskID+"  "+ArrivalTime+"  "+ServiceTime+"\r\n";	
			try {
				writer.append(WriterString);
				writer.flush(); 
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
		System.out.println("写入成功！");
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取文件函数
	 */
	public void ReadFile() {
		int k=0;
		try {
			String line="";
	        String[] arrs=null;
	        while ((line=br.readLine())!=null) {
	            arrs=line.split("  ");  //每次读取一条并打印出来 以“ ”间隔开
	            for(int i=0;i<3;i++) {
	            	TimeMessage[k][i]=Integer.parseInt(arrs[i]);
	            }
	            k++;
	        }
				  br.close();  
				  reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	/**
	 * 读取文件中的数据到Time数组中
	 * @param Time
	 */
	public void GetTimeMessage(int [][]Time) {
		for(int k=0;k<100;k++) {
			for(int i=0;i<3;i++) {
				Time[k][i] = TimeMessage[k][i];
			}
		}
	}
}
