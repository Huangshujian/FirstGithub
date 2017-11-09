/**
 * 
 */
package com.fjnu.math.fiveth;

import java.io.*;
import java.util.Scanner;
public class Main {

	/**
	 * @param args
	 * @author 树俭啊
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in); 
		try {  
			File First_File = new File("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\src.txt");  
			File Second_file = new File("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\dest.txt");
            FileOutputStream OutPut = new FileOutputStream(First_File);  //输出流  输到文件
            FileInputStream InPut = new FileInputStream(First_File);    //输入流  从文件中读取
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
