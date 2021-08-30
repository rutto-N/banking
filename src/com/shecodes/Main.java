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
import com.shecodes.views.AccountView;
import com.shecodes.views.CustomerView;
import com.shecodes.views.StaffView;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Database db;
    static Scanner scanner=new Scanner(System.in);

    static {
        try {
            db = new Database();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {

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

    private static void customerMenuUI() throws SQLException{
        int c;
        do {
            System.out.println("Customer Main Menu:");
            System.out.println("1:Check Balance");
            System.out.println("2:Deposit");
            System.out.println("3:Withdraw");
            System.out.println("0:Exit");
            c=scanner.nextInt();
            scanner.nextLine();
            switch (c){
                case 1:
                    AccountView.authUI();
                    break;
                case 2:
                    AccountView.authUID();
                    break;
                case 3:
                    AccountView.authUIW();
                    break;

            }

        }while (c!=0);
    }

    private static void staffMenuUI() throws  SQLException {
        int c;
        do {

            System.out.println("Staff Main Menu:");
//            System.out.println("1:New Customer");
            System.out.println("1:Open Account");
            System.out.println("2:New Staff");
            System.out.println("3:View Customers");
            System.out.println("4:Delete Customer");
            System.out.println("5:Delete Staff");
            System.out.println("6:Delete Account");
            System.out.println("0: Exit");
            c=scanner.nextInt();
            scanner.nextLine();
            switch (c){
                case 1:
                    StaffController.addCustomer(StaffView.getCustomerDetailsUI());
                    Account a= CustomerView.getAccountDetailsUI();

                    AccountController.openAccount(a);
                    break;
                case 2:
                    StaffController.addStaff(StaffView.getStaffDetailsUI());
                    break;
                case 3:
                    Util.loopArray(StaffController.viewCustomers());
                    break;
                case 4:
                    CustomerController.deleteCustomer(CustomerView.deleteCustomerUI());
                    break;
                case 5:
                    StaffController.deleteStaff(StaffView.deleteStaffUI());
                    break;
                case 6:
                    AccountController.deleteAccount(AccountView.deleteAccountUI());
                    break;

            }

        }while (c!=0);

    }

    @Override
    protected void finalize() throws Throwable {
        scanner.close();
    }
}
