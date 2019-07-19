package com.stackroute.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {

    Connection connection;

    public void addEmployeeDetails() {



        String insertTableSQL = "insert into Employee values(?,?,?,?)";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO", "harika", "Root@123");

            PreparedStatement preparedStatementInsert = connection.prepareStatement(insertTableSQL);

            connection.setAutoCommit(false);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter values to insert into table : Id, Name, Age, Gender");

            int id = scanner.nextInt();

            String name = scanner.nextLine();

            int age = scanner.nextInt();

            String gender = scanner.next();

            PreparedStatement preparedStatementUpdate = connection.prepareStatement("update Employee set age = 27 where name = 'harika'");

            preparedStatementUpdate.executeUpdate();

            System.out.println("Updated!!!");

            preparedStatementInsert = connection.prepareStatement(insertTableSQL);
            preparedStatementInsert.setInt(1, id);
            preparedStatementInsert.setString(2, name);
            preparedStatementInsert.setInt(3, age);
            preparedStatementInsert.setString(4,gender);
            preparedStatementInsert.executeUpdate();

            connection.commit();

            System.out.println("Done!");

        } catch (SQLException | ClassNotFoundException e) {

            System.out.println(e.getMessage());

            try {
                System.out.println("Connection Rollback done!!!!");
                connection.rollback();

            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }
        finally {

            try {

                connection.close();

            }
            catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }
}
