package com.shecodes.exceptions;

public class IllegalArgumentsExcept extends Exception{
    public IllegalArgumentsExcept(String message) {
        System.out.println(message+" kindly check that you have entered correct data ");
    }
}
