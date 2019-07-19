package com.stackroute.jdbc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();

        System.out.println("=================Simple jdbc demo====================");
        System.out.println( "General Order" );
        simpleJdbcDemo.getEmployeeDetails();

        System.out.println( "Reverse Order" );
        simpleJdbcDemo.getEmployeeDetailsInReverseOrder();

        System.out.println( "From Second Row" );
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();

        System.out.println("getEmployeeDetailsByNameAndGender");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Harika","Female");

        System.out.println("=================Result Set Meta Data====================");
        ResultSetMetaDataDemo resultSetMetaDataDemo = new ResultSetMetaDataDemo();
        resultSetMetaDataDemo.getEmployeeDetails();

        System.out.println("=================Jdbc Transaction demo====================");
        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        jdbcTransactionDemo.addEmployeeDetails();

        System.out.println("=================Jdbc Batch demo====================");
        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        jdbcBatchDemo.getEmployeeDetails();

        System.out.println("=================Database MetaData demo====================");
        DatabaseMetaDataDemo databaseMetaDataDemo = new DatabaseMetaDataDemo();
        databaseMetaDataDemo.getMetaData();

        System.out.println("=================Rowset demo====================");
        RowsetDemo rowsetDemo = new RowsetDemo();
        rowsetDemo.getEmployeeDetails();
    }
}
