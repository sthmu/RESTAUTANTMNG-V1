package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "rms";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() throws SQLException {
        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL server without specifying a database
            Connection initialConnection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = initialConnection.createStatement();

            // Check if the database exists, and create it if it doesn't
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME);
            statement.close();
            initialConnection.close();

            // Connect to the specified database
            this.connection = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
            System.out.println("Database connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Driver not found.", e);
        } catch (SQLException e) {
            System.err.println("Failed to create the database connection: " + e.getMessage());
            throw new SQLException("Failed to create the database connection.", e);
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        ensureConnection();
        return connection;
    }

    private void ensureConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            this.connection = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
            System.out.println("Reconnected to the database.");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Database connection closed successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to close the database connection: " + e.getMessage());
        }
    }
}