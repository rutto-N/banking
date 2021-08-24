package com.shecodes.views;

import com.shecodes.controllers.AccountController;
import com.shecodes.exceptions.IllegalArgumentsExcept;
import com.shecodes.exceptions.SQLExcept;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountViews {
    public static int authUI() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Your Account Number");
        int accNo=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter pin");
        int pin= scanner.nextInt();
        scanner.nextLine();

        return AccountController.checkBalance(accNo,pin);

    }
    public static int authUID() throws IllegalArgumentsExcept, SQLException, SQLExcept {
        int accNo;
        int pin;
        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Your Account Number");
             accNo=scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter pin");
             pin= scanner.nextInt();
            scanner.nextLine();


        }catch (IllegalArgumentException e){
            throw new IllegalArgumentsExcept(e.getMessage());
        }

        return AccountController.deposit(accNo,pin);

    }
    public static int authUIW() throws SQLException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Your Account Number");
        int accNo=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter pin");
        int pin= scanner.nextInt();
        scanner.nextLine();

        return AccountController.withdraw(accNo,pin);

    }
    public static int withdrawUI(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("How much do you want to withdraw???");
        int amount= scanner.nextInt();
        scanner.nextLine();
        return amount;
    }
    public static int depositUI(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("How much do you want to deposit???");
        int amount= scanner.nextInt();
        scanner.nextLine();
        return amount;

    }
}
