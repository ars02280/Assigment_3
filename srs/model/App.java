package model;

public class App extends Product {

    private boolean offlineMode;

    public App(int id, String name, double price, Category category, boolean offlineMode) {
        super(id, name, price, category);
        this.offlineMode = offlineMode;
    }

    @Override
    public void validate() {
        super.validate();
    }

    @Override
    public String getType() {
        return "APP";
    }
    @Override
    public String getDescription() {
        return "App: " + getName();
    }


    @Override
    public String toString() {
        return "App{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + price +
                ", category=" + getCategory().getName() +
                '}';
    }

}


