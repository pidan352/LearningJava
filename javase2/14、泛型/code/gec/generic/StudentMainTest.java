package com.gec.generic;

/*
* 定义一个泛型类
* T：就是类型变量
* */
class Student<T>
{
    //类型变量不能作为于静态成员
    T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}

public class StudentMainTest {

    public static void main(String[] args) {

        Student<String> s1=new Student<>();
        s1.setName("xiaoming");
        System.out.println(s1.getName());

        Student<Integer> s2=new Student<>();
        s2.setName(100);
        System.out.println(s2.getName());

        //Student<int> s3=new Student<int>();
        //Student<String> s4=new Student<Integer>();

    }
}
