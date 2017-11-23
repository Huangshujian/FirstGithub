
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
 * @author 树俭啊
 */
public class CopyFile {
	File First_File;  
	File Second_file;
	FileOutputStream OutPut;  //输出流  输到文件
	FileInputStream InPut;    //输入流  从文件中读取
	FileWriter Writer;
	FileReader Reader;
	BufferedWriter BuffWri;
	BufferedReader BuffRea;
	CopyFile() {
		First_File = new File("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\src.txt");  
		Second_file = new File("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\dest.txt");
		try {
			OutPut = new FileOutputStream(Second_file);  //输出流  输到文件
			InPut = new FileInputStream(First_File);    //输入流  从文件中读取
		//	BufferedInputStream BuffFinS=new  BufferedInputStream(InPut);
		//  BufferedOutputStream BuffFoutS=new  BufferedOutputStream(OutPut);
		    //file---->fileOutputStream----->  BufferedInputStream   缓冲字节流
		    //file---->FileWriter      ----->  BufferedWriter        缓冲字符流
			Writer = new FileWriter(Second_file);
			Reader = new FileReader(First_File);
			BuffWri = new  BufferedWriter(Writer);
			BuffRea = new  BufferedReader(Reader);	
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);
		}	
	}
	
	/**
	 * 从赋值源文件信息到当前文件，没有Buff缓存区情况下系统的耗时时间
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
			System.out.println("没有缓冲区的情况下："+Time);
			OutPut.close();
			InPut.close();
		}catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);
		}
	}
	
	/**
	 * 从赋值源文件信息到当前文件，有Buff缓存区情况下系统的耗时时间
	 */
	public void CopyWithBuff() {
		try{		//有缓冲区
			String s = null;
			long starTime =System.currentTimeMillis();
			while((s=BuffRea.readLine())!=null) {
				BuffWri.write(s+"\r\n"+"缓冲区");
				System.out.println(s);
			}
			long endTime = System.currentTimeMillis();
			long Time=endTime-starTime;
			System.out.println("有缓冲区的情况下："+Time);
			BuffWri.close();
			BuffRea.close();
			Writer.close();
			Reader.close();
		} catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);
		}
	}
}
