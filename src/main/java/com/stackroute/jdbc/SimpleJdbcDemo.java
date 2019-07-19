package com.stackroute.jdbc;

import java.sql.*;

public class SimpleJdbcDemo {

    private Connection connection;

    private Statement statement;

    private ResultSet resultSet;

    public SimpleJdbcDemo()
    {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO", "harika", "Root@123");

            statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void getEmployeeDetails()
    {
        try
        {
            resultSet = statement.executeQuery("select * from Employee");

            while (resultSet.next())
            {
                System.out.println("Id:"+ resultSet.getInt(1) + " Name:" + resultSet.getString(2) + " Age:" + resultSet.getString(3));
            }
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public void getEmployeeDetailsInReverseOrder()
    {
        try
        {
            resultSet = statement.executeQuery("select * from Employee");

            resultSet.afterLast();

            while (resultSet.previous())
            {
                System.out.println(" "+ resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void getEmployeeDetailsFromSecondRowInReverse()
    {
        try
        {
            resultSet = statement.executeQuery("select * from Employee");

            resultSet.absolute(2);

            while (resultSet.previous())
            {
                System.out.println(" "+ resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void getEmployeeDetailsByNameAndGender(String name,String gender)
    {
        try
        {
            resultSet = statement.executeQuery("select * from Employee where name = '"+name+"' and gender='"+gender+"'");

            while (resultSet.next())
            {
                System.out.println(" "+ resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }
        }
        catch (SQLException e) {

            e.printStackTrace();
        }
    }

}
