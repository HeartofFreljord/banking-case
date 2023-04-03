package yepp.bankingcase.service;

import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction getTransactionById(int id);

    List<Transaction> getTransactionsByAccount(Account account);

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(int id, Transaction transaction);

    void deleteTransaction(int id);
}
