package yepp.bankingcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import yepp.bankingcase.service.AccountService;

@Component
@ComponentScan
public class Populator implements ApplicationRunner {
    @Autowired
    private AccountService accountService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //accountService.createAccount(new User(0, "", "", ""));
    }
}
