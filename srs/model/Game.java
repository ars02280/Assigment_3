package model;

public class Game extends Product {

    private String genre;

    public Game(int id, String name, double price, Category category, String genre) {
        super(id, name, price, category);
        this.genre = genre;
    }

    @Override
    public void validate() {
        super.validate();
        if (genre == null || genre.isBlank())
            throw new IllegalArgumentException("Genre required");
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                ", category=" + getCategory().getName() +
                '}';
    }
    @Override
    public String getType() {
        return "GAME";
    }


    @Override
    public String getDescription() {
        return "Game: " + name + " [" + genre + "]";
    }
}
