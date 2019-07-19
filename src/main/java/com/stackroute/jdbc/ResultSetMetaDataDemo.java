package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetaDataDemo {

    public void getEmployeeDetails()
    {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO", "harika", "Root@123");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from Employee");

            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getInt(1) + " Name:" + resultSet.getString(2) + " Age:" + resultSet.getString(3));
            }

            ResultSetMetaData rsmd = resultSet.getMetaData();

            //getting number of columns in 'resultSet'

            int colCount = rsmd.getColumnCount();

            System.out.println("Number Of Columns : " + colCount);

            System.out.println("column Details :");

            for (int i = 1; i <=colCount; i++)
            {
                System.out.println(rsmd.getColumnName(i) + " is of type " + rsmd.getColumnTypeName(i));

                System.out.println("Catalog Name:"+ rsmd.getCatalogName(i));

                System.out.println("Column Type: "+rsmd.getColumnType(i));

                System.out.println("Column Class Name : "+rsmd.getColumnClassName(i));
            }
        }
        catch(SQLException|ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
