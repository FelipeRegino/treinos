package com.company;
import com.connection.CorredorDAO;

public class Corredor extends CorredorDAO {
	private int id;
    private String nome;
    private double peso;
    private double altura;
    private int nivel;
	
    public Corredor(String nome, double peso, double altura, int nivel) {
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.nivel = nivel;
	}  
    
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	  
}
