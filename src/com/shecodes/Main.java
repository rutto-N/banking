package com.shecodes;

import com.shecodes.controllers.AccountController;
import com.shecodes.controllers.CustomerController;
import com.shecodes.controllers.StaffController;
import com.shecodes.dbutil.Database;
import com.shecodes.exceptions.AccountTypeExcept;
import com.shecodes.exceptions.IllegalArgumentsExcept;
import com.shecodes.exceptions.SQLExcept;
import com.shecodes.helpers.Util;
import com.shecodes.models.Account;
import com.shecodes.models.Customer;
import com.shecodes.views.AccountViews;
import com.shecodes.views.CustomerViews;
import com.shecodes.views.StaffViews;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Database db;



    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLExcept, AccountTypeExcept, IllegalArgumentsExcept {
//        Customer c=CustomerController.searchCustomer(56);
//        System.out.println(c.getNationalId());

        db=new Database();
        int choice=0;
        do{
            System.out.println("-----------------------------------------");
            System.out.println("Welcome to Simple Banking Application");
            System.out.println("Main Menu:");
            System.out.println("Which User group Best defines you??");
            System.out.println("1:Staff");
            System.out.println("2:Customer");
            System.out.println("0. Exit");
            Scanner scanner=new Scanner(System.in);
            choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    staffMenuUI();
                    break;
                case 2:
                    customerMenuUI();
                    break;
            }

        }while (choice!=0);


    }

    private static void customerMenuUI() throws SQLException, IllegalArgumentsExcept, SQLExcept {
        int c;
        do {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Customer Main Menu:");
            System.out.println("1:Check Balance");
            System.out.println("2:Deposit");
            System.out.println("3:Withdraw");
            System.out.println("0:Exit");
            c=scanner.nextInt();
            scanner.nextLine();
            switch (c){
                case 1:
                    AccountViews.authUI();
                    break;
                case 2:
                    AccountViews.authUID();
                    break;
                case 3:
                    AccountViews.authUIW();
                    break;

            }

        }while (c!=0);
    }

    private static void staffMenuUI() throws SQLException, ClassNotFoundException, SQLExcept, AccountTypeExcept {
        int c;
        do {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Staff Main Menu:");
//            System.out.println("1:New Customer");
            System.out.println("1:Open Account");
            System.out.println("2:New Staff");
            System.out.println("3:View Customers");
            System.out.println("0: Exit");
            c=scanner.nextInt();
            scanner.nextLine();
            switch (c){
                case 1:
                    StaffController.addCustomer(StaffViews.getCustomerDetailsUI());
                    Account a=CustomerViews.getAccountDetailsUI();

                    AccountController.openAccount(a);
                    break;
                case 2:
                    StaffController.addStaff(StaffViews.getStaffDetailsUI());
                    break;
                case 3:
                    Util.loopArray(StaffController.viewCustomers());
                    break;

            }

        }while (c!=0);

    }














}
