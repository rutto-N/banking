package com.shecodes.models;

import com.shecodes.enums.TypesOfAccount;

public class Account {
    Customer customer;
    int accountNumber;
    String accountName;
    int id;
    TypesOfAccount type;
    int pin;
    int balance;

    public Account() {

    }

    public Account(Customer customer, int accountNumber, String accountName, TypesOfAccount type, int pin) {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.type = type;
        this.pin = pin;
    }

    public Account(int accountNumber, String accountName, TypesOfAccount type, int pin) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.type = type;
        this.pin = pin;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
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

    public TypesOfAccount getType() {
        return type;
    }

    public void setType(TypesOfAccount type) {
        this.type = type;
    }




}
