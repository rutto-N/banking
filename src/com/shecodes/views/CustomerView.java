package com.shecodes.views;

import com.shecodes.enums.TypeOfAccount;
import com.shecodes.exceptions.AccountTypeExcept;
import com.shecodes.models.Account;

import java.util.Scanner;

//import static com.shecodes.helpers.Util.convertStringToCustomer;

public class CustomerView {
    static  Scanner scanner=new Scanner(System.in);
    public static Account getAccountDetailsUI()  {
        Account acc=new Account();

        System.out.println("Account Name");
        acc.setAccountName(scanner.nextLine());
        System.out.println("Account Number");
        acc.setAccountNumber(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Set pin");
        acc.setPin(scanner.nextInt());
        scanner.nextLine();
        try{
        System.out.println("Account Type");
        acc.setType(TypeOfAccount.valueOf(scanner.nextLine()));
        }catch (Exception e){
            e.printStackTrace();
        }


        return acc;

    }

    public static int deleteCustomerUI(){

        System.out.println("Enter national id of the customer to delete");
        int id= scanner.nextInt();
        scanner.nextLine();

        return id;

    }

    @Override
    protected void finalize() throws Throwable {
        scanner.close();
    }
}
