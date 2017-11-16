## 基本IO操作
##### 实验内容：
从键盘接收字节流
写入到当前目录下的src.txt文件中
将src.txt文件内容复制到当前目录下dest.txt文件中
将dest.txt文件内容显示到屏幕上
##### 实验代码
<pre><code>
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
</code></pre>
##### 实验结果：
![] [https://github.com/Huangshujian/FirstGithub/blob/master/src/Image/five_1.png]

## 获取系统的文件树
##### 实验内容：
获取某个目录下的目录信息，目录从控制台输入。
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
扩展以及自学部分：利用JAVA的GUI（Swing等）创建一个简易的文件浏览器。
##### 实验代码
<pre><code>
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
	// 文件所在的层数
	  SimpleDateFormat AlterTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  Calendar cal = Calendar.getInstance();
	  private int fileLevel;
	  /**
	  * 生成输出格式
	  * @param name 输出的文件名或目录名
	  * @param level 输出的文件名或者目录名所在的层次
	  * @return 输出的字符串
	  */
	  public String createPrintStr(String name, int level) {
		  // 输出的前缀
		  String printStr = "";
		  // 按层次进行缩进
		  for (int i=0;i《level;i++) {
          //这个《表示小于号，用小书匠MarkDown编辑的md文件，不懂这个地方为什么用英文的小于号不行！！！！
			  printStr = printStr +" ";
		  }
		  printStr = printStr +"-  "+ name;
		  return printStr;
	  }
	  /**
	  * 输出初始给定的目录
	  * @param dirPath 给定的目录
	  */
	  public void printDir(String dirPath){
		  // 将给定的目录进行分割
		  String[] dirNameList = dirPath.split("\\\\");
		  // 设定文件level的base
		  fileLevel = dirNameList.length;
		  // 按格式输出
		  for (int i=0;i《dirNameList.length;i++) {
			  System.out.println(createPrintStr(dirNameList[i], i));
		  }
	  }
	  /**
	  * 输出给定目录下的文件，包括子目录中的文件
	  * @param dirPath 给定的目录
	  */
	  public void readFile(String dirPath) {
		  // 建立当前目录中文件的File对象
		  File file = new File(dirPath);
		  // 取得代表目录中所有文件的File对象数组
		  File[] list = file.listFiles();
		  // 遍历file数组
		 // AlterTime.format(cal.getTime());
		  for (int i =0 ; i 《 list.length; i++) {
			  cal.setTimeInMillis(list[i].lastModified());
			  if (list[i].isDirectory()) {
				  	System.out.println(createPrintStr(list[i].getName(), fileLevel)+AlterTime.format(cal.getTime()));
				  	fileLevel ++;
				  	// 递归子目录
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
</code></pre>
##### 实验结果：
![][https://github.com/Huangshujian/FirstGithub/blob/master/src/Image/five_2.png]


  [1]: ./images/1510745086687.jpg "1510745086687.jpg"
  [2]: ./images/1510746384783.jpg "1510746384783.jpg"
