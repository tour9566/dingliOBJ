package object.JDBCTest;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //2.建立连接
            String url="jdbc:mysql://192.168.50.96:3306/hbnu";
            String username="jixin";
            String password="123456";
            connection = DriverManager.getConnection(url, username, password);
            //3.编写sql语句
            String sql="insert into User(id,name,age) values ('2','tom','12');";
            //4.获取执行对象
            statement = connection.createStatement();
            //5.获得执行结果
            int i = statement.executeUpdate(sql);
            System.out.println("影响的行数"+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }


    }
}
