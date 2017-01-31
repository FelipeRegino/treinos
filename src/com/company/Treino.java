package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bruno on 30/01/2017.
 */
public class Treino {
    Corredor corredor;
    List<Corrida> listaCorridas;

    public void imprimirRelatorio(){
        System.out.println(this.corredor.nome);
        System.out.println(this.corredor.peso);
        System.out.println(this.corredor.altura);
        System.out.println(this.corredor.nivel);

        int contador = 0;
        float distanciaTotal = 0;
        double tempoTotal = 0;

        for (Corrida corrida: listaCorridas) {
            contador++;
            System.out.println("Dados da corrida nº" + contador + ":");
            System.out.println(corrida.dataInicio);
            System.out.println(corrida.distancia);
            System.out.println(corrida.tempo);
            System.out.print(corrida.dificuldade + "/n");

            distanciaTotal =+ corrida.distancia;
            tempoTotal =+ corrida.tempo;
        }

        System.out.println("Distância total percorrida: " + distanciaTotal);
        System.out.print("Tempo total gasto: " + tempoTotal + "/n");

        System.out.println("Distância média percorrida para corridas de dificuldade 1: " + CalcularDistanciaMedia(listarCorridasPorDificuldade(1)));
        System.out.print("Tempo médio gasto para corridas de dificuldade 1: " + CalcularTempoMedio(listarCorridasPorDificuldade(1)) + "/n");

        System.out.println("Distância média percorrida para corridas de dificuldade 2: " + CalcularDistanciaMedia(listarCorridasPorDificuldade(2)));
        System.out.print("Tempo médio gasto para corridas de dificuldade 2: " + CalcularTempoMedio(listarCorridasPorDificuldade(2)) + "/n");

        System.out.print("Distância média percorrida para corridas de dificuldade 3: " + CalcularDistanciaMedia(listarCorridasPorDificuldade(3)) + "/n");
        System.out.print("Tempo médio gasto para corridas de dificuldade 3: " + CalcularTempoMedio(listarCorridasPorDificuldade(3)) + "/n");
    }

    private float CalcularDistanciaMedia(List<Corrida> pListaCorrida){
        int contador = 0;
        float distanciaTotal = 0;

        for (Corrida corrida : pListaCorrida) {
            contador++;
            distanciaTotal =+ corrida.distancia;
        }

        return (distanciaTotal / contador);
    }

    private double CalcularTempoMedio(List<Corrida> pListaCorrida){
        int contador = 0;
        double tempoTotal = 0;

        for (Corrida corrida : pListaCorrida) {
            contador++;
            tempoTotal =+ corrida.tempo;
        }

        return (tempoTotal / contador);
    }

    private List<Corrida> listarCorridasPorDificuldade(int pDificuldade){
        List<Corrida> listaCorridas = new LinkedList<Corrida>();

        for (Corrida corrida : this.listaCorridas) {
            if(corrida.dificuldade == pDificuldade){
                listaCorridas.add(corrida);
            }
        }

        return listaCorridas;
    }

}
