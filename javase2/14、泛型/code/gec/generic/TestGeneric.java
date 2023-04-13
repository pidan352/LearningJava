package com.gec.generic;

import java.util.Comparator;

class Person<T>{

}

// javabean标准写法
class Circle{
    //半径
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + "]";
    }
}

/*
* 实现一个比较器
* */
class CircleComparator implements Comparator<Circle>
{
    /*
    * 比较对象是否相等，可以通过compare方法实现比较的逻辑
    * 返回值>0  则o1>o2
    * 返回值=0  则o1=o2
    * 返回值<0  则o1<o2
    * */
    /*@Override
    public int compare(Object o1, Object o2) {

        //将Object转换Circle类
        Circle c1= (Circle) o1;
        Circle c2= (Circle) o2;

        return Double.compare(c1.getRadius(), c2.getRadius());
    }*/

    @Override
    public int compare(Circle c1, Circle c2) {
        return Double.compare(c1.getRadius(), c2.getRadius());
    }
}


public class TestGeneric {

    public static void main(String[] args) {

        //创建一个比较器
        CircleComparator com = new CircleComparator();

        Circle c1=new Circle(4);
        Circle c2=new Circle(2);


        System.out.println(com.compare(c1, c2));


    }
}
