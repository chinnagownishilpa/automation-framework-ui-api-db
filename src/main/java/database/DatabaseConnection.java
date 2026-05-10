package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.ConfigReader;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection() {

        try {

            if (connection == null
                    || connection.isClosed()) {

                connection =
                        DriverManager.getConnection(
                                ConfigReader.get("dbUrl"),
                                ConfigReader.get("dbUsername"),
                                ConfigReader.get("dbPassword"));

                System.out.println(
                        "DATABASE CONNECTION SUCCESSFUL");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return connection;
    }
}