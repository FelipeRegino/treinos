package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
    	Corredor corredor = new Corredor("Bruno", 75.0, 1.85, 1);
    	
//    	corredor.insere(corredor);
    	corredor.setAltura(2.00);
    	corredor.setPeso(180.0);
    	corredor.setNivel(20);
    	corredor.atualiza(5, corredor);
    	ArrayList<Corredor> results = new ArrayList<Corredor>();
    	results = corredor.pegaTodos();
    	for(Corredor result : results){
    		  System.out.println("ID: " + result.getId());
    		  System.out.println(result.getNome());
    		  System.out.println(result.getAltura());
    		  System.out.println(result.getPeso());
    		  System.out.println(result.getNivel());
    	}
    	
    }	

}
