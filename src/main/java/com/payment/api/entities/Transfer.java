package com.payment.api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;

    @ManyToOne()
    @JoinColumn(name = "payer")
    private Wallet payer;

    @ManyToOne()
    @JoinColumn(name = "payee")
    private Wallet payee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Wallet getPayer() {
        return payer;
    }

    public void setPayer(Wallet payer) {
        this.payer = payer;
    }

    public Wallet getPayee() {
        return payee;
    }

    public void setPayee(Wallet payee) {
        this.payee = payee;
    }
}
