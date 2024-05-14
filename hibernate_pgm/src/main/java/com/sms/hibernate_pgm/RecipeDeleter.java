package com.sms.hibernate_pgm;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RecipeDeleter {
    Connection connection;

    public RecipeDeleter(Connection connection) {
        this.connection = connection;
    }

    public void deleteRecipe(int id) {
        String query = "DELETE FROM recipes WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
