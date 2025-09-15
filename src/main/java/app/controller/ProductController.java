package app.controller;

import app.domain.Product;
import app.exception.ProductNotFoundExcepton;
import app.exception.ProductSaveException;
import app.exception.ProductUpdateException;
import app.repository.ProductRepository;
import app.service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductController {

    private final ProductService service;

    public ProductController() throws IOException {
        service = new ProductService();
    }

    public Product save(String title, double price) throws ProductSaveException, IOException {
        Product product = new Product(title, price);
        return service.save(product);


    }

    public List<Product> getAllActiveProducts() throws IOException {
        return service.getAllActiveProducts();
    }

    public Product getActiveProductById(int id) throws IOException, ProductNotFoundExcepton {
        return service.getActiveProductById(id);
    }

    public void update(int id, double preis) throws ProductUpdateException, IOException {
        Product product = new Product(id, preis);
    }

    public void deleteById(int id) throws ProductNotFoundExcepton, IOException {
        service.deleteById(id);

    }

    public void deleteByTitle(String title) throws IOException, ProductNotFoundExcepton {
        service.deleteByTitle(title);

    }

    public void restoreById(int id) throws IOException, ProductNotFoundExcepton {
        service.restoreById(id);

    }

    public int getActiveProductsCount() throws IOException {
        return service.getActiveProductsCount();

    }

    public double getActiveProductsTotalCost() throws IOException {
        return service.getActiveProductsTotalCost();

    }

    public double getActiveProductsAveragePrice() throws IOException {
        return service.getActiveProductsAveragePrice();

    }
}
