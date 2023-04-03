package yepp.bankingcase.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private int id;
    @Column()
    private String senderIban;
    @Column()
    private String description;
    @Column()
    private double amount;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;

    @Column()
    private Date sendDate;

    public Transaction(Account account, String description, double amount, String senderIban, Date sendDate) {
        this.account = account;
        this.description = description;
        this.amount = amount;
        this.senderIban = senderIban;
        this.sendDate = sendDate;
    }
}
