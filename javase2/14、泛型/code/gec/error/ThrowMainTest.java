package com.gec.error;

public class ThrowMainTest {

    public static void main(String[] args) {

        try {
            login("rose","1111");
        }catch (Exception e){
            System.out.println("登录名及密码输入不对！");
        }


    }

    public static void login(String loginname,String password) throws Exception
    {
        //登录名及密码，如果登录失败，则抛出异常对象
        if(!loginname.equals("tom") || !password.equals("1111")){
            //抛出异常对象(Exception默认抛出CheckException异常)
            throw new Exception("登录信息不对！");
        }
    }
}
