package week_12_jdbc;

import java.sql.*;

//This class is responsible for reading data from the data base
public class MyDataBaseReader {

    //This method gives us the prices of the room of a specific accommodation, based on the accommodation id
    public static void getRoomPriceByAccommodationId(Connection connection, int accommodationId) {
        if (accommodationId < 0) {
            throw new IllegalArgumentException("You can't have a negative number as an id");
        }
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT accommodation_room_fair_relation.accommodation_id, " +
                     "accommodation_room_fair_relation.room_fair_id, room_fair.value, room_fair.season, " +
                     "accommodation.type,accommodation.bed_type, accommodation.max_guest, accommodation.description FROM " +
                     "accommodation_room_fair_relation JOIN room_fair ON accommodation_room_fair_relation.room_fair_id=room_fair.id " +
                     "LEFT JOIN accommodation ON accommodation_room_fair_relation.accommodation_id=accommodation.id WHERE " +
                     "accommodation_room_fair_relation.accommodation_id=" + accommodationId + ";")) {
            boolean hasResult = resultSet.next();
            final String format1 = "%10s%9s%10s%10s%10s              %10s  %10s         %s\n";
            final String format2 = "%10s%9s%15s%10s     %15s   %10s%5s         %s\n";
            if (hasResult) {
                System.out.printf(format1, "Accommodation Id", " Room Id", "value", "Season", "Type", "Bed Type", "Max guest", "Description");
                do {
                    System.out.printf(format2,
                            resultSet.getString("accommodation_id"),
                            resultSet.getString("room_fair_id"),
                            resultSet.getDouble("value"),
                            resultSet.getString("season"),
                            resultSet.getString("type"),
                            resultSet.getString("bed_type"),
                            resultSet.getInt("max_guest"),
                            resultSet.getString("description"));
                }
                while (resultSet.next());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //This method shows us all the room prices from all the accommodations
    //For the purpose of easy testing, I created a field printedLines which
    //increments each time a line is printed
    public static int getAllThePricesForAllTheRoomsInTheDataBase(Connection connection) {
        int printedLines = 0;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT accommodation_room_fair_relation.accommodation_id, " +
                     "accommodation_room_fair_relation.room_fair_id, room_fair.value, room_fair.season, accommodation.type," +
                     "accommodation.bed_type, accommodation.max_guest, accommodation.description FROM accommodation_room_fair_relation " +
                     "JOIN room_fair ON accommodation_room_fair_relation.room_fair_id=room_fair.id LEFT JOIN accommodation ON " +
                     "accommodation_room_fair_relation.accommodation_id=accommodation.id;")) {
            boolean hasResult = resultSet.next();
            final String format1 = "%10s%9s%10s%10s%10s              %10s  %10s         %s\n";
            final String format2 = "%10s%9s%15s%10s     %15s   %10s%5s         %s\n";
            if (hasResult) {
                System.out.printf(format1, "Accommodation Id", " Room Id", "value", "Season", "Type", "Bed Type", "Max guest", "Description");
                do {
                    System.out.printf(format2,
                            resultSet.getString("accommodation_id"),
                            resultSet.getString("room_fair_id"),
                            resultSet.getDouble("value"),
                            resultSet.getString("season"),
                            resultSet.getString("type"),
                            resultSet.getString("bed_type"),
                            resultSet.getInt("max_guest"),
                            resultSet.getString("description"));
                    printedLines++;
                }
                while (resultSet.next());
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return printedLines;
    }

}
