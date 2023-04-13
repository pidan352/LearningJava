package com.gec.error;

class Animal
{

}

class Dog extends Animal
{

}

class Cat  extends Animal
{

}

public class RuntimeExceptionMainTest {

    public static void testClassCastException(Animal animal){

        //抛出ClassCastException
        Dog d= (Dog) animal;
    }

    public static void main(String[] args) {

/*        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = input.nextInt();*/

        int a = 1;
        int b = 0;
        //ArithmeticException
        System.out.println(a/b);


    /*    Cat c=new Cat();
        testClassCastException(c);*/

     /*   //运行时异常
        String str=null;
        // NullPointerException
        System.out.println(str.length());

      *//*  int a[]={1,2,3};
        // ArrayIndexOutOfBoundsException异常
        a[3]=100;

        System.out.println(a[3]);*//*
*/





    }
}
