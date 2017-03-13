package com.connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import com.company.Corrida;

public class CorridaDAO {
	private Connection connection;
	
	public CorridaDAO() {
        try {
            new Connect();
			this.connection = Connect.connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO de conex�o: " + ex);
        } catch (SQLException ex) {
            System.out.println("ERRO de conex�o: " + ex);
        }
    }
	
	public void insere(Corrida corrida){
		String sql = "INSERT INTO `corrida` (`data`, `distancia`, `tempo`, `dificuldade`) VALUES (?, ?, ?, ?);";
		 try {
	            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            stmt.setDate(1, (java.sql.Date) corrida.getDataInicio());
	            stmt.setDouble(2, corrida.getDistancia());
	            stmt.setDouble(3, corrida.getTempo());
	            stmt.setInt(4, corrida.getDificuldade());
	            stmt.execute();
	            ResultSet rs = stmt.getGeneratedKeys();
	            if(rs.next()){
                    int last_inserted_id = rs.getInt(1);
                    corrida.setId(last_inserted_id);
                }
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
	
	public Corrida pegaPorId(int id){
		 
		Date dataInicio = null;
		int idCorrida = 0;
	    double distancia = 0.0;
	    double tempo = 0.0;
	    int dificuldade = 0;
		
		String sql = "SELECT * FROM `corrida` WHERE idCorrida = ?";
		 try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, id);
	            ResultSet results = stmt.executeQuery();
	            while(results.next()){
	            	idCorrida = results.getInt("idCorrida");
	        	    distancia = results.getDouble("distancia");
	        	    tempo = results.getDouble("tempo");
	        	    dificuldade = results.getInt("dificuldade");
	        	    dataInicio = results.getDate("data");
	            }
	            Corrida corrida = new Corrida(dataInicio, distancia, tempo, dificuldade);
	            corrida.setId(idCorrida);
	            results.close();
	            stmt.close();
	            return corrida;
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
