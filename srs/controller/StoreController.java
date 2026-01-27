public class StoreController {

    private final ProductService productService =
            new ProductService();

    private final CategoryRepository categoryRepo =
            new CategoryRepository();

    public void run() {

        Category games = categoryRepo.getById(1);
        Category utils = categoryRepo.getById(2);

        Product p1 = new Game(
                0, "Stardew Valley", 9.99, games, "Indie"
        );
        Product p2 = new App(
                0, "Offline Notes", 2.99, utils, true
        );

        productService.add(p1);
        productService.add(p2);

        for (Product p : productService.getAll()) {
            System.out.println(
                    p.getType() + ": " + p.getDescription()
            );
        }

        productService.delete(1);
    }
}
