package com.shecodes.exceptions;

public class AccountTypeExcept extends Exception{
    public AccountTypeExcept(String message) {
        System.out.println(message+"Kindly Enter Current or Savings");
    }
}
