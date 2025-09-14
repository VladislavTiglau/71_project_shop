package app.exception;

public class ProductNotFoundExcepton extends Exception{

    public ProductNotFoundExcepton(int id) {
        super(String.format("Продукт с идентификатором %d не найден", id));
    }

}
