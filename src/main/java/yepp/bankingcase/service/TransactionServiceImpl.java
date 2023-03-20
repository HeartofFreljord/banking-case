package yepp.bankingcase.service;

import org.springframework.stereotype.Component;
import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Customer;
import yepp.bankingcase.model.Transaction;
import yepp.bankingcase.repository.TransactionRepository;

@Component
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

    @Override
    public Transaction createTransaction(Transaction transaction) {
        int accountId = transaction.getAccount();
        Account account = this.accountService.getAccountById(accountId);
        if (account != null) {
            this.transactionRepository.save(transaction);
            System.out.println("saved new transaction with id " + transaction.getId());
            account.addTransaction(transaction);
            accountService.updateAccount(accountId, account);
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
            Transaction transaction = transactionRepository.findById((long) id).get();
            int accountId = transaction.getAccount();
            Account account = accountService.getAccountById(accountId);
            if (account != null) {
                account.removeTransaction(id);
                accountService.updateAccount(accountId, account);
                transactionRepository.deleteById((long) id);
                System.out.println("deleted transaction with id " + id);
            } else {
                System.out.println("cannot find account of transaction with id " + id);
            }
        } else {
            System.out.println("cannot find transaction with id " + id);
        }
    }


}
