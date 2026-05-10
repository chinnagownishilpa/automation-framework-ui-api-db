package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {

    public static String getSingleData(
            String query,
            String columnName) {

        String value = null;

        try {

            Connection connection =
                    DatabaseConnection.getConnection();

            Statement statement =
                    connection.createStatement();

            ResultSet result =
                    statement.executeQuery(query);

            while (result.next()) {

                value =
                        result.getString(columnName);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return value;
    }
}