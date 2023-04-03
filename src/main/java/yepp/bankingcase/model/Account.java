package yepp.bankingcase.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private int id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;
    @Column(nullable = false)
    private String iban;
    @Column()
    private double balance;

    public Account(Customer customer, String iban) {
        this.customer = customer;
        this.iban = iban;
        this.balance = 10000;
    }
}
