package week_12_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//This class is responsible for inserting data into the data base
public class MyDataBaseWriter {
    //this method inserts data into the accommodation table
    //for testing purposes, I saw that the preparedStatement.executeUpdate() returns an int
    //that is represented by the number of rows that are modified, this is why I want the method
    //to return the result of the executeUpdate()

    public static int insertIntoAccommodationTypes(Connection connection, int index, String type, String bedType, int maxGuest, String description) {
        if (index < 0 || maxGuest < 0) {
            throw new IllegalArgumentException("You have a problem with the index or maxGuest. This fields can't be negative");
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accommodation values(?,?,?,?,?)")) {

            preparedStatement.setInt(1, index);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, bedType);
            preparedStatement.setInt(4, maxGuest);
            preparedStatement.setString(5, description);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //this method insert data into the room_fair table
    public static int insertIntoRoomFair(Connection connection, int id, double value, String season) {
        if (id < 0 || value < 0) {
            throw new IllegalArgumentException("You have a problem with the index or value. This fields can't be negative");
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO room_fair values(?,?,?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setDouble(2, value);
            preparedStatement.setString(3, season);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //this method insert data into the accommodation_room_fair_relation
    public static void insertIntoAccommodationRoomFairRelation(Connection connection, int id, int accomodationId, int roomFairId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO accommodation_room_fair_relation values(?,?,?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, accomodationId);
            preparedStatement.setInt(3, roomFairId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
