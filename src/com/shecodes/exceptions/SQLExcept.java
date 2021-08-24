package com.shecodes.exceptions;

public class SQLExcept extends Exception{
    public SQLExcept(String message) {
        System.out.println(message+" There is an error with your SQL query");
    }
}
