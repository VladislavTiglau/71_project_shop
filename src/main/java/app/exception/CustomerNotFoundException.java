package app.exception;

public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(int id) {
        super(String.format("Покупатель с идетификатором %d не найден", id));
    }

    public CustomerNotFoundException(String title) {
        super(String.format("Покупатель с именем %d не найден", title));

    }
}
