package com.shecodes.views;

import com.shecodes.models.Customer;
import com.shecodes.models.Staff;

import java.util.Scanner;

public class StaffViews {


    public static Staff getStaffDetailsUI(){
    Staff staff =new Staff();
    Scanner scanner=new Scanner(System.in);
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
        Scanner scanner=new Scanner(System.in);
        System.out.println("Customer Name");
        customer.setName(scanner.nextLine());
        System.out.println("Customer ID");
        customer.setNationalId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Customer email");
        customer.setEmailAddress(scanner.nextLine());
        System.out.println("Customer residence");
        customer.setResidence(scanner.nextLine());
        System.out.println(customer);
        return customer;
    }





}
