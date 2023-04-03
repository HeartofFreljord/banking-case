package yepp.bankingcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import yepp.bankingcase.model.Account;
import yepp.bankingcase.model.Customer;
import yepp.bankingcase.model.Transaction;
import yepp.bankingcase.service.AccountService;
import yepp.bankingcase.service.CustomerService;
import yepp.bankingcase.service.TransactionService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.Random;

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
        Customer tom = new Customer("tom", "tom@rabo", "tomP@ssw0rd");
        customerService.createCustomer(tom);
        generateAccount(tom);

        Customer john = new Customer("john", "john@example", "johnP@ssw0rd");
        customerService.createCustomer(john);
        generateAccount(john);
    }

    private void generateAccount(Customer customer) {
        Account account1 = new Account(customer, randomIban());
        accountService.createAccount(account1);
        generateTransaction(account1);

        Account account2 = new Account(customer, randomIban());
        accountService.createAccount(account2);
        generateTransaction(account2);
    }

    private void generateTransaction(Account account) {
        double salary = roundToNumberOfDecimalPlace(new Random().nextDouble(2000, 7000));
        double rent = roundToNumberOfDecimalPlace(new Random().nextDouble(300, 1500));

        boolean salaryReceived = false;
        for (int i = 0; i < 336; i++) {
            int year = 123;
            int month = i / 112;
            int day = i % (28 * 4) / 4 + 1;
            Date sendDate = new Date(year, month, day);
            transactionService.createTransaction(randomDailyTransaction(account, sendDate));
            if (day == 28 && !salaryReceived) {
                Transaction income = new Transaction(account, "Salary", salary, randomIban(), sendDate);
                transactionService.createTransaction(income);

                Transaction rentTransaction = new Transaction(account, "Rent", rent, randomIban(), sendDate);
                transactionService.createTransaction(rentTransaction);

                salaryReceived = true;
            } else if (day == 1) {
                salaryReceived = false;
            }
        }
    }

    private String randomIban() {
        Random rng = new Random();
        String iban = "NL0";
        if (rng.nextInt(2) == 0) {
            iban = iban.concat(" RABO");
        } else {
            iban = iban.concat(" INGB");
        }
        iban = iban.concat(" " + rng.nextInt(1000, 10000));
        iban = iban.concat(" " + rng.nextInt(1000, 10000));
        iban = iban.concat(" " + rng.nextInt(10, 100));
        return iban;
    }

    //TODO//
    private Transaction randomDailyTransaction(Account account, Date sendDate) {
        int rng = new Random().nextInt(5);
        String description = "";
        double amount = 0;
        switch (rng) {
            case 0:
                description = description.concat("Tikkie received");
                amount = roundToNumberOfDecimalPlace(new Random().nextDouble(10, 100));
                break;
            case 1:
                description = description.concat("Tikkie sent");
                amount = roundToNumberOfDecimalPlace(new Random().nextDouble(-100, -10));
                break;
            case 2:
                description = description.concat("Grocery");
                amount = roundToNumberOfDecimalPlace(new Random().nextDouble(-35, -3));
                break;
            case 3:
                description = description.concat("Restaurant");
                amount = roundToNumberOfDecimalPlace(new Random().nextDouble(-50, -15));
                break;
            case 4:
                description = description.concat("Side income");
                amount = roundToNumberOfDecimalPlace(new Random().nextDouble(20, 100));
                break;
        }
        return new Transaction(account, description, amount, randomIban(), sendDate);
    }

    private double roundToNumberOfDecimalPlace(double input) {
        BigDecimal bd = BigDecimal.valueOf(input);
        bd = bd.setScale(2, RoundingMode.CEILING);
        return bd.doubleValue();
    }
}
