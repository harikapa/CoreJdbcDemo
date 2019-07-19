package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {


    Connection connection;
    ResultSet resultSet ;
    Statement statement;

    public void getEmployeeDetails() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO", "harika", "Root@123");

            connection.setAutoCommit(false);

            statement = connection.createStatement();

            String sql = "SELECT * FROM Employee";

            statement.execute("delete from Employee where name = 'Batch Example'");

            for(int i=400; i <= 410 ;i++){

                statement.addBatch("insert into Employee values ("+i+",'Batch Example',20,'female')");
            }

            int[] result = statement.executeBatch();

            System.out.println("The number of rows inserted: "+ result.length);

            connection.commit();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String age = resultSet.getString("age");
                String name = resultSet.getString("name");
                String gender=resultSet.getString("gender");

                //Display values
                System.out.println("ID: " + id+"\t name: " + name+"\t age:"+age +"\t gender:"+gender);

            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}