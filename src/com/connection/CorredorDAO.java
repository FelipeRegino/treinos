package com.connection;
import com.company.Corredor;

import java.sql.*;
import java.util.ArrayList;

public abstract class CorredorDAO {
	private Connection connection;
	
	public CorredorDAO() {
        try {
            new Connect();
			this.connection = Connect.connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO de conex�o: " + ex);
        } catch (SQLException ex) {
            System.out.println("ERRO de conex�o: " + ex);
        }
    }
	
	public void insere(Corredor corredor){
		String sql = "INSERT INTO `corredor` (`nome`, `peso`, `altura`, `nivel`) VALUES (?, ?, ?, ?);";
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
	
	public void atualiza(int id , Corredor corredor){
		String sql = "UPDATE `corredor` SET  `peso` = ?, `altura` = ?, `nivel` = ?, `nome` = ? WHERE idCorredor = ?";
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
	           System.out.println("ERRO ao inserir: " + e); 
	        }
	}
	
	public ArrayList<Corredor> pegaTodos(){
		ArrayList<Corredor> corredores = new ArrayList <Corredor>();
		String sql = "SELECT * FROM `corredor`";
		 try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet results = stmt.executeQuery();
	            while(results.next()){
	            	Corredor corredor = new Corredor(results.getString("nome"), results.getDouble("peso"), results.getDouble("altura"), results.getInt("nivel"));
	            	corredor.setId(results.getInt("idCorredor"));
	            	corredores.add(corredor);
	            }
	            
	            results.close();
	            stmt.close();
	            return corredores;
	        } catch (Exception e) {
	           throw new RuntimeException(e);
	        }
	}
	
	public void deleta(int id){
		String sql = "DELETE FROM `corredor` WHERE id = ?";
		try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
           System.out.println("ERRO ao inserir: " + e); 
        }
	}
}
