package inventory;

import common.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventoryDatabaseManager {
    public void createInventoryItemTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS InventoryItem ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(255) NOT NULL, "
                + "quantity INT NOT NULL, "
                + "price DOUBLE NOT NULL,"
                + "unit VARCHAR(20) NOT NULL, "
                + "expireDate DATE NOT NULL)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("InventoryItem table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addItem(InventoryItem item) {
        String insertSQL = "INSERT INTO InventoryItem (name, quantity, price,unit, expireDate) VALUES (?, ?, ?,?, ?)";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, item.getQuantity());
            preparedStatement.setDouble(3, item.getPrice());
            preparedStatement.setString(4, item.getUnit().name());
            preparedStatement.setDate(5, Date.valueOf(item.getExpireDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeItem(String name) {
        String deleteSQL = "DELETE FROM InventoryItem WHERE name = ?";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println("Item removed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<InventoryItem> viewItems() {
        List<InventoryItem> items = new ArrayList<>();
        String selectSQL = "SELECT * FROM InventoryItem";

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                Unit unit = Unit.valueOf(resultSet.getString("unit"));
                LocalDate expireDate = resultSet.getDate("expireDate").toLocalDate();
                items.add(new InventoryItem(id,name, quantity, price,unit, expireDate));

                System.out.println();
            }
            System.out.println("Items retrieved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}