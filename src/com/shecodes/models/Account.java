package com.shecodes.models;

import com.shecodes.enums.TypeOfAccount;

public class Account {
    Customer customer;
    double accountNumber;
    String accountName;
    int id;
    TypeOfAccount type;
    int pin;
    double balance;

    public Account() {

    }

    @Override
    public String toString() {
        return  + accountNumber +
                ", " + accountName +
                ", " + id +
                ", " + type +
                ", " + pin +
                ", " + balance;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeOfAccount getType() {
        return type;
    }

    public void setType(TypeOfAccount type) {
        this.type = type;
    }




}
