package com.shecodes.controllers;

import com.shecodes.dbutil.Database;
import com.shecodes.exceptions.ClassNotFoundExcept;
import com.shecodes.exceptions.SQLExcept;
import com.shecodes.models.Customer;
import com.shecodes.models.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffController {
    static Database db;

    static {
        try {
            db = new Database();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }


    public static boolean addCustomer(Customer customer) throws SQLExcept {
        boolean exist;
        exist = customerExists(customer);
        if (!exist){
            String s="INSERT INTO `customers`(`name`, `emailAddress`, `NationalId`, `residence`) VALUES" +
                    "('"+customer.getName()+"','"+customer.getEmailAddress()+"','"+customer.getNationalId()+"','"+customer.getResidence()+"')";
            int x;
            try {
                x = db.execute(s);
            } catch (SQLException e) {
                throw new SQLExcept(e.getMessage());

            }
            if (x==1){
//                System.out.println("Customer account created Successfully");
                return true;
            }else {
                System.out.println("Customer account not created");
                return false;}

        }else {
            System.out.println("Customer already Exists");

        }
        return false;
    }
    public static boolean addStaff(Staff staff) throws SQLExcept {
        String s="INSERT INTO `staff`(`name`, `staffId`, `branch`) VALUES('"+staff.getName()+"','"+staff.getId()+"','"+staff.getBranch()+"')";
        int x= 0;
        try {
            x = db.execute(s);
        } catch (SQLException e) {
            throw new SQLExcept(e.getMessage());
        }
        if (x==1){
            System.out.println("Staff account created Successfully");
            return true;
        }else {
            System.out.println("Staff account not created");
            return false;
        }
    }
    public static ArrayList<Customer> viewCustomers() throws SQLExcept {
        ArrayList<Customer> customers=new ArrayList<>();
        String s="SELECT * FROM customers";
        ResultSet rs= null;
        try {
            rs = db.executeSelect(s);

        while (rs.next()){
            Customer customer= convertStringToCustomer(rs);
            customers.add(customer);
        }
        }catch (SQLException e){
            throw new SQLExcept(e.getMessage());

        }
        return customers;
    }
    public static boolean customerExists(Customer customer) throws SQLExcept {
        String s="SELECT * FROM customers WHERE nationalId="+customer.getNationalId();
        try {
            ResultSet rs=db.executeSelect(s);
            if (rs.next()){
                System.out.println("Customer already has another Account");
                return true;
            }

        }catch (SQLException e){
            throw new SQLExcept(e.getMessage());

        }

        return  false;

    }
    public static Customer convertStringToCustomer(ResultSet rs) throws SQLExcept {
        Customer customer=new Customer();
        try {
            customer.setName(rs.getString("name"));
            customer.setEmailAddress(rs.getString("emailAddress"));
            customer.setNationalId(rs.getInt("NationalId"));
            customer.setResidence(rs.getString("residence"));

        }catch (SQLException e){
            throw new SQLExcept(e.getMessage());
        }

        return customer;
    }
    public static Staff searchStaff(int id) throws ClassNotFoundException, SQLException, SQLExcept {

        Database db=new Database();
        Staff staff=new Staff();
        String s="SELECT * FROM staff WHERE staffId="+id;
        ResultSet rs =db.executeSelect(s);
        while (rs.next()){
            staff= StaffController.convertStringToStaff(rs);

        }
        return staff;

    }
    public static boolean deleteStaff(int id) throws SQLException, SQLExcept, ClassNotFoundException {
        Database db=new Database();
        Staff staff=searchStaff(id);
        String s="DELETE FROM staff WHERE staffId="+staff.getId();
        int x=db.execute(s);
        if (x==1){
            System.out.println("Staff Deleted Successfully");
            return true;
        }
        return false;

    }
    public static Staff convertStringToStaff(ResultSet rs) throws SQLExcept {
        Staff staff=new Staff();
        try {
            staff.setName(rs.getString("name"));
            staff.setId(rs.getString("staffId"));
            staff.setBranch(rs.getString("branch"));

        }catch (SQLException e){
            throw new SQLExcept(e.getMessage());
        }

        return staff;
    }





}
