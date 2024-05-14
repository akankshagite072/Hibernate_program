package com.sms.hibernate_pgm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecipeUpdater {
    private Connection connection;

    public RecipeUpdater(Connection connection) {
        this.connection = connection;
    }

    public void updateRecipe(int id, String name, String description) {
        String query = "UPDATE recipes SET name = ?, description = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating recipe: " + e.getMessage());
        }
    }
}
