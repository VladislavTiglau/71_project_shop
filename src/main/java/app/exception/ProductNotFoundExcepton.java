package app.exception;

public class ProductNotFoundExcepton extends Exception {

    public ProductNotFoundExcepton(int id) {
        super(String.format("Продукт с идентификатором %d не найден", id));
    }

    public ProductNotFoundExcepton(String title) {
        super(String.format("Продукт с именем %d не найден", title));

    }
}