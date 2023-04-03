package yepp.bankingcase.service;

import org.springframework.stereotype.Service;
import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Transaction;
import yepp.bankingcase.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    @Override
    public Transaction getTransactionById(int id) {
        Transaction transaction = transactionRepository.findById((long) id).orElse(null);
        if (transaction != null) {
            System.out.println("found transaction with id " + id);
        } else {
            System.out.println("cannot find transaction with id " + id);
        }
        return transaction;
    }

    public List<Transaction> getTransactionsByAccount(Account account) {
        List<Transaction> transactions = transactionRepository.findTransactionByAccount(account);
        if (transactions != null) {
            for (Transaction transaction : transactions) {
                System.out.println("found transaction " + transaction.getId() + " with account id " + account.getId());
            }
        } else {
            System.out.println("cannot find transaction with account id " + account.getId());
        }
        return transactions;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        int accountId = transaction.getAccount().getId();
        Account account = this.accountService.getAccountById(accountId);
        if (account != null) {
            this.transactionRepository.save(transaction);
            System.out.println("saved new transaction with id " + transaction.getId());
            return transaction;
        }
        return null;
    }

    @Override
    public Transaction updateTransaction(int id, Transaction transaction) {
        if (transactionRepository.findById((long) id).isPresent()) {
            transactionRepository.save(transaction);
            System.out.println("updated transaction with id " + transaction.getId());
            return transaction;
        } else {
            System.out.println("cannot find transaction with id " + id);
        }
        return null;
    }

    @Override
    public void deleteTransaction(int id) {
        if (transactionRepository.findById((long) id).isPresent()) {
            transactionRepository.deleteById((long) id);
            System.out.println("deleted transaction with id " + id);
        } else {
            System.out.println("cannot find transaction with id " + id);
        }
    }


}
