##1.�ж�����
��дJava��������ӹ�Ԫ1990�굽2007������
�������ţ�ÿ���������Ż�һ�С��ж������
��Ϊ����������ǣ�
��1��������ܱ�4�����������ܱ�100�������������ꣻ
��2��������ܱ�400����Ҳ�����ꡣ
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
ʵ������
1992 1996
2000 2004





atx-style:
##2.�ٷ��Ƴɼ�ת��Ϊ�ȼ��ɼ�
ʵ�ַ���ToGradeScore�����ٷ��Ƴɼ�ת��Ϊ�ȼ��ɼ���Ҫ���һ�����ݣ�ʵ������ת����
�ȼ���ٷ��ƶ���
�ţ�[90,100]
����[89,80]
�У�[79,70]
����[69,60]
������[0,59]
<pre><code>

public class Translation {
	public static void main(String [] args) {
	int [] arr = new int []{100,80,50,85,91,61,59,23,69,76};
	String [] code = new String []{"����","����","��","�ϸ�","���ϸ�"};
	int [][] array = new int [5][10];       //����±�
	int [] flag = new int []{0,0,0,0,0};    //���ÿ���ȼ�����Ŀ
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
����: 100 91 
����: 80 85 
��: 76 
�ϸ�: 61 69 
���ϸ�: 50 59 23 


atx-style:
##3.��ӡͼ��
����forѭ����дһ�����򣬽�����ͼ���ֱ��ӡ��
���� 
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
			if(i>(num+1)/2) {    //�ж�ÿһ�������* ����
				k=num+1-i;
				z=i-(num+1)/2;
			}
			else {
				k=i;
				z=(num+1)/2-i;
			}	
			for(int j=1;j<=z;j++) {        //���ÿһ�еĿո�   ��ĿΪz
				System.out.print(" ");
			}
			for(int j=1;j<=(2*k-1);j++) {    //���ÿһ��*����Ŀ  ��ĿΪ��2*k-1��
				System.out.print(flag);
			}
			
			System.out.println("");
		}
	}
}		  
  </pre></code>    
  ʵ������
 <pre><code>
   *
  ***
 *****
*******
 *****
  ***
   *
  </pre></code>    


  atx-style:
##4.ˮ�ɻ���
��д�����ҳ����е�ˮ�ɻ�����ˮ�ɻ�������λ�������ĸ�λ���ֵ������͵��������λ������
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
 ʵ������   
153 370 371 407 
  </pre></code>   
  
  atx-style:
##5.Choc-O-Holic��˾��һ���ɿ�����¯���������ɿ�����ţ���ں���һ�������ɿ���������������ɿ�����¯��ΪChocolateBoiler
ChocolateBoiler������˽�еĳ�Ա������empty��bolied�������жϹ�¯�Ƿ�Ϊ�գ��Լ���¯�ڻ�����Ƿ�����С�ע��������Ա����ǡ���ĳ�ʼֵ��
private boolean empty;
private boolean boiled;
ChocolateBoiler���������������ƹ�¯�����ɿ�������
public void fill() {��} ���¯�����ɿ�����ţ�̵Ļ�������Ҫ�жϹ�¯�Ƿ�Ϊ�գ�ֻ�пյĹ�¯��������ɿ�����ţ�̣������̴�ӡһ����伴�ɣ������֮��emptyΪfalse
public void boil() {��} ��¯����С������жϱ�־λ��ֻ�й�¯�����ģ�����û����������ܽ��иò�������в�����ӡһ����伴�ɣ�����к�boiled��־λ����Ϊtrue��
public void drain() {��} �ų���е��ɿ�����ţ�̡�����Ҫ���б�־λ�жϣ�ֻ�й�¯�����ģ����ҹ�¯�Ѿ����֮�󣬲����ų������ų������Ķ�����ӡһ����伴�ɣ����ų������֮������emptyΪtrue��
isEmpty��isBoiled��������ȡempty��boiled��־λ��ֵ
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
			System.out.println("�������¯������ɿ�����ţ�̻����");
			empty = false;
		}
		else {
			System.out.println("��¯��������װʧ��");
		}
	}
	
	public void boil() {
		if(!empty && !boiled) {
			System.out.println("���ڽ���¯���");
			boiled = true;
		}
	}
	
	public void drain() {
		if(!empty && boiled) {
			System.out.println("�����ų���е��ɿ�����ţ�̻����");
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
 ʵ������   
true,false
�������¯������ɿ�����ţ�̻����
false,false
���ڽ���¯���
false,true
�����ų���е��ɿ�����ţ�̻����
true,false
  </pre></code>  
