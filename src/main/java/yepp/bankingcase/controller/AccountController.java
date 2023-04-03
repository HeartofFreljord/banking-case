package yepp.bankingcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yepp.bankingcase.model.Account;
import yepp.bankingcase.service.AccountService;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/account/{aid}")
    public Account getAccountById(@PathVariable int aid) {
        return this.accountService.getAccountById(aid);
    }

    @PostMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    /**
     * {
     *     "customer": { "id": 1 },
     *     "balance": 100.0,
     *     "transactionList": [],
     *     "iban": "NL01 INGB 1234 5678 90"
     * }
     */
    public Account createAccount(@RequestBody Account newAccount) {
        if (newAccount != null) {
            this.accountService.createAccount(newAccount);
            return newAccount;
        }
        return null;
    }

    @PutMapping(value = "/account/{aid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account updateAccount(@PathVariable int aid, @RequestBody Account newAccount) {
        if (newAccount != null) {
            return this.accountService.updateAccount(aid, newAccount);
        }
        return null;
    }

    @DeleteMapping(value = "/account/{aid}")
    public void deleteAccount(@PathVariable int aid) {
        this.accountService.deleteAccount(aid);
    }
}
