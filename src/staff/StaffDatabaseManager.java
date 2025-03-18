package staff;

import common.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDatabaseManager {
    public void createStaffTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Staff ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(255) NOT NULL, "
                + "contact VARCHAR(255) NOT NULL, "
                + "role VARCHAR(255) NOT NULL, "
                + "salary DOUBLE NOT NULL, "
                + "position VARCHAR(255) NOT NULL)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Staff table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStaff(Staff staff) {
        String insertSQL = "INSERT INTO Staff (name, contact, role, salary, position) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getContact());
            preparedStatement.setString(3, staff.getRole());
            preparedStatement.setDouble(4, staff.getSalary());
            preparedStatement.setString(5, staff.getPosition());
            preparedStatement.executeUpdate();
            System.out.println("Staff added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeStaff(String name) {
        String deleteSQL = "DELETE FROM Staff WHERE name = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Staff removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Staff> viewStaff() {
        List<Staff> staffList = new ArrayList<>();
        String selectSQL = "SELECT * FROM Staff";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String contact = resultSet.getString("contact");
                String role = resultSet.getString("role");
                double salary = resultSet.getDouble("salary");
                String position = resultSet.getString("position");
                staffList.add(new Staff(id, name, contact, role, salary, position));
            }
            System.out.println("Staff retrieved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }
}