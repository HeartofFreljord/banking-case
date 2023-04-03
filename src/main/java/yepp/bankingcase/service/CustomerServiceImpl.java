package yepp.bankingcase.service;

import org.springframework.stereotype.Service;
import yepp.bankingcase.model.Customer;
import yepp.bankingcase.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = customerRepository.findById((long) id).orElse(null);
        if (customer != null) {
            System.out.println("found customer with id " + id);
        } else {
            System.out.println("cannot find customer with id " + id);
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        List<Customer> customers = customerRepository.findCustomerByName(name);
        if (customers.isEmpty()) {
            System.out.println("cannot find customer with name " + name);
        } else {
            System.out.println("found " + customers.size() + " customers with name " + name);
        }
        return customers;
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
        System.out.println("saved new customer with id " + newCustomer.getId());
        return newCustomer;
    }

    @Override
    public Customer updateCustomer(int id, Customer newCustomer) {
        if (customerRepository.findById((long) id).isPresent()) {
            customerRepository.save(newCustomer);
            System.out.println("updated customer with id " + newCustomer.getId());
            return newCustomer;
        } else {
            System.out.println("cannot find customer with id " + newCustomer.getId());
        }
        return null;
    }

    @Override
    public void deleteCustomer(int id) {
        if (customerRepository.findById((long) id).isPresent()) {
            customerRepository.deleteById((long) id);
            System.out.println("deleted customer with id " + id);
        } else {
            System.out.println("cannot find customer with id " + id);
        }

    }
}
