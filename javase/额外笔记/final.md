# final

可以修饰

1. 整个类
2. 类中的若干个成员



final修饰整个类表示：该类不能被继承。一个类已经很完美了，已经不需要再定义子类来继承他了。



final可以加在方法pulic的前后都行，类就要在class前面









如果成员变量被final修饰，则它是一个常变量(不可以改变值)，必须保证**只有一个初始值**。和c的const一样

~~~JAVA
class CaoGao {
	public static void main(String[] args) {

	}
}

class  A {
	final public int i;           
									
	public A() {
		i=22;     //可以，因为创建A对象必定调用构造方法，i必定会被初始化一个值
	}
	
	public void f() {
		//i=22;    //error   i必须有值，如果不调用f方法i就没值，所以普通方法里不能改变i的值
	}
	
}
~~~

1. final修饰类中的若干属性表示该属性必须被赋值并且只能被赋一次值（默认值不能算真正的赋值）

2. 初始化的方法有两种（只能选其中一种）：是在对象创建之前赋值就行

   2.1在定义成员变量的同时初始化化

   2.2在类中所有的构造函数中初始化

   2.3静态代码块中赋值（但这里的变量也得是静态的）

   ~~~java
   class A{
   	static final int a;
   	
   	static {
   		a=1;
   	}
   	
   }
   ~~~

   2.4成员代码块

   ~~~java
   class A{
   	final int a;
   	{
   		a=1;
   	}
   	
   }
   ~~~

   

3. 一个类的所有普通方法内部都不能修改final修饰的成员变量的值.

4. 如果final修饰的是引用类型的变量，创建对象后不可以改变的是变量的值（因为这个变量存储的是地址），但变量指向的对象内的值可以改变

5. final修饰的局部变量只能赋一次值

~~~java
class A{
	public void test(){
		final int a;
		a=1;
		//a=2;   //error
	}
	
}
~~~









final修饰若干个方法

被final修饰的方法，子类可以继承，但不可以重写。