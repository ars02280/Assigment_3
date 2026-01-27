public class ProductRepository {

    public void create(Product p) {
        String sql = """
        INSERT INTO products(name, price, type, category_id)
        VALUES (?, ?, ?, ?)
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getType());
            ps.setInt(4, p.getCategory().getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public List<Product> getAll() {
        String sql = """
        SELECT p.*, c.name AS category_name
        FROM products p
        JOIN categories c ON p.category_id = c.id
        """;

        List<Product> list = new ArrayList<>();

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category cat = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );

                Product p = rs.getString("type").equals("GAME")
                        ? new Game(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        cat, "Unknown")
                        : new App(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        cat, true);

                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            if (ps.executeUpdate() == 0)
                throw new ResourceNotFoundException();

        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }
}
