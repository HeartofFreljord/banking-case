package yepp.bankingcase.service;

import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Customer;

import java.util.List;

public interface AccountService {
    Account getAccountById(int id);

    Account getAccountByIBAN(String iban);

    List<Account> getAccountsByCustomer(Customer customer);

    Account createAccount(Account account);

    Account updateAccount(int id, Account account);

    void deleteAccount(int id);
}
