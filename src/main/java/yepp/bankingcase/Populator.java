package yepp.bankingcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import yepp.bankingcase.service.AccountService;
import yepp.bankingcase.service.CustomerService;
import yepp.bankingcase.service.TransactionService;

@Component
@ComponentScan
public class Populator implements ApplicationRunner {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        User tom = new User(1, "tom", "tom@tom", "tomP@ssw0rd");
//        userService.createUser(tom);
//        User duy = new User(2, "duy", "duy@duy", "duyP@ssw0rd");
//        userService.createUser(duy);
//
//        Account tomAccount = new Account(1, tom, "tomIBAN");
//        accountService.createAccount(tomAccount);
//        Account duyAccount = new Account(2, duy, "duyIBAN");
//        accountService.createAccount(duyAccount);
//
//        Transaction transaction1 = new Transaction(1, tomAccount, duyAccount, "transaction1", 10);
//        transactionService.createTransaction(transaction1);
    }
}
