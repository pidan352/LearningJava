package com.gec.bookinfo.utils;

import java.sql.*;

/*
* 提供数据库连接对象的工具类
*
* ThreadLocal
*
* */
public class DbUtils {

    public final static String URL="jdbc:mysql://localhost:3306/gecdb?serverTimezone=UTC";
    public final static String USER="root";
    public final static String PASS="1111";

    //定义一个Connection对象
    private static Connection connection=null;

    static {
        //一般在静态初始化块，将驱动加载到内存
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //创建Connection对象
    public static Connection openConn() throws SQLException {

        //判断当前connection对象是否为空，如果为空，则创建新的Connection对象
        //如果不为空，则直接返回此对象
        if(connection==null){
            connection= DriverManager.getConnection(URL,USER,PASS);
        }

        return connection;
    }


    //关闭Connection对象
    public static void closeConn(Statement statement, ResultSet rs,Connection conn) throws SQLException {

        if(rs!=null){
            rs.close();
        }

        if(statement!=null){
            statement.close();
        }

        if(conn!=null){
            conn.close();
        }
    }
}
