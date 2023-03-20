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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_name", nullable = false)
    private String name;
    @Column(name = "customer_email", nullable = false)
    private String email;
    @Column(name = "customer_password", nullable = false)
    private String password;
    @OneToMany
    @JoinTable(name = "customer_account")
    @JsonIgnoreProperties("transactionList")
    private List<Account> accountList;

    public Customer(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accountList = new ArrayList<>();
    }

    public void addAccount(Account account) {
        this.accountList.add(account);
        System.out.println("added account " + account.getId() + " to customer " + this.getId());
    }

    public void removeAccount(int accountId) {
        this.accountList.removeIf(account -> account.getId() == accountId);
        System.out.println("removed account " + accountId + " from customer " + this.getId());
    }
}
