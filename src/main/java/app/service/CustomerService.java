package app.service;

import app.domain.Customer;
import app.domain.Product;
import app.exception.CustomerNotFoundException;
import app.exception.CustomerSaveExcteption;
import app.exception.ProductSaveException;
import app.repository.CustomerRepository;
import app.repository.ProductRepository;

import java.io.IOException;
import java.util.List;

public class CustomerService {

    private final CustomerRepository repository;
    private final ProductService productService;

    public CustomerService() throws IOException {
        repository = new CustomerRepository();
        productService = new ProductService();

    }

    public Customer save(Customer customer) throws IOException, CustomerSaveExcteption {
        if (customer == null) {
            throw new CustomerSaveExcteption("Покупатель не может быть null");
        }

        String name = customer.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new CustomerSaveExcteption("Имя покупателя не может быть пустым");

        }


        customer.setActive(true);
        return repository.save(customer);

    }

    public List<Customer> getAllActiveCustomers() throws IOException {
        return repository.findAll()
                .stream()
                .filter(Customer::isActive)
                .toList();
    }

    public Customer getActiveCustomerById(int id) throws IOException, CustomerNotFoundException {
        Customer customer = repository.findById(id);

        if (customer == null || !customer.isActive()){
            throw new CustomerNotFoundException(id);
        }
        return customer;

    }
    public void update(Customer customer) throws CustomerSaveExcteption, IOException {
        if (customer == null) {
            throw new CustomerSaveExcteption("Покупатель не может быть null");
        }

        String name = customer.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new CustomerSaveExcteption("Имя покупателя не может быть пустым");

        }
        repository.update(customer);
    }
    public void deleteById(int id) throws IOException, CustomerNotFoundException {
        getActiveCustomerById(id).setActive(false);
    }
}
