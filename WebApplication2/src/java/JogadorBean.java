import com.example.controller.JogoController;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import com.example.model.Jogador;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
@Named
@SessionScoped
public class JogadorBean implements Serializable {
    private String nome;
    
    @Inject
    private JogoController jogoController;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
    public String entrarNoJogo() {
        boolean exists = false;
        JogoController.index = 0;
        for (Jogador existingJogador : JogoController.jogadores) {
            if (existingJogador.getNome().equals(this.nome)) {
                exists = true;
                break;
            }
            JogoController.index++;
        }

        if (!exists) {
            JogoController.jogadores.add(new Jogador(this.nome));
        } 
  
        return "jogo.xhtml"; 
    }
    
    
    public List<Jogador> getJogadores() {
        return JogoController.jogadores;
    }

    public String verEstatisticas() {
        return "estatisticas.xhtml";
    }
    
    public void zerarLista() {
        JogoController.jogadores = new ArrayList<>();
        jogoController.setNumVitoriasJogador(0);
        jogoController.setNumVitoriasComputador(0);
        jogoController.setNumEmpates(0);
        jogoController.setNumPartidas(0);
    }
    
    public void zerarMinhasEstatisticas() {
        for (Jogador jogador : jogoController.jogadores) {
            if (jogador.getNome().equals(this.nome)) {
                jogador.setNumJogos(0);
                jogador.setNumVitorias(0);
                jogador.setNumDerrotas(0);
                jogador.setNumEmpates(0);
                break;
            }
        }
    }

}
