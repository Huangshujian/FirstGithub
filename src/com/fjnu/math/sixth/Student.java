package com.fjnu.math.sixth;

import java.io.Serializable;

/**
 * @param
 * @author ����
 */
public class Student implements Serializable,Comparable<Student>{
	private String StudentID;
	private String Name;
	private String Sex;
	Files file;
	private static final long serialVersionUID = 1234L;
	Student() {
		//file.ReadFile();                  //���ļ��ж�ȡ��Ϣ
		//file.GetSutdentMessage(Message);  //��ȡ��Ϣ��Message
	}
	public void SetStudentID(String StudentID) {
		this.StudentID = StudentID;
	}
	public void SetName(String Name) {
		this.Name = Name;
	}
	public void SetSex(String Sex) {
		this.Sex = Sex;
	}
	public String GetStudentID() {
		return StudentID;
	}
	public String GetName() {
		return Name;
	}
	public String GetSex() {
		return Sex;
	}
	//��һ����list�еĶ���ʵ��Comparable�ӿڣ����£�
	//http://www.blogjava.net/landor2004/articles/sort.html ����
	/* ���� Javadoc��
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Student another) {
		return this.GetStudentID().compareTo(another.GetStudentID());
	}
}
