public class ProductRepository {

    public void create(Product product) {
        String sql = """
        INSERT INTO products(name, price, type, category_id)
        VALUES (?, ?, ?, ?)
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getType());
            ps.setInt(4, product.getCategory().getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }
}
