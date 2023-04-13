package com.gec.demo1;

public class MainTest {

    public static void main(String[] args) {

        String message="    hello    world    ";

        //获取头部空格结果位置
        int start=0;
        //正向遍历
        for (int i=0;i<message.length();i++){

            char c=message.charAt(i);
            if(c==' '){
                start++;
            }else
                break;
        }

        //System.out.println(start);

        //获取尾部空格位置
        //反向遍历
        int end = message.length()-1;
        for(int i=end;i>=0;i--){
            char c=message.charAt(i);
            if(c==' '){
                end--;
            }else
                break;
        }

        System.out.println("start="+start);
        System.out.println("end="+end);
        String result = message.substring(start,end+1);
        System.out.println(result);

    }
}
