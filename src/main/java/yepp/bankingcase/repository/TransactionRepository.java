package yepp.bankingcase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Transaction;

import java.util.List;

@Component
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findTransactionByAccount(Account account);
}
