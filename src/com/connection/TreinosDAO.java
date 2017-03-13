package com.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.Corredor;
import com.company.Corrida;

public class TreinosDAO {
	private Connection connection;
	
	public TreinosDAO() {
        try {
            new Connect();
			this.connection = Connect.connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO de conex�o: " + ex);
        } catch (SQLException ex) {
            System.out.println("ERRO de conex�o: " + ex);
        }
    }
	
	public void insere(Corredor corredor, ArrayList<Corrida> corridas){
		for(Corrida corrida : corridas){
		
			String sql = "INSERT INTO `treinos` (`corredor`, `corrida`) VALUES (?, ?);";
			 try {
		            PreparedStatement stmt = connection.prepareStatement(sql);
		            stmt.setInt(1, corredor.getId());
		            stmt.setInt(2, corrida.getId());
		            stmt.execute();
		            stmt.close();
		        } catch (Exception e) {
		           System.out.println("ERRO ao inserir: " + e); 
		        }
		}
	}
	
	public ArrayList<Corrida> pegaCorridas(int idCorredor){
		ArrayList<Corrida> corridas = new ArrayList <Corrida>();
		CorridaDAO corrida = new CorridaDAO();
		String sql = "SELECT corrida FROM `treinos` WHERE corredor = ? ORDER BY corrida ASC";
		 try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, idCorredor);
	            ResultSet results = stmt.executeQuery();
	            while(results.next()){
	            	corridas.add(corrida.pegaPorId(results.getInt("corrida")));
	            }    
	            results.close();
	            stmt.close();
	            return corridas;
	        } catch (Exception e) {
	           throw new RuntimeException(e);
	        }	
	}
	
}
