/**
 * 
 */
package com.fjnu.math.sixth;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author 树俭啊
 */
public class Files {
	
	FileWriter writer;
	FileReader Reader;
	BufferedReader BuffRead;
	private String [][] StudentMessage;
	private int N;
	
	Files(){
		//task = new Task();
		try {
            this.Reader = new FileReader("F:\\学习\\大三\\JAVA面向对象程序设计\\practice\\lis.txt");
            // BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            this.BuffRead = new BufferedReader(Reader);   
		}catch(FileNotFoundException e) {
            e.printStackTrace();
		}
		StudentMessage = new String [100][3];
		N = 0;
	}
	
 
	public void ReadFile() {
		try { 
			String line = "";
	        String[] arrs=null;
	        while ((line=BuffRead.readLine())!=null) {
	        	arrs=line.split(" ");  
	        	//System.out.println(line);
	            for(int i=0;i<3;i++) {
	            	StudentMessage[N][i]=arrs[i];
	            }
	            N++;
	        }
	        BuffRead.close();  
		    Reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	public void GetSutdentMessage(String [][]Message) {
		for(int i=0;i<N;i++) {
			Message[i][0]=StudentMessage[i][0];
			Message[i][1]=StudentMessage[i][1];
			Message[i][2]=StudentMessage[i][2];
        	//System.out.println("写入成功！");
        }
	}
	
	public int GetN() {
		return N;
	}
	public void TestShow() {
		for(int i=0;i<N;i++) {
        	System.out.println(StudentMessage[i][0]+"      "+
		StudentMessage[i][1]+"      "+StudentMessage[i][2]);
        }
	}
}
