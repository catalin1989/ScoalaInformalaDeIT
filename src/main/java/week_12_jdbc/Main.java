package week_12_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
//I tried to respect the single responsibility principle, this is the reason I created the MyConnection,
// MyDatabaseReader and MyDataBaseWriter classes. I saw them as utility classes, this is why they're methods
//are static. To make sure that the uses resources are closed, I used a lot of try-with-resources.

public class Main {
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


    public static void main(String[] args) throws SQLException {

        try (Connection connection = MyConnection.connect(url)) {
            //I inserted all the data into the tables using these methods. Because I don't want to double the data
            //when I was testing different methods, after I inserted the data, I commented the method.
          /*  MyDataBaseWriter.insertIntoAccommodationTypes(connection, 1, "Private apartment", "double bed", 2, "A beautifully one room apartment near the historical center of Cluj-Napoca ");
            MyDataBaseWriter.insertIntoAccommodationTypes(connection, 2, "Hotel", "Single Bed", 1, "One bed room in our Hotel in Poiana Brasov");
            MyDataBaseWriter.insertIntoAccommodationTypes(connection, 3, "Hotel", "Double bed", 2, "A room with a double bed");
            MyDataBaseWriter.insertIntoAccommodationTypes(connection, 4, "Pensiune", "Single bed", 2, "A room fitted with two single beds.");
            MyDataBaseWriter.insertIntoRoomFair(connection, 1, 200, "Winter");
            MyDataBaseWriter.insertIntoRoomFair(connection, 2, 250, "Summer");
            MyDataBaseWriter.insertIntoRoomFair(connection, 3, 180, "Fall");
            MyDataBaseWriter.insertIntoRoomFair(connection, 4, 220, "Spring");
            MyDataBaseWriter.insertIntoRoomFair(connection, 5, 230, "All seasons");
            MyDataBaseWriter.insertIntoRoomFair(connection, 6, 300, "Winter");
            MyDataBaseWriter.insertIntoRoomFair(connection, 7, 350, "Summer");
            MyDataBaseWriter.insertIntoRoomFair(connection, 8, 380, "Fall");
            MyDataBaseWriter.insertIntoRoomFair(connection, 9, 320, "Spring");
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 1, 1, 1);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 2, 1, 2);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 3, 2, 1);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 4, 2, 2);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 5, 2, 3);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 6, 2, 4);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 7, 3, 6);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 8, 3, 7);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 9, 3, 8);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 10, 3, 9);
            MyDataBaseWriter.insertIntoAccommodationRoomFairRelation(connection, 11, 4, 5);*/
            // MyDataBaseReader.getRoomPriceByAccommodationId(connection,1);
            MyDataBaseReader.getAllThePricesForAllTheRoomsInTheDataBase(connection);
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
