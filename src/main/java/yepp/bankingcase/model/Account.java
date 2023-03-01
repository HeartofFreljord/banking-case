package yepp.bankingcase.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int id;
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "account_iban", nullable = false)
    private String IBAN;
    @Column(name = "account_balance", nullable = false)
    private double balance;
    @OneToMany(mappedBy = "receiver_id")
    private List<Transaction> debitTransactionList;
    @OneToMany(mappedBy = "sender_id")
    private List<Transaction> creditTransactionList;

    public Account(int id, User user, String IBAN) {
        this.id = id;
        this.user = user;
        this.IBAN = IBAN;
        this.balance = 0;
        this.debitTransactionList = new ArrayList<>();
        this.creditTransactionList = new ArrayList<>();
    }

    public Account() {

    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionList() {
        return Stream.concat(debitTransactionList.stream(), creditTransactionList.stream()).toList();
    }

    public void addDebitTransaction(Transaction transaction) {
        this.debitTransactionList.add(transaction);
    }
    public void addCreditTransaction(Transaction transaction) {
        this.creditTransactionList.add(transaction);
    }

    public void removeTransaction(int transactionId) {
        this.debitTransactionList.removeIf(transaction -> transaction.getId() == transactionId);
        this.creditTransactionList.removeIf(transaction -> transaction.getId() == transactionId);
    }
}
