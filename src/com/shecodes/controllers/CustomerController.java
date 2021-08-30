package com.shecodes.controllers;

import com.shecodes.dbutil.Database;
import com.shecodes.exceptions.SQLExcept;
import com.shecodes.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController {
    static Database db;
    static {
        try {
            db = new Database();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
    public static Customer searchCustomer(int id) throws SQLException {

        Customer customer=new Customer();
        String s="SELECT * FROM customers WHERE NationalId="+id;
        ResultSet rs =db.readData(s);
        while (rs.next()){
            customer= StaffController.convertResultSetToCustomer(rs);

        }
        return customer;

    }
    public static boolean deleteCustomer(int id) throws SQLException {
        Customer customer=searchCustomer(id);
        String s="DELETE FROM customers WHERE NationalId="+customer.getNationalId();
        int x=db.writeData(s);
        if (x==1){
            System.out.println("Customer Deleted Successfully");
            return true;
        }
        return false;

    }


}
