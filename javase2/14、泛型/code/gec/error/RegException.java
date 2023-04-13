package com.gec.error;

/*
* 此异常类针对注册信息
* */
class RegisterException extends Exception{
    public RegisterException(String message) {
        super(message);
    }
}

public class RegException {

    // 模拟数据库中已存在账号
    private static String[] names = {"bill","hill","jill"};

    public static void main(String[] args) {

        try {
            checkUsername("hill");
            System.out.println("注册成功");
        }catch (RegisterException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkUsername(String uname) throws RegisterException{

        for (String name : names) {

            if(name.equals(uname))
            {
                //抛出异常
                throw new RegisterException("亲"+name+"已经被注册了！");
            }
        }

        return true;
    }
}
