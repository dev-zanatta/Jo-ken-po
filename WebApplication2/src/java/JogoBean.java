package com.example.beans;

import com.example.controller.JogoController;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;

@Named
@SessionScoped
public class JogoBean implements Serializable {
    private int escolhaJogador;
    private int escolhaComputador;
    private String resultado;
    private String jogadaJogador;
    private String jogadaComputador;
    private int numPartidas;
    private int numVitoriasJogador;
    private int numVitoriasComputador;
    private int numEmpates;
        
    public String jogar() {
        Random random = new Random();
        escolhaComputador = random.nextInt(3) + 1;
        return "resultado.xhtml"; 
    }
    
    public String jogarNovamente() {
        return "jogo.xhtml"; 
    }
    
    public int getEscolhaJogador() {
        return escolhaJogador;
    }
    
    public void setEscolhaJogador(int escolhaJogador) {
        this.escolhaJogador = escolhaJogador;
    }
    
    public int getEscolhaComputador() {
        return escolhaComputador;
    }

    public void setEscolhaComputador(int escolhaComputador) {
        this.escolhaComputador = escolhaComputador;
    }

    public String getOpcaoJogador() {
        if (escolhaJogador == 1) {
            return "Pedra";
        } else if (escolhaJogador == 2) {
            return "Papel";
        } else if (escolhaJogador == 3) {
            return "Tesoura";
        } else {
            return "Escolha Inválida";
        }
    }
    
    public String getOpcaoComputador() {
        if (escolhaComputador == 1) {
            return "Pedra";
        } else if (escolhaComputador == 2) {
            return "Papel";
        } else if (escolhaComputador == 3) {
            return "Tesoura";
        } else {
            return "Escolha Inválida";
        }
    }
    
    public String getResultado() {
        if (escolhaJogador == escolhaComputador) {
            resultado = "Empate";
            numEmpates++;
            
            JogoController.jogadores.get(JogoController.index).setNumEmpates(JogoController.jogadores.get(JogoController.index).getNumEmpates() + 1);
        } else if ((escolhaJogador == 1 && escolhaComputador == 3) ||
                   (escolhaJogador == 2 && escolhaComputador == 1) ||
                   (escolhaJogador == 3 && escolhaComputador == 2)) {
            resultado = "Você venceu";
            numVitoriasJogador++;
            JogoController.jogadores.get(JogoController.index).setNumVitorias(JogoController.jogadores.get(JogoController.index).getNumVitorias() + 1);
        } else {
            resultado = "Computador venceu";
            numVitoriasComputador++;
            
            JogoController.jogadores.get(JogoController.index).setNumDerrotas(JogoController.jogadores.get(JogoController.index).getNumDerrotas() + 1);
        }
        numPartidas++;
        JogoController.jogadores.get(JogoController.index).setNumJogos(JogoController.jogadores.get(JogoController.index).getNumJogos() + 1);

        return resultado;
    }
    
    public int getNumPartidas() {
        return numPartidas;
    }
    
    public int getNumVitoriasJogador() {
        return numVitoriasJogador;
    }
    
    public int getNumVitoriasComputador() {
        return numVitoriasComputador;
    }
    
    public int getNumEmpates() {
        return numEmpates;
    }
    
    public String getJogadaJogador() {
        if(this.escolhaJogador == 1) {
            return "pedra_jogador";
        } else if(this.escolhaJogador == 2) {
            return "papel_jogador";
        } else if(this.escolhaJogador == 3) {
            return "tesoura_jogador";
        }
        return "";
    }

    public String getJogadaComputador() {
        if(this.escolhaComputador == 1) {
            return "pedra_computador";
        } else if(this.escolhaComputador == 2) {
            return "papel_computador";
        } else if(this.escolhaComputador == 3) {
            return "tesoura_computador";
        }
        return "";
    }
}
