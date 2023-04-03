package yepp.bankingcase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Customer;

import java.util.List;

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountByIban(String iban);

    List<Account> findAccountsByCustomer(Customer customer);
}
