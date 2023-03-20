package yepp.bankingcase.service;

import yepp.bankingcase.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(int id);

    List<Customer> getCustomersByName(String name);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);
}
