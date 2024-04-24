package week_12_jdbc;

import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class MyDataBaseWriterTests {
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
    private static Connection connection;

    @BeforeAll
    static void setUp() {
        try {
            connection = MyConnection.connect(url);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void tryingToInsertValidDataIntoAccommodationTableTypeTable_expectSuccess_resultSuccessfully() {
        int index = 5;
        //I know that the method returns an int, so I test if the insertion modifies 1 row. If it modifies 1 row, the return result must be 1
        int result = MyDataBaseWriter.insertIntoAccommodationTypes(connection, index, "Hotel", "Double", 4, "Beautiful two room apartment");
        assertEquals(1, result);
        //I saw that the test method inserts into the data base the data, because I don't want to constantly insert data
        //when I am running the test, and because after I insert the data once, I can't insert at the same index again
        //and the test will fail, after inserting and assertingEquals, I delete the inserted data
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM accommodation WHERE id=?")) {

            statement.setInt(1, index);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Test
    void tryingToInsertInvalidDataIntoAccommodationTableType_expectException_resultIllegalArgumentException() {
        int index = -1;
        boolean flag = false;
        try {
            int result = MyDataBaseWriter.insertIntoAccommodationTypes(connection, index, "Hotel", "Double", 4, "Beautiful two room apartment");


            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM accommodation WHERE id=?")) {

                statement.setInt(1, index);
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            flag = true;
        }
        assertTrue(flag);

    }

    @Test
    void tryingToInsertValidDataIntoRoomFair_expectSuccess_resultSuccessfully() {
        int index = 10;
        int result = MyDataBaseWriter.insertIntoRoomFair(connection, index, 200, "Winter");
        assertEquals(1, result);
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM room_fair WHERE id=?")) {
            statement.setInt(1, index);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    void tryingToInsertInvalidDataIntoRoomFair_expectedException_resultIllegalArgumentException() {
        boolean flag = false;
        int index = 10;
        double value = -200;
        try {
            int result = MyDataBaseWriter.insertIntoRoomFair(connection, index, value, "Winter");

            try (PreparedStatement statement = connection.prepareStatement("DELETE FROM room_fair WHERE id=?")) {
                statement.setInt(1, index);
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            flag = true;
        }
        assertTrue(flag);
    }


}