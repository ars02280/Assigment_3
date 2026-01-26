public class App extends Product {
    private boolean offline;

    public App(int id, String name,
               double price, Category category,
               boolean offline) {
        super(id, name, price, category);
        this.offline = offline;
    }

    @Override
    public String getType() {
        return "APP";
    }

    @Override
    public String getDescription() {
        return name + " offline=" + offline;
    }
}
