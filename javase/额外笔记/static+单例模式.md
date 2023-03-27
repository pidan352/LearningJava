# static

~~~java
public class CaoGao {
	public static void main(String[] args) {
	A aa1=new A();
	A aa2=new A();
	A aa3=new A();
	
	aa1.a=20;                
	aa2.show();                   //20
	System.out.println(aa3.a);    //20
	
	}
}

class A{
    public static int a=10;      //aa2和aa3的a都是输出20，说明static的成员变量在创建对象								  //时只有一个
    							 //无论创建多少个A对象，他们都共用一个a变量
    public void show() {		 //这时创建对象时，a变量就不是存放在堆中了，而是在(方法和数
    	System.out.println(a);	 //据共享区？)
    }
}
~~~

那这个a是属于对象的还是属于类的

~~~java
public class CaoGao {
	public static void main(String[] args) {
		System.out.println(A.a);     //10
	
	}
}

class A{
  public static int a=10;     //如果没有static编译失败
    
}
~~~

可以看出，没有new出对象也能**直接通过类名使用**a，所以静态变量是属于类本身的

同样的，静态的方法也一样



对象是用类造出来的，所以静态成员被类的所有对象所共有，可以通过类对象名访问



最终能否去访问还需结合访问控制符判断，如果静态方法是private的，那么将不能通过类名访问



只有**非private的static的成员**才可以通过类名的方式访问







~~~java
public class CaoGao {
	public static void main(String[] args) {
       // A.f();     //error    
		A aa=new A();
		aa.g();						//ffff
									//gggg
        							//10
	}
}

class A{
  public static int a=10;     
    
  public static void f() {
      //g();    //error
	  System.out.println("ffff");
  }
  
  public static void g() {
	  f();
	  System.out.println("gggg");
      System.out.println(a)
  }
  
}
//证明了非静态方法可以访问静态成员
//静态方法不能访问非静态成员，因为静态方法可以直接通过类名使用，但这个时候没有对象，那么就会出错
~~~

 

静态成员是类本身具有的东西，那么用类造出的对象也具有静态成员（只是所有对象共用同一个静态变量），所以对象的非静态方法可以访问静态成员。

静态成员可以直接通过类名直接访问而不用创建对象，这时没有对象，无法访问非静态成员，所以静态的方法不能访问非静态的成员。







## 求生成对象的个数

如何计算生成对象的值？    生成一个对象都要调用一次构造方法，那就可以在调用构造方法时用一个变量来计数

因为这个数只用一个就行，不用每个对象都有，所以是静态的

因为不能让外部去直接访问他，所以是private的。

~~~java
public class CaoGao {
	public static void main(String[] args) {
		A aa1 = new A();
		A aa2 = new A(10);
		A aa3 = new A();

		System.out.println(aa1.getcount());
	}
}

class A {
	public int i;
	private static int a = 0;

	public A() {
		a++;
	}

	public A(int i) {
		this.i = i;
		a++;
	}

	// 返回生成了A对象的个数
	public int getcount() {
		return a;
	}

}
~~~







## 只生成一个对象

将构造方法设为private就禁止new对象了

不能new那对象如何生成？是否可以在类中先生成一个对象？然后提供一个方法来使用对象，测试如下：

~~~java
class CaoGao {
	public static void main(String[] args) {

	}
}

class A {
	public int a;
	A aa=new A();	//aa是否是A的属性？
	
	private A() {
		
	}

}
~~~

可以在类中定义对象，问题来了，a是A的属性，那aa是否是A的属性？先另外看一段代码

~~~java
class CaoGao {
	public static void main(String[] args) {
		B bb=new B();
		bb.g();
	}
}

class A { 
	public void f() {
		System.out.println("hh");
	}
}

class B{
	public int i=10;
	public A aa=new A();
	
	public void g() {
		aa.f();
	}
}
~~~

成功，可以证明：

一个类的属性可以是个类对象。一个事物包含了另外一个事物，例如一辆汽车包含有发动机



回到第一块代码，已证明aa是A的属性，还有一个问题，可以定义一个自身对象吗

运行成功，可以

可以的话，内存是如何分配的，正常来看岂不是一直套娃在new A对象？

这里可以参考c语言里的结构体来理解，相当于在结构体里定义了一个结构体指针来指向本身。



~~~java
class CaoGao {
	public static void main(String[] args) {
		A aa1=A.getA();
        A aa2=A.getA();
        aa1.a=99;
        System.out.println(aa2.i);		//99
		
	}
}

class A {
	public int a=10;
	private static A aa=new A();	//static不能省
	
	private A() {
		
	}

	public static A getA() {		//static不能省
		return aa;
	}
	
	
}
~~~

这里定义一个getA方法来是外部能获取一个A类的对象，这样就实现了只能生成一个类的对象，并且这个对象和正常new出的对象一样

注意：因为设置了无法new出对象，所以getA方法**必须是静态的**，否则外部无法访问。而getA需要返回aa对象，所以aa也**必须是静态的**，否则getA方法无法访问aa



### 只用一个对象：单例模式

核心**思想**：

一个类只能创建一个对象

思考：用我们所学的知识，怎样可以达到这个要求。、

分析：

   1.一个类如果只能创建一个对象，则可以把这个类由自己创建，不准别人创建

不准别人创建：将构造器私有化，外部就无法创建

2. 自己来创建这个对象

3. 自己创建一个对象后如果这个对象别人不能使用，就没有意义，所以对外提供一个访问这个对象的方法

实现步骤：

1. 将构造器私有化

2. 创建一个对象

3. 提供一个静态方法供外部访问

且提供给外部访问对象的方法有一个行业规范，都是叫getInstance方法



上面这种叫饿汉式

还有一种单例模式叫懒汉式

~~~java
class CaoGao {
	public static void main(String[] args) {
		A aa1=A.getA();
        A aa2=A.getA();
        aa1.a=99;
        System.out.println(aa2.i);		//99
		
	}
}

class A {
	public int a=10;
	private static A aa;
	
	private A() {
		
	}

	public static A getInstance() {
		if(aa == null){
            aa = new A();
        }
        return aa;
	}
	
	
}
~~~

开发中选择饿汉式，因为懒汉式有可能出现线程不安全的问题，不能保证一定是创建了一个对象



解决懒汉式的线程安全问题：使用同步关键字

~~~java
public static synchronized A getInstance()
~~~



单例模式用的也少，后续学习的枚举可以解决单例模式的问题



## 总结

在静态方法里只能直接访问同类中其他的静态成员，而不能访问类中的非静态成员。这是因为，对于非静态成员，需要先创建对象后才能使用，而静态方法在使用前不用创建对象。



静态方法不能一任何形式调用this和super关键字。因为静态方法在使用前不用创建对象，当静态方法调用时，this没有指向的对象。



非静态方法可以访问类中所有成员，包括静态成员



静态成员保存在方法区的静态区，不随对象进入堆内存





# 静态常量

开发中，在类中要定义一个静态常量，通常使用public static final修饰。此时变量名全部大写，多个单词使用下划线连接。



接口中的成员变量默认都是使用public static final修饰，即接口中的变量都是常量。由于接口没有构造方法，所以必需显示赋值，可以直接用接口名访问。