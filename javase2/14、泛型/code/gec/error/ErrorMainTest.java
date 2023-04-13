package com.gec.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorMainTest {

    public static void main(String[] args) {

        int i =0;
        List<String> list = new ArrayList();
        while(true) {
            list.add(String.valueOf(i++).intern());
        }


        //digui();
        //int[] arr = new int[Integer.MAX_VALUE];

        //System.out.println(arr);

       /* StringBuilder s = new StringBuilder();

        while (true)
        {
            s.append("hello");
            //System.out.print(10);
            //int a=10;
            //System.out.println();
        }*/

    }

    public static void digui(){
        System.out.println("digui方法");
        digui();
    }
}
