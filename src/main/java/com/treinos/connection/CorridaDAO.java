package com.treinos.connection;
import java.sql.*;
import java.util.ArrayList;
import com.treinos.entity.Corrida;

public abstract class CorridaDAO {
	private Connection connection;
	
	public CorridaDAO() {
        try {
            new Connect();
			this.connection = Connect.getConnection();
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO de conexão: " + ex);
        } catch (SQLException ex) {
            System.out.println("ERRO de conexão: " + ex);
        }
    }
	
	public void insere(Corrida corrida){
		String sql = "INSERT INTO `corrida` (`data`, `distancia`, `tempo`, `dificuldade`) VALUES (?, ?, ?, ?);";
		 try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setDate(1, (Date) corrida.getDataInicio());
	            stmt.setDouble(2, corrida.getDistancia());
	            stmt.setDouble(3, corrida.getTempo());
	            stmt.setInt(4, corrida.getDificuldade());
	            stmt.execute();
	            stmt.close();
	        } catch (Exception e) {
	           System.out.println("ERRO ao inserir: " + e); 
	        } 
	}
	
	public ArrayList<Corrida> pegaTodos(){
		ArrayList<Corrida> corridas = new ArrayList <Corrida>();
		String sql = "SELECT * FROM `corrida`";
		 try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet results = stmt.executeQuery();
	            while(results.next()){
	            	Corrida corrida = new Corrida(results.getDate("data"), results.getDouble("distancia"), results.getDouble("tempo"), results.getInt("dificuldade"));
	            	corrida.setId(results.getInt("idCorrida"));
	            	corridas.add(corrida);
	            }
	            
	            results.close();
	            stmt.close();
	            return corridas;
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
