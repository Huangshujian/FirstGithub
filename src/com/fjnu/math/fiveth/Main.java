/**
 * 
 */
package com.fjnu.math.fiveth;

import java.io.*;
import java.util.Scanner;
public class Main {

	/**
	 * @param args
	 * @author ����
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner in = new Scanner(System.in); 
		try {  
			File First_File = new File("F:\\ѧϰ\\����\\JAVA�������������\\practice\\src.txt");  
			File Second_file = new File("F:\\ѧϰ\\����\\JAVA�������������\\practice\\dest.txt");
            FileOutputStream OutPut = new FileOutputStream(First_File);  //�����  �䵽�ļ�
            FileInputStream InPut = new FileInputStream(First_File);    //������  ���ļ��ж�ȡ
            int i;
            while((i=System.in.read())!=-1) {
            	OutPut.write(i);
            }
            int c;  
            OutPut.close();
            OutPut = new FileOutputStream(Second_file);
            while ((c = InPut.read()) != -1) {  
            	OutPut.write(c);  
            }  
            InPut.close();  
            OutPut.close();  
        } catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);  
        }
		in.close();
	}

}
