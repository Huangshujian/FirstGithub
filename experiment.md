## 1.判断闰年
编写Java程序，输出从公元1990年到2007年所有
闰年的年号，每输出两个年号换一行。判断年号是
否为闰年的条件是：
（1）若年号能被4整除，而不能被100整除，则是闰年；
（2）若年号能被400整除也是闰年。
<pre><code>
public class Years {
	public static void main(String [] args) {
		int num=0;
		for(int i=1990;i<=2007;i++) {
			if(i%4==0&&i%100!=0||i%400==0) {
				System.out.print(i+" ");
				num++;
				if(num%2==0) {
					System.out.println("");
				}
			}	
		}	
	}
}
</pre></code>
实验结果：
1992 1996
2000 2004



#nihao 





## 2.百分制成绩转化为等级成绩
实现方法ToGradeScore，将百分制成绩转化为等级成绩。要求对一组数据，实现批量转化。
等级与百分制对照
优：[90,100]
良：[89,80]
中：[79,70]
及格：[69,60]
不及格：[0,59]
<pre><code>

public class Translation {
	public static void main(String [] args) {
	int [] arr = new int []{100,80,50,85,91,61,59,23,69,76};
	String [] code = new String []{"优秀","良好","中","合格","不合格"};
	int [][] array = new int [5][10];       //存放下标
	int [] flag = new int []{0,0,0,0,0};    //存放每个等级的数目
	for(int i=0;i<10;i++) { 
		int k=arr[i]/10;
		switch(k) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:	
			array[4][flag[4]]=i;
			flag[4]++;
			break;
		case 6:
			array[3][flag[3]]=i;
			flag[3]++;
			break;
		case 7:
			array[2][flag[2]]=i;
			flag[2]++;
			break;
		case 8:
			array[1][flag[1]]=i;
			flag[1]++;
			break;
		case 9:
		case 10:
			array[0][flag[0]]=i;
			flag[0]++;
			break;
		}
	}
	for(int i=0;i<5;i++) {
		System.out.print(code[i]+": ");
		for(int j=0;j<flag[i];j++) {
			System.out.print(arr[array[i][j]]+" ");
		}
		System.out.println("");
	}
	
  }
}
</pre></code>
优秀: 100 91 
良好: 80 85 
中: 76 
合格: 61 69 
不合格: 50 59 23 



## 3.打印图案
利用for循环编写一个程序，将如下图案分别打印输
出。 
<pre><code>
    *
  ***
 *****
*******
 *****
  ***
   *
  </pre></code>    
  <pre><code>
   public class Picture {
	public static void main(String [] args) {
		int num=7,k,z=0;
		char flag='*';
		for(int i=1;i<=num;i++) {
			if(i>(num+1)/2) {    //判断每一行输入的* 个数
				k=num+1-i;
				z=i-(num+1)/2;
			}
			else {
				k=i;
				z=(num+1)/2-i;
			}	
			for(int j=1;j<=z;j++) {        //输出每一行的空格   数目为z
				System.out.print(" ");
			}
			for(int j=1;j<=(2*k-1);j++) {    //输出每一行*的数目  数目为（2*k-1）
				System.out.print(flag);
			}
			
			System.out.println("");
		}
	}
}		  
  </pre></code>    
  实验结果：
 <pre><code>
   *
  ***
 *****
*******
 *****
  ***
   *
  </pre></code>    


## 4.水仙花数
编写程序找出所有的水仙花数；水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。
 <pre><code>
public class Fower {
	public static void main(String [] args) {
		int a,b,c;
		for(int i=100;i<=999;i++) {
			a=i/100;
			b=(i/10)%10;
			c=(i%100)%10;
			if(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)==i)
				System.out.print(i+" ");
		}		
	}
}
  </pre></code> 
 实验结果：   
153 370 371 407 
  </pre></code>   
  
  atx-style:
##5.Choc-O-Holic公司有一个巧克力锅炉，用来把巧克力和牛奶融合在一起生产巧克力棒。定义这个巧克力锅炉类为ChocolateBoiler<br>
ChocolateBoiler有两个私有的成员变量，empty和bolied，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸。注意两个成员变量恰当的初始值<br>
private boolean empty;<br>
private boolean boiled;<br>
ChocolateBoiler有三个方法来控制锅炉生产巧克力棒。<br>
public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。<br>
填充之后empty为false<br>
public void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true。<br>
public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。<br>
isEmpty和isBoiled方法来获取empty和boiled标志位的值<br>
 <pre><code>
public class Chocolate {
	private static Chocolate onlyChocolate;
	private boolean empty;
	private boolean boiled;
	private Chocolate() {
		empty = true;
		boiled =false;
	}
	public static Chocolate getChocolate() {
		if(onlyChocolate == null) {
			onlyChocolate = new Chocolate();
		}
		return onlyChocolate;
	}
	
	public void fill() {
		if(empty) {
			System.out.println("正在向锅炉中添加巧克力和牛奶混合物");
			empty = false;
		}
		else {
			System.out.println("锅炉已满，填装失败");
		}
	}
	
	public void boil() {
		if(!empty && !boiled) {
			System.out.println("正在将锅炉煮沸");
			boiled = true;
		}
	}
	
	public void drain() {
		if(!empty && boiled) {
			System.out.println("正在排出煮沸的巧克力和牛奶混合物");
			boiled = false;
			empty = true;
		}
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return empty;
	}
	
	public boolean isBoiled() {
		// TODO Auto-generated method stub
		return boiled;
	}
}

public class Main {
	public static void main(String[] args) {
		
		Chocolate a =Chocolate.getChocolate();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.fill();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.boil();
		System.out.println(a.isEmpty()+","+a.isBoiled());
		a.drain();
		System.out.println(a.isEmpty()+","+a.isBoiled());
	}
}
  </pre></code>   
 实验结果：   
true,false<br>
正在向锅炉中添加巧克力和牛奶混合物<br>
false,false<br>
正在将锅炉煮沸<br>
false,true<br>
正在排出煮沸的巧克力和牛奶混合物<br>
true,false<br>
  </pre></code>  
