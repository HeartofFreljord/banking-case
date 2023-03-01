package yepp.bankingcase.service;

import yepp.bankingcase.model.Transaction;

public interface TransactionService {
    boolean verifyTransaction(Transaction transaction);

    void addTransaction(Transaction transaction);
}
