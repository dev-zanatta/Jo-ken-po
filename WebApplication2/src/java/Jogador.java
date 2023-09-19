package com.example.model;

import java.io.Serializable;

public class Jogador implements Serializable {
    private String nome;
    private int numJogos;
    private int numVitorias;
    private int numEmpates;
    private int numDerrotas;
    
    public Jogador(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumJogos() {
        return numJogos;
    }

    public void setNumJogos(int numJogos) {
        this.numJogos = numJogos;
    }

    public int getNumVitorias() {
        return numVitorias;
    }

    public void setNumVitorias(int numVitorias) {
        this.numVitorias = numVitorias;
    }

    public int getNumEmpates() {
        return numEmpates;
    }

    public void setNumEmpates(int numEmpates) {
        this.numEmpates = numEmpates;
    }

    public int getNumDerrotas() {
        return numDerrotas;
    }

    public void setNumDerrotas(int numDerrotas) {
        this.numDerrotas = numDerrotas;
    }
    
    
}
