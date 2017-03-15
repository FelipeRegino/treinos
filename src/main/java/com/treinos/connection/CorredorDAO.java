package com.treinos.connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.treinos.entity.Corredor;

public abstract class CorredorDAO {
    private Connection connection;

    public CorredorDAO() {
        try {
            new Connect();
            this.connection = Connect.getConnection();
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO de conexão: " + ex);
        } catch (SQLException ex) {
            System.out.println("ERRO de conexão: " + ex);
        }
    }

    public void inserir(Corredor corredor){
        String sql = "INSERT INTO `treinos_db`.`corredor` (`nome`, `peso`, `altura`, `nivel`) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, corredor.getNome());
            stmt.setDouble(2, corredor.getPeso());
            stmt.setDouble(3, corredor.getAltura());
            stmt.setInt(4, corredor.getNivel());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            System.out.println("ERRO ao inserir: " + e);
        }
    }

    public void atualizar(int id , Corredor corredor){
        String sql = "UPDATE `treinos_db`.`corredor` SET  `peso` = ?, `altura` = ?, `nivel` = ?, `nome` = ? WHERE idCorredor = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(5, id);
            stmt.setString(4, corredor.getNome());
            stmt.setDouble(1, corredor.getPeso());
            stmt.setDouble(2, corredor.getAltura());
            stmt.setInt(3, corredor.getNivel());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            System.out.println("ERRO ao atualizar: " + e);
        }
    }

    public void deletar(int id){
        String sql = "DELETE FROM `treinos_db`.`corredor` WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            System.out.println("ERRO ao deletar: " + e);
        }
    }

    public List<Corredor> obterTodos(){
        List<Corredor> listaCorredores = new ArrayList <Corredor>();
        String sql = "SELECT * FROM `treinos_db`.`corredor`";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet results = stmt.executeQuery();

            while(results.next()){
                Corredor corredor = new Corredor(results.getString("nome"), results.getDouble("peso"),
                        results.getDouble("altura"), results.getInt("nivel"));
                corredor.setId(results.getInt("idCorredor"));
                listaCorredores.add(corredor);
            }

            results.close();
            stmt.close();

            return listaCorredores;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
