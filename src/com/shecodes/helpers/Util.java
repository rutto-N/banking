package com.shecodes.helpers;

import com.shecodes.enums.TypeOfAccount;
import com.shecodes.models.Account;
import com.shecodes.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Util {
    public static Account convertResultSetToAccount(ResultSet rs) throws SQLException {
        Account acc=new Account();
        acc.setAccountNumber(rs.getInt("accountNumber"));
        acc.setAccountName(rs.getString("accountName"));
        acc.setPin(rs.getInt("pin"));
        acc.setType(TypeOfAccount.valueOf(rs.getString("accountType")));
      return acc;
    }
    public static void loopArray(ArrayList<Customer> list){
        for (Customer c:list) {
            System.out.println(c);

        }
    }

}
