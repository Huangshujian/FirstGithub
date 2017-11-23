
package com.fjnu.math.sixth;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ê÷¼ó°¡
 * @param
 */
public class Stu_Serializable {
	private String filename;
	String[][] Message;
	Files file;
	Student student;
	List<Student> list;
	List<Student> Afterlist;
	private int N;
	
	Stu_Serializable() {
		filename = "Student.bin";
		Message= new String [100][3];
		file = new Files();
		student = new Student();
		list = new ArrayList<Student>();
		Afterlist = new ArrayList<Student>();
		file.ReadFile();
		file.GetSutdentMessage(Message);
		N = file.GetN();
	}
	
	public void ObjectOutPut() {
		for(int i=0;i<N;i++) {
			student = new Student();
			student.SetStudentID(Message[i][0]);
			student.SetName(Message[i][1]);
			student.SetSex(Message[i][2]);
			list.add(student);    
		}
		Collections.sort(list);
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		} 
		catch (IOException ex) {
			   ex.printStackTrace();
		}
	}
	
	public void ObjectInPut() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			Afterlist = (List<Student>) in.readObject();
			in.close();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} 
		catch (ClassNotFoundException ex) {
		ex.printStackTrace();
		}
	}
	
	public void StreamShow() {
		for(int i=0;i<Afterlist.size();i++) {
			System.out.println("Person: " + Afterlist.get(i).GetStudentID() + 
					" " +  Afterlist.get(i).GetName()+"  "+ Afterlist.get(i).GetSex());
		}
	}
	
	public void sort() {
		for(int i=0;i<N;i++) {
			
		}
	}
}
