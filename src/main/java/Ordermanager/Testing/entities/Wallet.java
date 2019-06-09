package Ordermanager.Testing.entities;

import Ordermanager.Testing.enums.Wallets;

import javax.persistence.*;

@Entity
@Table(name = "wallet_table")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private Wallets wallets;

    public Wallet(Wallets wallets, double balance) {
        this.wallets = wallets;
        this.balance = balance;
    }

    @Column(name = "balance", nullable = true, unique = false)
    private double balance;

//    @OneToOne
//    @JoinColumn(name = "user_id",nullable = false,unique = true)
//    private User user;

    public Wallet() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Wallet{" + "id=" + id + ", wallets=" + wallets + ", balance=" + balance + '}';
    }

    public Wallets getWallets() {
        return wallets;
    }

    public void setWallets(Wallets wallets) {
        this.wallets = wallets;
    }

}
