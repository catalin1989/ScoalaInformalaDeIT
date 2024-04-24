package week_12_jdbc;

import java.sql.*;

//This class is responsible for the establishing pf the connection.
//it has a static method that establishes the connection and returns it
public class MyConnection {


    public static Connection connect(String url) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        if (connection == null) {
            System.out.println("There is an error in the connection");

        }
        return connection;
    }


}
