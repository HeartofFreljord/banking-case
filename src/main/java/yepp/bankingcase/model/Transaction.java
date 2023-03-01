package yepp.bankingcase.model;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;
    @ManyToOne()
    @JoinColumn(name = "sender_id", nullable = false)
    private Account sender;
    @ManyToOne()
    @JoinColumn(name = "receiver_id", nullable = false)
    private Account receiver;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private double amount;

    public Transaction(Account sender, Account receiver, String description, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.description = description;
        this.amount = amount;
    }

    public Transaction() {

    }

    public int getId() {
        return id;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

}
