package com.shecodes.controllers;

import com.shecodes.dbutil.Database;
import com.shecodes.helpers.Util;
import com.shecodes.models.Account;
import com.shecodes.models.Customer;
import com.shecodes.views.AccountView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountController {
    static Database db;

    static {
        try {
            db = new Database();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static int checkBalance(double accNo, int pin) throws SQLException {
        int balance=0;
        String s="SELECT `accountNumber`, `accountName`, `pin`, `accountType`, `balance` FROM `accounts` " +
                "WHERE accountNumber="+accNo+" AND pin="+pin;
        ResultSet rs= db.readData(s);
        while (rs.next()){

            balance=rs.getInt("balance");
        }
        System.out.println("Your Balance is: "+balance);
        return balance;
    }
    public static double deposit(double accNo, int pin) throws SQLException {
        int balance = 0;

        try {
            balance=checkBalance(accNo,pin);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        int amount= AccountView.depositUI();
        balance=balance+amount;
        return updateBalance(balance,accNo);

    }
    public static double withdraw(double accNo, int pin) throws SQLException {
        int bal=checkBalance(accNo,pin);
        int amt= AccountView.withdrawUI();
        if (amt>bal){
            System.out.println("Insufficient Funds");
            return bal;
        }else{
            bal=bal-amt;
            return updateBalance(bal,accNo);

        }

    }
    static double updateBalance(double amt, double accNo) throws SQLException {

        String s="UPDATE `accounts` SET `balance`="+amt+" WHERE accountNumber="+accNo;

        int x=db.writeData(s);
        if (x==1){
            System.out.println("New Balance is: "+amt);
        }
        return amt;

    }
    public static boolean openAccount(Account account) throws SQLException {

        Customer c= null;
            c = CustomerController.searchCustomer(account.getId());

        String s="INSERT INTO `accounts`(`accountNumber`, `accountName`, `pin`, `accountType`, `balance`,`customer_id`) VALUES " +
                    "('"+account.getAccountNumber()+"','"+account.getAccountName()+"','"+account.getPin()+"','"+account.getType()+"'," +
                    "'"+account.getBalance()+"','"+c.getId()+"')";
            int x= db.writeData(s);
            if (x==1){
                System.out.println("Account created Successfully");
                return true;
            }
            System.out.println("Something went wrong try again");

        return false;


    }
    public static Account searchAccount(int id) throws SQLException {

        Account account=new Account();
        String s="SELECT * FROM accounts WHERE accountNumber="+id;
        ResultSet rs =db.readData(s);
        while (rs.next()){
            account= Util.convertResultSetToAccount(rs);

        }
        return account;

    }
    public static boolean deleteAccount(int id) throws SQLException {
        Account account=searchAccount(id);
        String s="DELETE FROM accounts WHERE accountNumber="+account.getAccountNumber();
        int x=db.writeData(s);
        if (x==1){
            System.out.println("Account Deleted Successfully");
            return true;
        }
        return false;

    }






}
