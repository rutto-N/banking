package com.shecodes.controllers;

import com.shecodes.dbutil.Database;
import com.shecodes.exceptions.SQLExcept;
import com.shecodes.helpers.Util;
import com.shecodes.models.Account;
import com.shecodes.models.Customer;
import com.shecodes.views.AccountViews;

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


    public static int checkBalance(int accNo, int pin) throws SQLException {
        int balance=0;
        String s="SELECT `accountNumber`, `accountName`, `pin`, `accountType`, `balance` FROM `accounts` WHERE accountNumber="+accNo+" AND pin="+pin;
        ResultSet rs= db.executeSelect(s);
        while (rs.next()){

            balance=rs.getInt("balance");
        }
        System.out.println("Your Balance is: "+balance);
        return balance;
    }
    public static int deposit(int accNo, int pin) throws SQLExcept, SQLException {
        int balance;
        try {
             balance=checkBalance(accNo,pin);

        }catch (SQLException e){
            throw new SQLExcept(e.getMessage());
        }

        int amount= AccountViews.depositUI();
        balance=balance+amount;
        return updateBalance(balance,accNo);

    }
    public static int withdraw(int accNo, int pin) throws SQLException {
        int bal=checkBalance(accNo,pin);
        int amt=AccountViews.withdrawUI();
        if (amt>bal){
            System.out.println("Insufficient Funds");
            return bal;
        }else{
            bal=bal-amt;
            return updateBalance(bal,accNo);

        }

    }
    static int updateBalance(int amt, int accNo) throws SQLException {

        String s="UPDATE `accounts` SET `balance`="+amt+" WHERE accountNumber="+accNo;
//        ResultSet rs=db.executeSelect(s);
//        while (rs.next()){
//
//            balance=rs.getInt("balance");
//        }
        int x=db.execute(s);
        if (x==1){
            System.out.println("New Balance is: "+amt);
        }
        return amt;

    }
    public static boolean openAccount(Account account) throws SQLException, ClassNotFoundException, SQLExcept {

        Customer c= CustomerController.searchCustomer(account.getId());
//        Customer c=getCustomer(account.getId());
        System.out.println(c+"....");
            String s="INSERT INTO `accounts`(`accountNumber`, `accountName`, `pin`, `accountType`, `balance`,`customer_id`) VALUES " +
                    "('"+account.getAccountNumber()+"','"+account.getAccountName()+"','"+account.getPin()+"','"+account.getType()+"'," +
                    "'"+account.getBalance()+"','"+c.getId()+"')";
//            System.out.println(s);
            int x= db.execute(s);
            if (x==1){
                System.out.println("Account created Successfully");
                return true;
            }
            System.out.println("Something went wrong try again");

        return false;


    }
//    static Customer getCustomer(int id) throws SQLException, SQLExcept {
//        Customer c=new Customer();
//        String s="SELECT * FROM `customers` WHERE customers.id="+id;
//        ResultSet rs=db.executeSelect(s);
//        while (rs.next()){
//            c=StaffController.convertStringToCustomer(rs);
//        }
//        return c;
//    }





}
