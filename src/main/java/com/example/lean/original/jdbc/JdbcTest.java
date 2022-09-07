package com.example.lean.original.jdbc;

import com.example.lean.database.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class JdbcTest {
    public static void main(String[] args) {

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            // 1. 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取数据库连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning", "root", "123456");
            // 3. 定义sql
            String sql = "select * from t_user where userid = ?";
            // 4. 获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 5. 设置参数（序号从1开始）
            preparedStatement.setString(1, "111");
            // 6. 执行sql
            resultSet = preparedStatement.executeQuery();
            // 7. 遍历结果集
            while (resultSet.next()) {
                User user = User.builder().userId(resultSet.getString("userid")).userName(resultSet.getString("username")).build();
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}