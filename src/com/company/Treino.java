package com.company;

import java.util.LinkedList;
import java.util.List;


public class Treino {
    Corredor corredor;
    List<Corrida> listaCorridas;

    public void imprimirRelatorio(){
        System.out.println(this.corredor.getNome());
        System.out.println(this.corredor.getPeso());
        System.out.println(this.corredor.getAltura());
        System.out.println(this.corredor.getNivel());

        int contador = 0;
        float distanciaTotal = 0;
        double tempoTotal = 0;

        for (Corrida corrida: listaCorridas) {
            contador++;
            System.out.println("Dados da corrida nº" + contador + ":");
            System.out.println(corrida.getDataInicio());
            System.out.println(corrida.getDistancia());
            System.out.println(corrida.getTempo());
            System.out.print(corrida.getDificuldade() + "/n");

            distanciaTotal =+ corrida.getDistancia();
            tempoTotal =+ corrida.getTempo();
        }

        System.out.println("Distância total percorrida: " + distanciaTotal);
        System.out.print("Tempo total gasto: " + tempoTotal + "/n");

        System.out.println("Distância média percorrida para corridas de dificuldade 1: " + CalcularDistanciaMedia(ListarCorridasPorDificuldade(1)));
        System.out.print("Tempo médio gasto para corridas de dificuldade 1: " + CalcularTempoMedio(ListarCorridasPorDificuldade(1)) + "/n");

        System.out.println("Distância média percorrida para corridas de dificuldade 2: " + CalcularDistanciaMedia(ListarCorridasPorDificuldade(2)));
        System.out.print("Tempo médio gasto para corridas de dificuldade 2: " + CalcularTempoMedio(ListarCorridasPorDificuldade(2)) + "/n");

        System.out.print("Distância média percorrida para corridas de dificuldade 3: " + CalcularDistanciaMedia(ListarCorridasPorDificuldade(3)) + "/n");
        System.out.print("Tempo médio gasto para corridas de dificuldade 3: " + CalcularTempoMedio(ListarCorridasPorDificuldade(3)) + "/n");
    }

    private float CalcularDistanciaMedia(List<Corrida> pListaCorrida){
        int contador = 0;
        float distanciaTotal = 0;

        for (Corrida corrida : pListaCorrida) {
            contador++;
            distanciaTotal =+ corrida.getDistancia();
        }

        return (distanciaTotal / contador);
    }

    private double CalcularTempoMedio(List<Corrida> pListaCorrida){
        int contador = 0;
        double tempoTotal = 0;

        for (Corrida corrida : pListaCorrida) {
            contador++;
            tempoTotal =+ corrida.getTempo();
        }

        return (tempoTotal / contador);
    }

    private List<Corrida> ListarCorridasPorDificuldade(int pDificuldade){
        List<Corrida> listaCorridasN1 = new LinkedList<Corrida>();

        for (Corrida corrida : listaCorridas) {
            if(corrida.getDificuldade() == 1){
                listaCorridasN1.add(corrida);
            }
        }

        return listaCorridasN1;
    }

    private List<Corrida> listarCorridasNivel2(){
        List<Corrida> listaCorridasN2 = new LinkedList<Corrida>();

        for (Corrida corrida : listaCorridas) {
            if(corrida.getDificuldade() == 2){
                listaCorridasN2.add(corrida);
            }
        }

        return listaCorridasN2;
    }

    private List<Corrida> listarCorridasNivel3(){
        List<Corrida> listaCorridasN3 = new LinkedList<Corrida>();

        for (Corrida corrida : listaCorridas) {
            if(corrida.getDificuldade() == 2){
                listaCorridasN3.add(corrida);
            }
        }

        return listaCorridasN3;
    }

}
