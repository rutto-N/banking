package com.shecodes.exceptions;

public class ClassNotFoundExcept extends Exception {
    public ClassNotFoundExcept(String message) {
        System.out.println(message+" KIndly ensure youve added the MySQL jar file in your project libraries");
    }
}
