package com.fjnu.math.fourth;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author ����
 */
public class File {
	
	FileWriter writer;
	FileReader reader;
	BufferedReader br;
	private int [] ServiceTime;       //����ʱ��
	private Random random;            //���������
	private int [][] TimeMessage;
	
	/**
	 * ���캯��
	 * @param Pathname �ļ�·����
	 */
	File(String Pathname) {
		//task = new Task();
		try {
            this.reader = new FileReader(Pathname);
            this.br = new BufferedReader(reader);
            this.writer = new FileWriter(Pathname,true);  //û��true ��ʾ����д����ļ�
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
	 * �������0-4������ΪServicerTime���±�
	 * @return ���������ɵ�����ķ���ʱ��
	 */
	public int RandomParam() {
		int k=0;			
		k=random.nextInt(4);
		return ServiceTime[k];
	}
	
	/**
	 * ����100�飨TaskId ArriveTime ServiceTime������
	 * д���ļ�����
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
		System.out.println("д��ɹ���");
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ�ļ�����
	 */
	public void ReadFile() {
		int k=0;
		try {
			String line="";
	        String[] arrs=null;
	        while ((line=br.readLine())!=null) {
	            arrs=line.split("  ");  //ÿ�ζ�ȡһ������ӡ���� �ԡ� �������
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
	 * ��ȡ�ļ��е����ݵ�Time������
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
