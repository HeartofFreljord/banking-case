package yepp.bankingcase;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import yepp.bankingcase.service.AccountService;

@SpringBootApplication
public class BankingCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingCaseApplication.class, args);
    }

    @Bean
    public ApplicationRunner populateData(AccountService accountService) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {

            }
        };
    }

}
