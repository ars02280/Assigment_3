package repository;

import config.DatabaseConnection;
import model.Product;
import model.Category;
import model.Game;
import model.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public Product create(Product product) {
        String sql = "INSERT INTO products(name, price, type, category_id) VALUES(?, ?, ?, ?) RETURNING id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setString(3, product.getType());          // <- вот сюда
            stmt.setInt(4, product.getCategory().getId());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product.setId(rs.getInt("id"));
            }

            return product;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, price = ?, category_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getCategory().getId());
            stmt.setInt(4, product.getId());  // <-- тут

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Product> getAll() {
        String sql = "SELECT p.id, p.name, p.price, p.type, c.id as cat_id, c.name as cat_name " +
                "FROM products p " +
                "JOIN categories c ON p.category_id = c.id";

        List<Product> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Category cat = new Category(
                        rs.getInt("cat_id"),
                        rs.getString("cat_name")
                );

                Product p;

                if (rs.getString("type").equals("GAME")) {
                    p = new Game(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            cat,
                            "Unknown" // genre
                    );
                } else {
                    p = new App(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            cat,
                            true // isPaid
                    );
                }

                list.add(p);
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
