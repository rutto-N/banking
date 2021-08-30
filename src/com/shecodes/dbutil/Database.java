package com.shecodes.dbutil;

import java.sql.*;
import java.util.Scanner;

public class Database {

    public Database() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

    }

    public Connection connection(){
        try {
            String url = "jdbc:mysql://localhost:3306/banking";
            String user = "root";
            String password = "";
            Connection conn= DriverManager.getConnection(url,
                    user, password);
            return conn;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    public int writeData(String q) throws SQLException {
        Connection conn=connection();
        Statement statement=conn.createStatement();

        return statement.executeUpdate(q);

    }
    public ResultSet readData(String q) throws SQLException {
        Connection conn=connection();
        Statement statement=conn.createStatement();

        return statement.executeQuery(q);

    }

    public void closeConnection() throws SQLException {
        connection().close();
    }

    @Override
    protected void finalize() throws Throwable {
        closeConnection();
    }
}
