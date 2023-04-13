package com.gec.demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMainTest {

    public static void main(String[] args) throws ParseException {

        //dateTest();
        formatDate();

    }

    /*
    * 1、掌握Date的用法
    * */
    public static void dateTest(){

        //实例化Date对象
        //获取当前的日期时间
        Date date=new Date();

        System.out.println(date);
        System.out.println(date.getTime());

        //如何设置日期时间
        Calendar c1=Calendar.getInstance();
        //c1.set("","","","","","");
        c1.set(Calendar.YEAR,2022);
        c1.set(Calendar.MONTH,0);

        System.out.println(c1.get(Calendar.YEAR));
        System.out.println(c1.get(Calendar.MONTH)+1);

        c1.add(Calendar.DATE,20);

        //将Date---->注入到Calendar
        c1.setTime(date);


        //Calendar对象------>Date对象
        Date time = c1.getTime();


    }


    public static void formatDate() throws ParseException {
        //计算20天之后的日期数据，以yyyy-MM-dd输出
        String strDate="2022-07-27";

        //将字符串转换Date
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = sf.parse(strDate);

        //Date数据注入到Calendar类对象
        Calendar c1=Calendar.getInstance();
        c1.setTime(curDate);

        //Calendar调用add方法
        c1.add(Calendar.DATE,20);

        //将Calendar对象转换成Date
        Date afterDate = c1.getTime();

        //Date转换成字符串
        String format = sf.format(afterDate);

        System.out.println(format);

    }
}
