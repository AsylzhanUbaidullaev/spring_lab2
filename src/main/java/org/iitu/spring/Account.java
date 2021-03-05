package org.iitu.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Account {
    private String accountNumber;
    private double pin;
    private double wallet;
    private String bank;

    public Account(String accountNumber, double pin, double wallet, String bank) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.wallet = wallet;
        this.bank = bank;
    }

    public double getPin() {
        return pin;
    }

    public void setPin(double pin) {
        this.pin = pin;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
