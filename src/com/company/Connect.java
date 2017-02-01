package com.company;
import java.sql.*;

public class Connect {
	public static Connection connection;
    
    public Connect() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/treinos_db", "root", "");
        System.out.println("Conexão com banco de dados realizada");
    }
    
    public static void main(String[] args) {
        try {
            new Connect();
        } catch (Exception e) {
            System.out.println("ERRO de conexão: " + e);
        }
    }
}