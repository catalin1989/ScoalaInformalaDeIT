package week_12_jdbc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week_10_java_8.MyReader;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MyDataBaseReaderTest {
    static Connection connection;
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

    @BeforeAll
    static void setUp() {
        try {
            connection = MyConnection.connect(url);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void readingAllTheRoomPricesFromTheDataBase_expectedSuccess_resultSuccessfully() {
        //As I mentioned in the class, this method has an int printedLines with initial value to 0. This increments
        //every time I print a line with data. This test asserts if there are printed lines, this means that the query is correct
        int result = MyDataBaseReader.getAllThePricesForAllTheRoomsInTheDataBase(connection);
        assertNotEquals(0, result);

    }


    @AfterAll
    static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}