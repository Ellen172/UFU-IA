import java.util.ArrayList;
public class No {

    private int estado[][];
    private No pai;
    private int h, g = 0, f, xb, yb;
    private char tipo;

    No(int estado[][], No pai, char tipo){
        setEstado(estado);
        setPai(pai);
        setTipo(tipo);
        if(tipo == 'm'){
            setH(calculaHeuristicaManhattan(estado));
        } else if(tipo == 'e'){
            setH(calculaHeuristicaErrada(estado));
        }
        setG(incrementaG(pai));
        setF(getH()+getG());
        localizaBranco(estado);
    }

    void imprime(){
        System.out.println();
        System.out.println("No " + this);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println("Estado["+i+"]["+j+"] = "+ estado[i][j]);
            }
        }
        System.out.println("H = " + getH());
        System.out.println("G = " + getG());
        System.out.println("F = " + getF());
    }

    int calculaHeuristicaErrada(int estado[][]){ //nro de nos no lugar errado
        Objetivo obj = Objetivo.getObjetivo(null);
        int cont = 0;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(obj.estado[i][j] != estado[i][j])
                    cont++;
            }
        }
        return cont;
    }

    int calculaHeuristicaManhattan(int estado[][]){
        int cont = 0, dx = 0, dy = 0;
        for (int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                // percorre as posições de estado
                for (int k=0; k<3; k++){
                    for (int l=0; l<3; l++){
                        // percorre as posições do estado objetivo
                        if(estado[i][j] == Objetivo.getObjetivo(null).getEstado()[k][l]){
                            dx = i-k;
                            if(dx < 0) dx *= -1;
                            dy = j-l;
                            if(dy < 0) dy *= -1;
                            cont = cont + dx + dy;
                            k=3; l=3;
                        }
                    }
                }
            }
        }

        return cont;
    }

    int incrementaG(No pai){
        if(pai == null){
            return 0;
        } else {
            return pai.getG() + 1;
        }
    }

    void localizaBranco(int estado[][]){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(estado[i][j] == 0){
                    setXb(i);
                    setYb(j);
                }
            }
        }
    }

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getXb() {
        return xb;
    }

    public void setXb(int xb) {
        this.xb = xb;
    }

    public int getYb() {
        return yb;
    }

    public void setYb(int yb) {
        this.yb = yb;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
}
