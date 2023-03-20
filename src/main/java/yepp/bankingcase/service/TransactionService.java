package yepp.bankingcase.service;

import yepp.bankingcase.model.Transaction;

public interface TransactionService {
    Transaction getTransactionById(int id);

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(int id, Transaction transaction);

    void deleteTransaction(int id);
}
