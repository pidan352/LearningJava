package com.gec.error;

/*
* 默认是编译时异常
* */
class MyException extends Exception{

    public MyException(String message) {
        super(message);
    }

}

/*
* 运行时异常
* */
class MyRunTimeException extends RuntimeException{

    public MyRunTimeException(String message) {
        super(message);
    }
}



public class CustomExcepton {

    public static void main(String[] args) {

        try {
            testMyException(-100);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void testMyRunTimeException(int a){

        if(a<0){
            throw new MyRunTimeException("抛出自定义RuntimeException");
        }

    }

    public static void testMyException(int a) throws MyException{

        if(a<0){
            throw new MyException("抛出自定义MyException");
        }
    }
}
