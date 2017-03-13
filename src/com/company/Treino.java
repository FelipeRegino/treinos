package com.company;

import java.util.ArrayList;

import com.connection.TreinosDAO;

public class Treino extends TreinosDAO{
    private Corredor corredor;
    private ArrayList<Corrida> listaCorridas;
    
    public Corredor getCorredor() {
		return corredor;
	}

	public void setCorredor(Corredor corredor) {
		this.corredor = corredor;
	}

	public ArrayList<Corrida> getListaCorridas() {
		return listaCorridas;
	}

	public void setListaCorridas(ArrayList<Corrida> listaCorridas) {
		this.listaCorridas = listaCorridas;
	}

	public void ImprimirRelatorio(){
		System.out.println("Corredor:");
        System.out.println("Nome: " + this.corredor.getNome());
        System.out.println("Peso: " + this.corredor.getPeso() + "Kg");
        System.out.println("Altura: " + this.corredor.getAltura()+ "m");
        System.out.println("Nivel: " + this.corredor.getNivel());

        int contador = 0;
        double distanciaTotal = 0;
        double tempoTotal = 0;

        for (Corrida corrida: listaCorridas) {
            contador++;
            System.out.println("Dados da corrida nº" + contador + ":");
            System.out.println("Data: " + corrida.getDataInicio());
            System.out.println("Distancia: " + corrida.getDistancia() + "Km");
            System.out.println("Tempo: " + corrida.getTempo() + "horas");
            System.out.println("Dificuldade: " + corrida.getDificuldade());

            distanciaTotal =+ corrida.getDistancia();
            tempoTotal =+ corrida.getTempo();
        }

        System.out.println("Distância total percorrida: " + distanciaTotal);
        System.out.println("Tempo total gasto: " + tempoTotal);

        System.out.println("Distância média percorrida para corridas de dificuldade 1: " + CalcularDistanciaMedia(ListarCorridasPorDificuldade(1)));
        System.out.println("Tempo médio gasto para corridas de dificuldade 1: " + CalcularTempoMedio(ListarCorridasPorDificuldade(1)));

        System.out.println("Distância média percorrida para corridas de dificuldade 2: " + CalcularDistanciaMedia(ListarCorridasPorDificuldade(2)));
        System.out.println("Tempo médio gasto para corridas de dificuldade 2: " + CalcularTempoMedio(ListarCorridasPorDificuldade(2)));

        System.out.println("Distância média percorrida para corridas de dificuldade 3: " + CalcularDistanciaMedia(ListarCorridasPorDificuldade(3)));
        System.out.println("Tempo médio gasto para corridas de dificuldade 3: " + CalcularTempoMedio(ListarCorridasPorDificuldade(3)));
    }

    private double CalcularDistanciaMedia(ArrayList<Corrida> pListaCorrida){
        int contador = 0;
        double distanciaTotal = 0;

        for (Corrida corrida : pListaCorrida) {
            contador++;
            distanciaTotal =+ corrida.getDistancia();
        }

        return (distanciaTotal / contador);
    }

    private double CalcularTempoMedio(ArrayList<Corrida> pListaCorrida){
        int contador = 0;
        double tempoTotal = 0;

        for (Corrida corrida : pListaCorrida) {
            contador++;
            tempoTotal =+ corrida.getTempo();
        }

        return (tempoTotal / contador);
    }

    private ArrayList<Corrida> ListarCorridasPorDificuldade(int pDificuldade){
        ArrayList<Corrida> listaCorridas = new ArrayList<Corrida>();

        for (Corrida corrida : this.listaCorridas) {
            if(corrida.getDificuldade() == pDificuldade){
                listaCorridas.add(corrida);
            }
        }

        return listaCorridas;
    }

}
