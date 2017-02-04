package com.company;

import java.util.Date;

public class Corrida {
    private Date dataInicio;
    private float distancia;
    private double tempo;
    private int dificuldade;
    
	public Corrida(Date dataInicio, float distancia, double tempo, int dificuldade) {
		this.dataInicio = dataInicio;
		this.distancia = distancia;
		this.tempo = tempo;
		this.dificuldade = dificuldade;
	}

	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public double getTempo() {
		return tempo;
	}
	public void setTempo(double tempo) {
		this.tempo = tempo;
	}
	public int getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
}
