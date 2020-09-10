package com.spring;

import java.sql.*;

/**
 * @author zxk
 * @create 2020/9/9 - 20:00
 */
public class jdbsdemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("成功登录mysql");
        //3.获取数据库连接对象     //系统时间错误?serverTimezone=GMT%2B8
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm","root","123456");


        System.out.println("成功登录服务器");
        //4.定义sql语句
        String sql="select money from account where name='aaa'";
        //5.获取执行sql对象 Statement
        Statement stm=conn.createStatement();
        //6.执行sql语句
        ResultSet resultSet = stm.executeQuery(sql);
//        int count=stm.executeUpdate(sql);
//        //7.处理结果
//        System.out.println(count);
        System.out.println("resultSet = " + resultSet);
        while(resultSet.next()==true) {


            System.out.println(resultSet.getInt("money"));
        }
        //8.释放资源
        stm.close();
        conn.close();
    }
}
