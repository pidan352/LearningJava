package com.gec.error;

public class TryCatchMainTest {

    public static void main(String[] args) {

        //String ----> int
        try
        {
            int a=Integer.parseInt(args[0]);
            int b=Integer.parseInt(args[1]);
            int c=a/b;
            //程序退出
            System.exit(0);
        }catch (NullPointerException e){
            System.out.println("空引用对象异常");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界异常");
        }catch (ArithmeticException e){
            System.out.println("算术异常");
        }catch (RuntimeException e){
            System.out.println("运行时异常");
        }catch (Exception e){
            System.out.println("发生异常");
        }finally {
            System.out.println("释放资源....");
        }


      /*  try {
            int a = 10 / 0;
        }catch (ArithmeticException e){
            System.out.println("算术异常 分母不能为0");
        }catch (Exception e){
            System.out.println("输出异常");
        }*/


    }
}
