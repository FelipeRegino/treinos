package com.treinos.connection;
import com.treinos.entity.Corredor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Corredor corredor = new Corredor("Bruno", 75.0, 1.85, 1);

        //corredor.inserir(corredor);
        corredor.setAltura(2.00);
        corredor.setPeso(180.0);
        corredor.setNivel(20);
        corredor.atualizar(5, corredor);

        List<Corredor> results = corredor.obterTodos();

        for(Corredor result : results){
            System.out.println("ID: " + result.getId());
            System.out.println(result.getNome());
            System.out.println(result.getAltura());
            System.out.println(result.getPeso());
            System.out.println(result.getNivel());
        }

    }

}
