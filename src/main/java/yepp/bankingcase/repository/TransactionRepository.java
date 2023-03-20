package yepp.bankingcase.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import yepp.bankingcase.model.Transaction;

@Component
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
