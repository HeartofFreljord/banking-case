package yepp.bankingcase.service;

import org.springframework.stereotype.Service;
import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Customer;
import yepp.bankingcase.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    @Override
    public Account getAccountById(int id) {
        Account account = accountRepository.findById((long) id).orElse(null);
        if (account != null) {
            System.out.println("found account with id " + id);
        } else {
            System.out.println("cannot find account with id " + id);
        }
        return account;
    }

    @Override
    public Account getAccountByIBAN(String iban) {
        Account account = accountRepository.findAccountByIban(iban);
        if (account != null) {
            System.out.println("found account with iban " + iban);
        } else {
            System.out.println("cannot find account with iban " + iban);
        }
        return account;
    }

    @Override
    public List<Account> getAccountsByCustomer(Customer customer) {
        List<Account> accounts = accountRepository.findAccountsByCustomer(customer);
        if (accounts != null) {
            for (Account account : accounts) {
                System.out.println("found account " + account.getId() + " with customer id " + customer.getId());
            }
        } else {
            System.out.println("cannot find account with customer id " + customer.getId());
        }
        return accounts;
    }

    @Override
    public Account createAccount(Account account) {
        int customerId = account.getCustomer().getId();
        Customer customer = this.customerService.getCustomerById(customerId);
        if (customer != null) {
            this.accountRepository.save(account);
            System.out.println("saved new account with id " + account.getId());
            return account;
        }
        return null;
    }

    @Override
    public Account updateAccount(int id, Account newAccount) {
        if (accountRepository.findById((long) id).isPresent()) {
            accountRepository.save(newAccount);
            System.out.println("updated account with id " + newAccount.getId());
            return newAccount;
        } else {
            System.out.println("cannot find account with id " + id);
        }
        return null;
    }

    @Override
    public void deleteAccount(int id) {
        if (accountRepository.findById((long) id).isPresent()) {
            accountRepository.deleteById((long) id);
            System.out.println("deleted account with id " + id);
        } else {
            System.out.println("cannot find account with id " + id);
        }
    }
}
