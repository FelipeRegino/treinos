package com.treinos.entity;
import java.util.Date;

import com.treinos.connection.CorridaDAO;

public class Corrida extends CorridaDAO {
	private int id;
    private Date dataInicio;
    private double distancia;
    private double tempo;
    private int dificuldade;
    
	public Corrida(Date dataInicio, double distancia, double tempo, int dificuldade) {
		this.dataInicio = dataInicio;
		this.distancia = distancia;
		this.tempo = tempo;
		this.dificuldade = dificuldade;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public double getDistancia() {
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
