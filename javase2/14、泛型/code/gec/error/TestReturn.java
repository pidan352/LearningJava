package com.gec.error;

public class TestReturn {

    public static void main(String[] args) {
        int result = test("hellojava");
        System.out.println(result);
    }

    public static int test(String str){
        try{
            Integer.parseInt(str);
            return 1;
        }catch(NumberFormatException e){
            return -1;
        }finally{
            System.out.println("test结束");
        }
    }
}
