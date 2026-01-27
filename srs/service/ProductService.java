package service;

import model.Product;
import repository.ProductRepository;

import java.util.List;

public class ProductService {

    private final ProductRepository repo = new ProductRepository();

    public void add(Product p) {
        p.validate();
        repo.create(p);
    }

    public List<Product> getAll() {
        return repo.getAll();
    }

    public void delete(int id) {
        repo.delete(id);
    }
}
