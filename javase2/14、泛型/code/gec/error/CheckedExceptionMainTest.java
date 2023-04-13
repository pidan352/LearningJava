package com.gec.error;

public class CheckedExceptionMainTest {

    public static void main(String[] args) {

        //FileInputStream fileInputStream = new FileInputStream("");


    }

    public static void test1(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
