import java.lang.reflect.Array;
import java.util.ArrayList;

public class Minimax {

    public Estado max(Estado estado){
        //verifica estado terminal
        char terminal = estadoTerminal(estado);
        if(terminal == 'X') estado.setFator(1);
        if(terminal == 'O') estado.setFator(-1);
        if(terminal == 'E') estado.setFator(0);
        if(terminal != 'F') return estado;

        ArrayList<Estado> filhos = geraFilhos(estado, 'X');
        int best = -9999;
        Estado estadoFinal = null;
        for (Estado filho : filhos) {
            Estado estadoMin = min(filho);
            if(estadoMin.getFator() > best){
                best = estadoMin.getFator();
                estadoFinal = estadoMin;
            }
        }
        return estadoFinal;
    }

    public Estado min(Estado estado){
        //verifica estado terminal
        char terminal = estadoTerminal(estado);
        if(terminal == 'X') estado.setFator(1);
        if(terminal == 'O') estado.setFator(-1);
        if(terminal == 'E') estado.setFator(0);
        if(terminal != 'F') return estado;;

        ArrayList<Estado> filhos = geraFilhos(estado, 'O');
        int best = 9999;
        Estado estadoFinal = null;
        for (Estado filho : filhos) {
            Estado estadoMax = max(filho);
            if(estadoMax.getFator() < best){
                best = estadoMax.getFator();
                estadoFinal = estadoMax;
            }
        }
        return estadoFinal;
    }

    public Estado maior(Estado a, Estado b){
        if(a.getFator()>b.getFator()) return a;
        return b;
    }

    public Estado menor(Estado a, Estado b){
        if(a.getFator()<b.getFator()) return a;
        return b;
    }

    public ArrayList<Estado> geraFilhos(Estado estado, char jogada){
        ArrayList<Estado> filhos = new ArrayList<>();
        for (int i=0; i<9; i++){ //gerar cada filho
            if(estado.getTabuleiro()[i]==' '){
                char [] tabuleiro = copiaTab(estado.getTabuleiro());
                tabuleiro[i] = jogada;
                filhos.add(new Estado(tabuleiro, estado));
            }
        }
        return filhos;
    }

    public char estadoTerminal(Estado estado){
        if(estado.getTabuleiro()[0] == estado.getTabuleiro()[1] && estado.getTabuleiro()[0] == estado.getTabuleiro()[2] && estado.getTabuleiro()[0]!=' ') return estado.getTabuleiro()[0];
        if(estado.getTabuleiro()[3] == estado.getTabuleiro()[4] && estado.getTabuleiro()[3] == estado.getTabuleiro()[5] && estado.getTabuleiro()[3]!=' ') return estado.getTabuleiro()[3];
        if(estado.getTabuleiro()[6] == estado.getTabuleiro()[7] && estado.getTabuleiro()[6] == estado.getTabuleiro()[8] && estado.getTabuleiro()[6]!=' ') return estado.getTabuleiro()[6];
        if(estado.getTabuleiro()[0] == estado.getTabuleiro()[3] && estado.getTabuleiro()[0] == estado.getTabuleiro()[6] && estado.getTabuleiro()[0]!=' ') return estado.getTabuleiro()[0];
        if(estado.getTabuleiro()[1] == estado.getTabuleiro()[4] && estado.getTabuleiro()[1] == estado.getTabuleiro()[7] && estado.getTabuleiro()[1]!=' ') return estado.getTabuleiro()[1];
        if(estado.getTabuleiro()[2] == estado.getTabuleiro()[5] && estado.getTabuleiro()[2] == estado.getTabuleiro()[8] && estado.getTabuleiro()[2]!=' ') return estado.getTabuleiro()[2];
        if(estado.getTabuleiro()[0] == estado.getTabuleiro()[4] && estado.getTabuleiro()[0] == estado.getTabuleiro()[8] && estado.getTabuleiro()[0]!=' ') return estado.getTabuleiro()[0];
        if(estado.getTabuleiro()[6] == estado.getTabuleiro()[4] && estado.getTabuleiro()[6] == estado.getTabuleiro()[2] && estado.getTabuleiro()[6]!=' ') return estado.getTabuleiro()[6];

        if(cheio(estado.getTabuleiro())) return 'E';

        return 'F';
    }

    public boolean cheio(char [] tabuleiro){
        for(int i=0; i<9; i++){
            if(tabuleiro[i]==' ')return false;
        }
        return true;
    }

    public char[] copiaTab(char[] tabuleiroInicial){
        char [] tabuleiro = new char[9];
        for (int i=0; i<9; i++){
            tabuleiro[i] = tabuleiroInicial[i];
        }
        return tabuleiro;
    }

}
