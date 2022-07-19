import java.util.ArrayList;

public class Estado {
    char tabuleiro[] = new char[9];
    int fator;
    Estado pai;

    public Estado(char tabuleiro[], Estado pai){
        this.tabuleiro = tabuleiro;
        this.pai = pai;
    }

    public char[] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getFator() {
        return fator;
    }

    public void setFator(int fator) {
        this.fator = fator;
    }

    public Estado getPai() {
        return pai;
    }

    public void setPai(Estado pai) {
        this.pai = pai;
    }
}
