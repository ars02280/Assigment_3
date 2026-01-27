package repository;

import config.DatabaseConnection;
import exception.DatabaseOperationException;
import exception.ResourceNotFoundException;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepository {

    public Category getById(int id) {
        String sql = "SELECT * FROM categories WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (!rs.next())
                throw new ResourceNotFoundException();

            return new Category(
                    rs.getInt("id"),
                    rs.getString("name")
            );

        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }
}
