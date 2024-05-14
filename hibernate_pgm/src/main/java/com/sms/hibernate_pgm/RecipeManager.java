package com.sms.hibernate_pgm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RecipeManager {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe_db", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RecipeAdder recipeAdder = new RecipeAdder(connection);
        RecipeUpdater recipeUpdater = new RecipeUpdater(connection);
        RecipeDeleter recipeDeleter = new RecipeDeleter(connection);
        RecipeGetter recipeGetter = new RecipeGetter(connection);

        recipeAdder.addRecipe("Pasta Carbonara", "Classic Italian pasta dish with bacon, eggs, and cheese.");
        recipeAdder.addRecipe("Chicken Curry", "Spicy Indian chicken curry with aromatic spices.");

        recipeGetter.getRecipe(1);

        recipeUpdater.updateRecipe(1, "Updated Pasta Carbonara", "New description");

        recipeGetter.getRecipe(1);

        recipeDeleter.deleteRecipe(2);

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
