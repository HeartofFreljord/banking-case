package yepp.bankingcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import yepp.bankingcase.model.Transaction;
import yepp.bankingcase.service.TransactionService;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transaction/{tid}")
    public Transaction getTransactionById(@PathVariable int tid) {
        return this.transactionService.getTransactionById(tid);
    }

    @PostMapping(value = "/transactions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transaction createTransaction(@RequestBody Transaction newTransaction) {
        if (newTransaction != null) {
            this.transactionService.createTransaction(newTransaction);
            return newTransaction;
        }
        return null;
    }

    @PutMapping(value = "/transaction/{tid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transaction updateTransaction(@PathVariable int tid, @RequestBody Transaction newTransaction) {
        if (newTransaction != null) {
            return this.transactionService.updateTransaction(tid, newTransaction);
        }
        return null;
    }

    @DeleteMapping(value = "/transaction/{aid}")
    public void deleteTransaction(@PathVariable int aid) {
        this.transactionService.deleteTransaction(aid);
    }
}
