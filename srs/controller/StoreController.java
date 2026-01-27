package controller;

import model.App;
import model.Category;
import model.Game;
import model.Product;
import service.ProductService;
import repository.CategoryRepository;

public class StoreController {

    private final ProductService productService = new ProductService();
    private final CategoryRepository categoryRepository = new CategoryRepository();

    public void run() {


        Category c1 = new Category(1, "Games");
        Category c2 = new Category(2, "Apps");


        Product g = new Game(1, "CS2", 1, c1, "Shooter");
        Product a = new App(2, "Notion", 5, c2, true);


        productService.add(g);
        productService.add(a);


        System.out.println(productService.getAll());



    }
}
