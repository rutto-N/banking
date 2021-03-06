package com.shecodes.views;

import com.shecodes.models.Customer;
import com.shecodes.models.Staff;

import java.util.Scanner;

public class StaffView {
    static Scanner scanner=new Scanner(System.in);


    public static Staff getStaffDetailsUI(){
    Staff staff =new Staff();
    System.out.println("Staff Name");
    staff.setName(scanner.nextLine());
    System.out.println("Staff ID");
    staff.setId(scanner.nextLine());
    System.out.println("Staff branch");
    staff.setBranch(scanner.nextLine());
    System.out.println(staff);
    return staff;
    }
    public static Customer getCustomerDetailsUI(){
        Customer customer=new Customer();
        System.out.println("Customer Name");
        customer.setName(scanner.nextLine());
        System.out.println("Customer ID");
        customer.setNationalId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Customer email");
        customer.setEmailAddress(scanner.nextLine());
        System.out.println("Customer residence");
        customer.setResidence(scanner.nextLine());
        return customer;
    }
    public static int deleteStaffUI(){
        System.out.println("Enter staff id of the staff to delete");
        int id= scanner.nextInt();
        scanner.nextLine();
        return id;

    }
    @Override
    protected void finalize() throws Throwable {
        scanner.close();
    }





}
