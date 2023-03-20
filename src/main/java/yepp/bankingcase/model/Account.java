package yepp.bankingcase.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;
    @Column(name = "owner")
    private int customer;
    @Column(name = "account_iban", nullable = false)
    private String iban;
    @Column(name = "account_balance")
    private double balance;

    @OneToMany
    @JoinTable(name = "account_transaction")
    @JsonIgnoreProperties
    private List<Transaction> transactionList;

    public Account(int id, int customer, String iban) {
        this.id = id;
        this.customer = customer;
        this.iban = iban;
        this.balance = 100;
        this.transactionList = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
        System.out.println("added transaction " + transaction.getId() + " to account " + this.getId());
    }

    public void removeTransaction(int transactionId) {
        this.transactionList.removeIf(transaction -> transaction.getId() == transactionId);
        System.out.println("removed transaction " + transactionId + " from account " + this.getId());
    }
}
