package com.example.controller;

import com.example.model.Jogador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class JogoController implements Serializable {
    private int escolhaJogador;
    private int escolhaComputador;
    private String resultado;
    private int numPartidas;
    private int numVitoriasJogador;
    private int numVitoriasComputador;
    private int numEmpates;
    public static List<Jogador> jogadores = new ArrayList<>();
    public static int index;

    public int getNumPartidas() {
        return numPartidas;
    }

    public void setNumPartidas(int numPartidas) {
        this.numPartidas = numPartidas;
    }

    public int getNumVitoriasJogador() {
        return numVitoriasJogador;
    }

    public void setNumVitoriasJogador(int numVitoriasJogador) {
        this.numVitoriasJogador = numVitoriasJogador;
    }

    public int getNumVitoriasComputador() {
        return numVitoriasComputador;
    }

    public void setNumVitoriasComputador(int numVitoriasComputador) {
        this.numVitoriasComputador = numVitoriasComputador;
    }

    public int getNumEmpates() {
        return numEmpates;
    }

    public void setNumEmpates(int numEmpates) {
        this.numEmpates = numEmpates;
    }
}
