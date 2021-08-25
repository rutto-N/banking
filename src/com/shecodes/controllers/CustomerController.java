package com.shecodes.controllers;

import com.shecodes.dbutil.Database;
import com.shecodes.exceptions.SQLExcept;
import com.shecodes.helpers.Util;
import com.shecodes.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController {
    public static Customer searchCustomer(int id) throws ClassNotFoundException, SQLException, SQLExcept {

        Database db=new Database();
        Customer customer=new Customer();
        String s="SELECT * FROM customers WHERE NationalId="+id;
        ResultSet rs =db.executeSelect(s);
        while (rs.next()){
            customer= StaffController.convertStringToCustomer(rs);

        }
        return customer;

    }
    public static boolean deleteCustomer(int id) throws SQLException, SQLExcept, ClassNotFoundException {
        Database db=new Database();
        Customer customer=searchCustomer(id);
        String s="DELETE FROM customers WHERE NationalId="+customer.getNationalId();
        int x=db.execute(s);
        if (x==1){
            System.out.println("Customer Deleted Successfully");
            return true;
        }
        return false;

    }


}
