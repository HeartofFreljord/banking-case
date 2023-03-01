package yepp.bankingcase.service;

import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Transaction;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private List<Transaction> transactionList;
    private AccountService accountService;

    @Override
    public boolean verifyTransaction(Transaction transaction) {
        //verify account
        if (accountService.getAccountByIBAN(transaction.getSender().getIBAN()) == null || accountService.getAccountByIBAN(transaction.getReceiver().getIBAN()) == null) {
            return false;
        }
        //verify amount
        return !(transaction.getAmount() < 0);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if (this.verifyTransaction(transaction)) {
            transactionList.add(transaction);
        }
        Account sender = accountService.getAccountByIBAN(transaction.getSender().getIBAN());
        sender.addCreditTransaction(transaction);

        Account receiver = accountService.getAccountByIBAN(transaction.getReceiver().getIBAN());
        receiver.addDebitTransaction(transaction);
    }


}
