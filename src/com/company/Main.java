package com.company;
import java.util.ArrayList;

import com.connection.TreinosDAO;

public class Main {

    public static void main(String[] args){
    	Corredor corredor = new Corredor("Bruno", 75.0, 1.85, 1);
    	
//    	corredor.insere(corredor);
//    	corredor.setAltura(2.00);
//    	corredor.setPeso(180.0);
//    	corredor.setNivel(20);
//    	corredor.atualiza(5, corredor);
//    	ArrayList<Corredor> results = new ArrayList<Corredor>();
//    	results = corredor.pegaTodos();
//    	for(Corredor result : results){
//    		  System.out.println("ID: " + result.getId());
//    		  System.out.println(result.getNome());
//    		  System.out.println(result.getAltura());
//    		  System.out.println(result.getPeso());
//    		  System.out.println(result.getNivel());
//    	}
    	
//    	corredor.insere(corredor);
//    	Corredor corredor2 = corredor.pegaPorId(corredor.getId());
//    	System.out.println("ID: " + corredor2.getId());
//		System.out.println(corredor2.getNome());
//		System.out.println(corredor2.getAltura());
//		System.out.println(corredor2.getPeso());
//		System.out.println(corredor2.getNivel());
//    	TreinosDAO treinos = new TreinosDAO();
//    	ArrayList<Corrida> results = new ArrayList<Corrida>();
//    	results = treinos.pegaCorridas(5);
//    	
//    	for(Corrida result : results){
//		  System.out.println("ID: " + result.getId());
//		  System.out.println(result.getDistancia());
//		  System.out.println(result.getTempo());
//		  System.out.println(result.getDataInicio());
//		  System.out.println(result.getDificuldade());
//		}
    	
    	Treino treino = new Treino();
    	treino.setCorredor(corredor.pegaPorId(5));
    	treino.setListaCorridas(treino.pegaCorridas(treino.getCorredor().getId()));
    	
    	treino.ImprimirRelatorio();
    }	

}
