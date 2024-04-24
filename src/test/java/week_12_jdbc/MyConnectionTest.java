package week_12_jdbc;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MyConnectionTest {
    private static final String url = new StringBuilder()
            .append("jdbc:")
            .append("postgresql")
            .append("://")
            .append("localhost")
            .append(":")
            .append("1111")
            .append("/")
            .append("booking")
            .append("?user=")
            .append("postgres")
            .append("&password=")
            .append("catalin").toString();
    private Connection connection;

    @Test
    void tryingToConnectToTheDataBase_expectedSuccess_ResultSuccessfully() {
        boolean flag = false;
        try {
            connection = MyConnection.connect(url);
        } catch (SQLException e) {
            System.out.println(e);
            flag = true;
        }
        assertFalse(flag);
        assertNotNull(connection);
    }

    @AfterEach
    void closeTheConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}