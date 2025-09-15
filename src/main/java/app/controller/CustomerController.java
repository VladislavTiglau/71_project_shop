package app.controller;

import app.domain.Customer;
import app.domain.Product;
import app.exception.CustomerNotFoundException;
import app.exception.CustomerSaveExcteption;
import app.exception.ProductNotFoundExcepton;
import app.repository.CustomerRepository;
import app.service.CustomerService;
import app.service.ProductService;

import java.io.IOException;
import java.util.List;

public class CustomerController {

    private final CustomerService service;

    public CustomerController() throws IOException {
        service = new CustomerService();
    }


    public Customer save(String name) throws IOException, CustomerSaveExcteption {
        Customer customer = new Customer(name);
        return service.save(customer);

    }

    public List<Customer> getAllActiveCustomers() throws IOException {
        return service.getAllActiveCustomers();
    }

    public Customer getActiveCustomerById(int id) throws IOException, CustomerNotFoundException {
        return service.getActiveCustomerById(id);

    }

    public void update(int id, String name) throws CustomerSaveExcteption, IOException {
        Customer customer = new Customer(id, name);
        service.update(customer);
    }

    public void deleteById(int id) throws IOException, CustomerNotFoundException {
        service.deleteById(id);
    }

    public void deleteByName(String name) throws IOException, CustomerNotFoundException {
        service.deleteByName(name);
    }

    public void restoreById(int id) throws IOException, CustomerNotFoundException {
        service.restoreById(id);

    }

    public int getActiveCustomerCount() throws IOException {
        return service.getActiveCustomerCount();
    }

    public double getCustomerCartTotalPrice(int id) throws IOException, CustomerNotFoundException {
        return service.getCustomerCartTotalPrice(id);
    }

    public double getCustomerCartAveragePrice(int id) throws IOException, CustomerNotFoundException {
        return service.getCustomerCartAveragePrice(id);
    }

    public void addProductToCustomerCard(int customerId, int productId) throws IOException, CustomerNotFoundException, ProductNotFoundExcepton {
        service.addProductToCustomerCard(customerId, productId);
    }

    public void removeProductFromCustomerCart(int customerId, int productId) throws IOException, CustomerNotFoundException, ProductNotFoundExcepton {
        service.removeProductFromCustomerCart(customerId, productId);
    }

    public void clearCustomerCart(int id) throws IOException, CustomerNotFoundException {
        service.clearCustomerCart(id);
    }
}
