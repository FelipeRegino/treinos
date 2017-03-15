package com.treinos.connection;
import java.sql.*;

public class Connect {
    private static Connection connection;
    private static final String CONNECTION_URL = "jdbc:mysql://localhost/treinos_db";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null){
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados realizada com sucesso.");
        }

        return connection;
    }

    public void closeConnection() throws SQLException {
        if(connection != null){
            connection.close();
            connection = null;
        }
    }

    public static void main(String[] args) {
        try {
            new Connect();
        } catch (Exception e) {
            System.out.println("ERRO de conexão: " + e);
        }
    }
}