package com.shecodes.views;

import com.shecodes.controllers.StaffController;
import com.shecodes.dbutil.Database;
import com.shecodes.enums.TypesOfAccount;
import com.shecodes.exceptions.AccountTypeExcept;
import com.shecodes.helpers.Util;
import com.shecodes.models.Account;
import com.shecodes.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import static com.shecodes.helpers.Util.convertStringToCustomer;

public class CustomerViews {
    public static Account getAccountDetailsUI() throws AccountTypeExcept {
//        searchCustomer(id);
        Account acc=new Account();
        Scanner scanner=new Scanner(System.in);
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
        acc.setType(TypesOfAccount.valueOf(scanner.nextLine()));
        }catch (Exception e){
            throw new AccountTypeExcept(e.getMessage());
        }
//        System.out.println("ID Number");
//        acc.setId(scanner.nextInt());
//        scanner.nextLine();
        return acc;

    }


}
