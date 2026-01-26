public class ProductService {
    private final ProductRepository repo = new ProductRepository();

    public void addProduct(Product product) {
        product.validate();
        repo.create(product);
    }
}
