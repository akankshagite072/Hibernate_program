package com.sms.hibernate_pgm;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class RecipeAdder {
     Connection connection;

    public RecipeAdder(Connection connection) {
        this.connection = connection;
    }

    public void addRecipe(String name, String description) {
        String query = "INSERT INTO recipes (name, description) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, description);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
