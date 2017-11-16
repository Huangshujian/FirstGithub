package com.fjnu.math.fiveth;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *  
 * @param 
 * @version
 * @return 
 */
public class FileTree {
	// �ļ����ڵĲ���
	  SimpleDateFormat AlterTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  Calendar cal = Calendar.getInstance();
	  private int fileLevel;
	  /** 
	  * ���������ʽ
	  * @param name ������ļ�����Ŀ¼��
	  * @param level ������ļ�������Ŀ¼�����ڵĲ��
	  * @return ������ַ���
	  */
	  public String createPrintStr(String name, int level) {
		  // �����ǰ׺
		  String printStr = "";
		  // ����ν�������
		  for (int i=0;i<level;i++) {
			  printStr = printStr + " ";
		  }
		  printStr = printStr + "- " + name;
		  return printStr;
	  }
	  /**
	  * �����ʼ������Ŀ¼
	  * @param dirPath ������Ŀ¼
	  */
	  public void printDir(String dirPath){
		  // ��������Ŀ¼���зָ�
		  String[] dirNameList = dirPath.split("\\\\");
		  // �趨�ļ�level��base
		  fileLevel = dirNameList.length;
		  // ����ʽ���
		  for (int i=0;i<dirNameList.length;i++) {
			  System.out.println(createPrintStr(dirNameList[i], i));
		  }
	  }
	  /**
	  * �������Ŀ¼�µ��ļ���������Ŀ¼�е��ļ�
	  * @param dirPath ������Ŀ¼
	  */
	  public void readFile(String dirPath) {
		  // ������ǰĿ¼���ļ���File����
		  File file = new File(dirPath);
		  // ȡ�ô���Ŀ¼�������ļ���File��������
		  File[] list = file.listFiles();
		  // ����file����
		 // AlterTime.format(cal.getTime());
		  for (int i =0 ; i < list.length; i++) {
			  cal.setTimeInMillis(list[i].lastModified());
			  if (list[i].isDirectory()) {
				  	System.out.println(createPrintStr(list[i].getName(), fileLevel)+AlterTime.format(cal.getTime()));
				  	fileLevel ++;
				  	// �ݹ���Ŀ¼
				  	readFile(list[i].getPath());
				  	fileLevel --;
			  } else {
				  	System.out.println(createPrintStr(list[i].getName(), fileLevel)+AlterTime.format(cal.getTime()));
			  }
		  }
	  }
	  public static void main(String[] args) {
	   
		  FileTree rd = new FileTree();
		  String dirPath = "D:\\MyDrivers";
		  rd.printDir(dirPath);
		  rd.readFile(dirPath);
	 }
}

