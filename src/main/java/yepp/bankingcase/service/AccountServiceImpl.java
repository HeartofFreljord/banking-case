package yepp.bankingcase.service;

import org.springframework.stereotype.Component;
import yepp.bankingcase.model.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {
    private final List<Account> accountList;

    public AccountServiceImpl() {
        this.accountList = new ArrayList<>();
    }

    @Override
    public Account getAccountById(int id) {
        return accountList.stream().filter(account -> account.getId() == id).findAny().orElse(null);
    }

    @Override
    public Account getAccountByIBAN(String iban) {
        return accountList.stream().filter(account -> account.getIBAN().equals(iban)).findAny().orElse(null);
    }

    @Override
    public Account createAccount(Account account) {
        this.accountList.add(account);
        return account;
    }

    @Override
    public Account updateAccount(int id, Account newAccount) {
        if (id < accountList.size()) {
            accountList.set(id, newAccount);
            return newAccount;
        }
        return null;
    }

    @Override
    public void deleteAccount(int id) {
        accountList.removeIf(account -> account.getId() == id);
    }
}
