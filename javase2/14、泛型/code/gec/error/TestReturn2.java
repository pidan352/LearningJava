package com.gec.error;

public class TestReturn2 {

    public static void main(String[] args) {
        int result = test("a");
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
            return 0;
        }
    }
}
