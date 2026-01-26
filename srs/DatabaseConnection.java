public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:store.db";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        }
    }
}
