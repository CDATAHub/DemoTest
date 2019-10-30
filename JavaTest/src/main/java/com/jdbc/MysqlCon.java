package com.jdbc;

import java.sql.*;

/**
 * 1. Driver class: The driver class for the mysql database is com.mysql.jdbc.Driver.
 * <p></p>
 * 2. Connection URL: The connection URL for the mysql database is jdbc:mysql://localhost:3306/sonoo where jdbc is the API, mysql is the database,
 * localhost is the server name on which mysql is running, we may also use IP address, 3306 is the port number and sonoo is the database name.
 * We may use any database, in such case, we need to replace the sonoo with our database name.
 * <p></p>
 * 3. Username: The default username for the mysql database is root.
 * <p></p>
 * 4. Password: It is the password given by the user at the time of installing the mysql database. In this example, we are going to use root as the password.
 */
public class MysqlCon {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // manual Register JDBC driver
            // Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
            // The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
            Class.forName("com.mysql.jdbc.Driver");

            //  Open a connection
            // here sonoo is database name, root is username and password
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo?serverTimezone=GMT%2B8", "root", "Huawei@123");

            // Execute a query
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");

            // Extract data from result set
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
            System.out.println("Goodbye!");
        }//end try
    }
}
