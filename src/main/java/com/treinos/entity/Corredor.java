package com.treinos.entity;
import com.treinos.connection.CorredorDAO;

import java.util.Objects;

public class Corredor extends CorredorDAO {
    private int id;
    private String nome;
    private double peso;
    private double altura;
    private int nivel;

    //region [ Construtores ]

    public Corredor(){
    }

    public Corredor(String nome, double peso, double altura, int nivel) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.nivel = nivel;
    }

    //endregion

    //region [ Getters & setters ]

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

    //endregion

    //Métodos utilizados para comparar objetos do mesmo tipo

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corredor corredor = (Corredor) o;
        return id == corredor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
