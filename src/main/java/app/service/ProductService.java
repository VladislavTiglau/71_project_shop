package app.service;

import app.domain.Product;
import app.exception.ProductNotFoundExcepton;
import app.exception.ProductSaveException;
import app.exception.ProductUpdateException;
import app.repository.ProductRepository;

import java.io.IOException;
import java.util.List;

public class ProductService {
    private final ProductRepository repository;

    public ProductService() throws IOException {
        repository = new ProductRepository();

    }

    public Product save(Product product) throws ProductSaveException, IOException {
        if (product == null) {
            throw new ProductSaveException("Продукт не может быть null");
        }

        String title = product.getTitle();
        if (title == null || title.trim().isEmpty()) {
            throw new ProductSaveException("Наименований продукта не может быть пустым");

        }

        if (product.getPrice() <= 0) {
            throw new ProductSaveException("Цена продуктп не должна быть отрицателбной");

        }

        product.setActive(true);
        return repository.save(product);

    }

    public List<Product> getAllActiveProducts() throws IOException {
        return repository.findAll()
                .stream()
                .filter(Product::isActive)
                .toList();
    }

    public Product getActiveProductById(int id) throws IOException, ProductNotFoundExcepton {
        Product product = repository.findById(id);

        if (product == null || !product.isActive()) {
            throw new ProductNotFoundExcepton(id);
        }
        return product;
    }

    public void update(Product product) throws ProductUpdateException, IOException {
        if (product == null) {
            throw new ProductUpdateException("Продукт не может быть null");
        }

        if (product.getPrice() <= 0) {
            throw new ProductUpdateException("Цена продукта должна быть положительной");

        }
        product.setActive(true);
        repository.update(product);
    }

    public void deleteById(int id) throws ProductNotFoundExcepton, IOException {
        Product product = getActiveProductById(id);
        product.setActive(false);
        repository.update(product);
    }

    public void deleteByTitle(String title) throws IOException, ProductNotFoundExcepton {
        Product product = getAllActiveProducts()
                .stream()
                .filter(x -> x.getTitle().equals(title))
                .peek(x -> x.setActive(false))
                .findFirst()
                .orElseThrow(
                        () -> new ProductNotFoundExcepton(title)
                );
        repository.update(product);
    }


    public void restoreById(int id) throws IOException, ProductNotFoundExcepton {
        Product product = repository.findById(id);

        if (product != null) {
            product.setActive(true);
            repository.update(product);
        } else {
            throw new ProductNotFoundExcepton(id);
        }

    }

    public int getActiveProductsCount() throws IOException {
        return getAllActiveProducts().size();

    }

    public double getActiveProductsTotalCost() throws IOException {
        return getAllActiveProducts()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();

    }

    public double getActiveProductsAveragePrice() throws IOException {
        int productCount = getActiveProductsCount();

        if (productCount == 0) {
            return 0.0;
        }
        return getActiveProductsTotalCost() / productCount;

    }


}