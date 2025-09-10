package app;

import app.domain.Customer;
import app.domain.Product;
import app.repository.CustomerRepository;
import app.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {
//    public static void main(String[] args) {
//        Product product = new Product(7, "Banane", 120, true);
//        System.out.println(product);
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        File file = new File("database/product.txt");
//
//        try {
//            mapper.writeValue(file, product);
//
//            Product productFromFile = mapper.readValue(file, Product.class);
//            System.out.println("Прочитанный из файла продукт:");
//            System.out.println(productFromFile);
//
//            List<Product> products = List.of(
//                    new Product(1, "Apple", 75, true),
//                    new Product(2, "Pineapple", 89, true),
//                    new Product(3, "Orange", 122, true)
//            );
//            mapper.writeValue(file, products);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public static void main(String[] args) throws IOException {
//        ProductRepository repository = new ProductRepository();
//
//        Product product = new Product(3, "Banane", 33, true);
//        repository.save(product);
//
//        repository.findAll().forEach(System.out::println);
//
//        Product productById = repository.findById(1);
//        System.out.println("Найденный продукт:");
//        System.out.println(productById);
//
//        Product newProduct = new Product(1, "Apple", 80, true);
//        repository.update(newProduct);
//
//        repository.deleteById(2);
//
//    }

    public static void main(String[] args) throws IOException {
        CustomerRepository repository = new
                CustomerRepository();

        Customer customer1 = new Customer();
        customer1.setName("Маша");
        customer1.setActive(true);

        Customer customer2 = new Customer();
        customer2.setName("Маша");
        customer2.setActive(true);

        Customer customer3 = new Customer();
        customer3.setName("Маша");
        customer3.setActive(true);

        repository.save(customer1);
        repository.save(customer2);
        repository.save(customer3);
    }
}

