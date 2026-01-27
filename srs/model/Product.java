package model;

import interfaces.Validatable;
import interfaces.PricedItem;
import exception.InvalidInputException;

public abstract class Product extends BaseEntity
        implements Validatable, PricedItem {

    protected double price;
    protected Category category;

    public Product(int id, String name, double price, Category category) {
        super(id, name);
        this.price = price;
        this.category = category;
    }


    public void setId(int id) {
        this.id = id;
    }


    @Override
    public void validate() {
        if (name == null || name.isBlank())
            throw new InvalidInputException("Empty name");
        if (price <0)
            throw new InvalidInputException("Price <= 0");
        if (category == null)
            throw new InvalidInputException("Category required");
    }

    @Override
    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + price +
                ", type=" + getType() +
                ", category=" + category.getName() +
                '}';
    }

}
