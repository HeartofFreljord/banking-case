package yepp.bankingcase.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;
    @Column(name = "sender_iban")
    private String senderIban;
    @Column(name = "description")
    private String description;
    @Column(name = "amount")
    private double amount;

    @Column(name = "account")
    private int account;

//    @Column(name = "date_time")
//    private Date date;

    public Transaction(int id, int account, String description, double amount, String senderIban) {
        this.id = id;
        this.account = account;
        this.description = description;
        this.amount = amount;
        this.senderIban = senderIban;
//        this.date = date;
    }
}
