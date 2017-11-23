package com.fjnu.math.sixth;

import java.io.Serializable;

/**
 * @param
 * @author 树俭啊
 */
public class Student implements Serializable,Comparable<Student>{
	private String StudentID;
	private String Name;
	private String Sex;
	Files file;
	private static final long serialVersionUID = 1234L;
	Student() {
		//file.ReadFile();                  //从文件中读取信息
		//file.GetSutdentMessage(Message);  //获取信息到Message
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
	//第一种是list中的对象实现Comparable接口，如下：
	//http://www.blogjava.net/landor2004/articles/sort.html 方法
	/* （非 Javadoc）
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Student another) {
		return this.GetStudentID().compareTo(another.GetStudentID());
	}
}
