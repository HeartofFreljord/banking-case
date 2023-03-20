package yepp.bankingcase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import yepp.bankingcase.model.Customer;

import java.util.List;

@Component
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findCustomerByName(String name);
}
