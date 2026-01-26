public abstract class Product extends BaseEntity
        implements Validatable, PricedItem {

    protected double price;
    protected Category category;

    public Product(int id, String name,
                   double price, Category category) {
        super(id, name);
        this.price = price;
        this.category = category;
    }

    @Override
    public void validate() {
        if (name == null || name.isBlank())
            throw new InvalidInputException("Empty name");
        if (price <= 0)
            throw new InvalidInputException("Price <= 0");
        if (category == null)
            throw new InvalidInputException("Category required");
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
