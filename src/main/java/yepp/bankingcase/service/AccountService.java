package yepp.bankingcase.service;

import yepp.bankingcase.model.Account;

public interface AccountService {
    Account getAccountById(int id);

    Account getAccountByIBAN(String iban);

    Account createAccount(Account account);

    Account updateAccount(int id, Account account);

    void deleteAccount(int id);
}
