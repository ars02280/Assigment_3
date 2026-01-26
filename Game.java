public class Game extends Product {
    private String genre;

    public Game(int id, String name,
                double price, Category category,
                String genre) {
        super(id, name, price, category);
        this.genre = genre;
    }

    @Override
    public String getType() {
        return "GAME";
    }

    @Override
    public String getDescription() {
        return name + " [" + genre + "]";
    }
}
