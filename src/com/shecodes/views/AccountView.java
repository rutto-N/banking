package com.shecodes.views;

import com.shecodes.controllers.AccountController;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountView {
    static Scanner scanner=new Scanner(System.in);
    public static int authUI() throws SQLException {

        System.out.println("Enter Your Account Number");
        double accNo=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter pin");
        int pin= scanner.nextInt();
        scanner.nextLine();

        return AccountController.checkBalance(accNo,pin);

    }
    public static double authUID() throws SQLException{
        int accNo=0;
        int pin=0;
        try {

            System.out.println("Enter Your Account Number");
             accNo=scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter pin");
             pin= scanner.nextInt();
            scanner.nextLine();


        }catch (IllegalArgumentException e){
           e.printStackTrace();
        }

        return AccountController.deposit(accNo,pin);

    }
    public static double authUIW() throws SQLException {

        System.out.println("Enter Your Account Number");
        int accNo=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter pin");
        int pin= scanner.nextInt();
        scanner.nextLine();

        return AccountController.withdraw(accNo,pin);

    }
    public static int withdrawUI(){

        System.out.println("How much do you want to withdraw???");
        int amount= scanner.nextInt();
        scanner.nextLine();
        return amount;
    }
    public static int depositUI(){

        System.out.println("How much do you want to deposit???");
        int amount= scanner.nextInt();
        scanner.nextLine();
        return amount;

    }
    public static int deleteAccountUI(){

        System.out.println("Enter Account number of the account to delete");
        int id= scanner.nextInt();
        scanner.nextLine();
        return id;

    }
    @Override
    protected void finalize() throws Throwable {
        scanner.close();
    }
}
