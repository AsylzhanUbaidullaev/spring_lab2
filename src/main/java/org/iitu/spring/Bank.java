package org.iitu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;

@Component
public class Bank implements BankService {

    private ArrayList<Account> accounts;
    private Account account;

    @Autowired
    public Bank(Account account) {
        this.account = account;
    }

    public void addAccount() {
        accounts.add(new Account("7", 1234, 1000, "Kaspi"));
        accounts.add(new Account("8", 1234, 1000, "Kaspi"));
        accounts.add(new Account("9", 1234, 1000, "Kaspi"));
    }
    public boolean checkCard(String cardNumber, int pin) {
        for(int i = 0; i < accounts.size(); i++) {
            if(cardNumber.equals(account.getAccountNumber()) && pin == account.getPin()) {
                System.out.println("Logged in");
            } else {
                System.out.println("Error");
            }
        }
        return false;
    }

    @Override
    public double checkBalance(String cardNumber) {
        if(cardNumber.equals(account.getAccountNumber())) {
            System.out.println("Balance: " + account.getWallet());
        } else {
            System.out.println("Something went wrong! Error...");
        }
        return 0;
    }

    @Override
    public boolean withdraw(double amount, String cardNumber) {
        if(cardNumber.equals(account.getAccountNumber())) {
            account.setWallet(account.getWallet()-amount);
            System.out.println("Success. Don't forget your money!");
        } else {
            System.out.println("Error");
        }
        return false;
    }

    @Override
    public boolean topUp(double amount, String cardNumber) {
        if(cardNumber.equals(account.getAccountNumber())) {
            account.setWallet(account.getWallet()+amount);
            System.out.println("Success. The amount '" + amount + "' of money is added");
        } else {
            System.out.println("Error");
        }
        return false;
    }
}
