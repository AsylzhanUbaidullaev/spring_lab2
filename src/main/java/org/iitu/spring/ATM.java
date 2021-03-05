package org.iitu.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Entity;
import java.util.Scanner;

@Component
public class ATM {
    Scanner in = new Scanner(System.in);
//    @Value("${atm.name}")
//    private String name;
//    @Value("${atm.address}")
//    private String address;

    private String currentCardNumber;
    private boolean accessStatus;
    private Bank bank;
    @Autowired
    public ATM(Bank bank) {
        this.bank = bank;
    }

    public String getCurrentCardNumber() {
        return currentCardNumber;
    }

    public void setCurrentCardNumber(String currentCardNumber) {
        this.currentCardNumber = currentCardNumber;
    }

    public boolean isAccessStatus() {
        return accessStatus;
    }

    public void setAccessStatus(boolean accessStatus) {
        this.accessStatus = accessStatus;
    }

    @PostConstruct
    public void doMyInit() {
        System.out.println("Welcome");
    }
    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Bye");
    }

    public void logIn() {
        System.out.print("Please, enter a card number: ");
        String cardNumber = in.next();
        System.out.print("PIN code: ");
        int pin = in.nextInt();

        if(bank.checkCard(cardNumber, pin)) {
            System.out.println("Valid data");
        } else {
            System.out.println("Invalid data");
        }
    }

    public void withdraw() {
        System.out.print("Enter an amount of money: ");
        double amount = in.nextDouble();

        if(bank.withdraw(amount, currentCardNumber)) {
            System.out.println("Please, wait");
        } else {
            System.out.println("Error...");
        }
    }

    public void topUp() {
        System.out.print("Enter an amount of money: ");
        double amount = in.nextDouble();

        if(amount > 0) {
            if(bank.topUp(amount, currentCardNumber)) {
                System.out.println("Please, wait");
            } else {
                System.out.println("Error");
            }
        } else {
            System.out.println("Please, input a money");
        }
    }

    public void run() {
        int choice = -1;
        while(choice != 0) {
            if(currentCardNumber == null) {
                logIn();
            } else {
                if (accessStatus) {
                    System.out.println("1. Check balance");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Top up");
                    System.out.println("0. Exit");

                    choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println(bank.checkBalance(currentCardNumber));
                            break;
                        case 2:
                            withdraw();
                            break;
                        case 3:
                            topUp();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Incorrect choice");
                    }
                }
            }

        }
    }
}
