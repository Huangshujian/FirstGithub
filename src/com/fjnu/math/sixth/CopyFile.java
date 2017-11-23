
package com.fjnu.math.sixth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @param
 * @author ����
 */
public class CopyFile {
	File First_File;  
	File Second_file;
	FileOutputStream OutPut;  //�����  �䵽�ļ�
	FileInputStream InPut;    //������  ���ļ��ж�ȡ
	FileWriter Writer;
	FileReader Reader;
	BufferedWriter BuffWri;
	BufferedReader BuffRea;
	CopyFile() {
		First_File = new File("F:\\ѧϰ\\����\\JAVA�������������\\practice\\src.txt");  
		Second_file = new File("F:\\ѧϰ\\����\\JAVA�������������\\practice\\dest.txt");
		try {
			OutPut = new FileOutputStream(Second_file);  //�����  �䵽�ļ�
			InPut = new FileInputStream(First_File);    //������  ���ļ��ж�ȡ
		//	BufferedInputStream BuffFinS=new  BufferedInputStream(InPut);
		//  BufferedOutputStream BuffFoutS=new  BufferedOutputStream(OutPut);
		    //file---->fileOutputStream----->  BufferedInputStream   �����ֽ���
		    //file---->FileWriter      ----->  BufferedWriter        �����ַ���
			Writer = new FileWriter(Second_file);
			Reader = new FileReader(First_File);
			BuffWri = new  BufferedWriter(Writer);
			BuffRea = new  BufferedReader(Reader);	
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);
		}	
	}
	
	/**
	 * �Ӹ�ֵԴ�ļ���Ϣ����ǰ�ļ���û��Buff�����������ϵͳ�ĺ�ʱʱ��
	 */
	public void CopyWithoutBuff() {
		try{
			int c;
			long starTime =System.currentTimeMillis();
			while ((c = InPut.read()) != -1) {  
				OutPut.write(c);  
			}
			long endTime = System.currentTimeMillis();
			long Time=endTime-starTime;
			System.out.println("û�л�����������£�"+Time);
			OutPut.close();
			InPut.close();
		}catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);
		}
	}
	
	/**
	 * �Ӹ�ֵԴ�ļ���Ϣ����ǰ�ļ�����Buff�����������ϵͳ�ĺ�ʱʱ��
	 */
	public void CopyWithBuff() {
		try{		//�л�����
			String s = null;
			long starTime =System.currentTimeMillis();
			while((s=BuffRea.readLine())!=null) {
				BuffWri.write(s+"\r\n"+"������");
				System.out.println(s);
			}
			long endTime = System.currentTimeMillis();
			long Time=endTime-starTime;
			System.out.println("�л�����������£�"+Time);
			BuffWri.close();
			BuffRea.close();
			Writer.close();
			Reader.close();
		} catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);
		}
	}
}
