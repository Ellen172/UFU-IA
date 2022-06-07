import java.util.ArrayList;

public class Borda {

    private ArrayList<No> borda;
    private int nroElementos;

    Borda(){
        setBorda(new ArrayList<>());
        setNroElementos(0);
    }

    public int existe(No no){
        if(borda.isEmpty()==true){
            return -2;
        }
        int e = -1;
        for(int i = 0; i < borda.size(); i++) {
            e = i;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(borda.get(i).getEstado()[j][k] != no.getEstado()[j][k]){
                        e = -1; j = 3; k = 3;
                    }
                }
            }
            if(e != -1){
                return e;
            }
        }
        return e;
    }

    public int menorF(No no1, No no2){
        if(no1.getF() < no2.getF())
            return 1;
        else
            return 2;
    }

    public void enfileirar(No no) {
        this.borda.add(no);
        this.nroElementos++;
    }

    public void imprimeBorda(){
        if(borda.isEmpty())
            System.out.println("vazia");
        else {
            for (int i = 0; i < borda.size(); i++) {
                System.out.println(this.borda.get(i));
            }
        }
    }

    public void removerNo(int i){
        borda.remove(i);
    }

    public No desenfileirar(){
        int aux = 90000000, n=-1;
        No no = null;
        for(int i = 0; i < borda.size(); i++){
            if(borda.get(i).getF() < aux){
                n = i;
                aux = borda.get(i).getF();
            }
        }
        no = borda.get(n);
        borda.remove(n);
        return no;
    }

    boolean vazia(){
        return borda.isEmpty();
    }

    public ArrayList<No> getBorda() {
        return borda;
    }

    public void setBorda(ArrayList<No> borda) {
        this.borda = borda;
    }

    public int getNroElementos() {
        return nroElementos;
    }

    public void setNroElementos(int nroElementos) {
        this.nroElementos = nroElementos;
    }
}
