# 1.this

~~~java
public class CaoGao {
	public static void main(String[] args) {
		A aa1=new A(10);     //创建A对象时，A的成员变量在堆中分别分配，而对于方法而言，因为
        A aa2=new A(20);     //是同一个类的方法，所有操作都一样，所以为了节省空间，方法只创建
        					//一次并存放在方法区的。那show()是如何辨别是那个对象调用的呢
        					//调用show时，哪个对象调用就输出哪个对象里的值，那是如何实现的
		aa1.show();   //aa1.show(aa1);
        aa2.show();	  //aa2.show(aa2);
	}
							//执行aa1.show(aa1);时把aa1的值发给this，那么this就指向了
}							//aa1，使用(*this).i就能实现哪个对象调用show()就输出哪个对象
							//的i
class A{				    
	public int n;			
	
	public A(int n) {		//注意，非静态方法中才有这个隐藏的this
		this.n=n;			//为什么是非静态看static
	}
	
	public void show() {           //public void show(A * this){
		System.out.println(n);	   //		System.out.println((*this).i);
	}							  //}
}
~~~



