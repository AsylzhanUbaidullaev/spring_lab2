package org.iitu.spring;

public interface BankService {
    double checkBalance(String cardNumber);
    boolean withdraw(double amount, String cardNumber);
    boolean topUp(double amount, String cardNumber);
}
