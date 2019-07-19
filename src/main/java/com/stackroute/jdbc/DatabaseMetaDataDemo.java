package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetaDataDemo {

    private Connection connection = null;
    ResultSet resultSet;

    public void getMetaData()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO", "harika", "Root@123");

            DatabaseMetaData dbmd= connection.getMetaData();

            System.out.println("Driver Name: "+dbmd.getDriverName());
            System.out.println("Driver Version: "+dbmd.getDriverVersion());
            System.out.println("UserName: "+dbmd.getUserName());
            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
            System.out.println("Database transaction or not:"+dbmd.dataDefinitionCausesTransactionCommit());
            System.out.println("colum index:"+dbmd.getMaxColumnsInIndex());

            String table[]={"TABLE"};
            resultSet =dbmd.getTables("office",null,null,table);
            while(resultSet.next()){
                for(int i =0; i<resultSet.getMetaData().getColumnCount(); i++)
                System.out.println(resultSet.getString(i));
            }

            resultSet =dbmd.getColumns(null,null,"Employee",null);
            while ((resultSet.next())){
                String columnName = resultSet.getString("COLUMN_NAME");
                String datatype = resultSet.getString("DATA_TYPE");
                System.out.println(columnName+" "+datatype+" ");
            }

            connection.close();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
