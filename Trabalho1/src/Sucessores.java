import java.util.ArrayList;

public class Sucessores {
    ArrayList<No> sucessores;

    Sucessores(){
        setSucessores(new ArrayList<>());
    }

    public int expandir(No no){
        int qtd = 0;
        No filho = null;
        if(no.getXb() == 0 && no.getYb() == 0){
            filho = new No (trocaPosicao(no, 1, 0), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 0, 1), no, no.getTipo());
            sucessores.add(filho);
            qtd = 2;
        }

        if(no.getXb() == 0 && no.getYb() == 1){
            filho = new No (trocaPosicao(no, 0, 0), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 0, 2), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 1,1), no, no.getTipo());
            sucessores.add(filho);
            qtd = 3;
        }

        if(no.getXb() == 0 && no.getYb() == 2){
            filho = new No (trocaPosicao(no, 0, 1), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 1, 2), no, no.getTipo());
            sucessores.add(filho);
            qtd = 2;
        }

        if(no.getXb() == 1 && no.getYb() == 0){
            filho = new No(trocaPosicao(no, 1, 1), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 0, 0), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 2, 0), no, no.getTipo());
            sucessores.add(filho);
            qtd = 3;
        }

        if(no.getXb() == 1 && no.getYb() == 1){
            filho = new No (trocaPosicao(no, 0,1), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 2,1), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 1,2), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 1,0), no, no.getTipo());
            sucessores.add(filho);
            qtd = 4;
        }

        if(no.getXb() == 1 && no.getYb() == 2){
            filho = new No (trocaPosicao(no, 0,2), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 2,2), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 1,1), no, no.getTipo());
            sucessores.add(filho);
            qtd = 3;
        }

        if(no.getXb() == 2 && no.getYb() == 0){
            filho = new No (trocaPosicao(no, 1,0), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 2,1), no, no.getTipo());
            sucessores.add(filho);
            qtd = 2;
        }

        if(no.getXb() == 2 && no.getYb() == 1){
            filho = new No (trocaPosicao(no, 1,1), no, no.getTipo());
            sucessores.add(filho);
            filho = new No(trocaPosicao(no,2,2), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 2,0), no, no.getTipo());
            sucessores.add(filho);
            qtd = 3;
        }

        if(no.getXb() == 2 && no.getYb() == 2){
            filho = new No (trocaPosicao(no, 1,2), no, no.getTipo());
            sucessores.add(filho);
            filho = new No (trocaPosicao(no, 2,1), no, no.getTipo());
            sucessores.add(filho);
            qtd = 2;
        }
        return qtd;
    }

    public int[][] trocaPosicao(No pai, int xTroca, int yTroca){
        int mat[][] = new int[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i == xTroca && j == yTroca){
                    mat[i][j] = pai.getEstado()[pai.getXb()][pai.getYb()];
                }
                else if(i == pai.getXb() && j == pai.getYb()){
                    mat[i][j] = pai.getEstado()[xTroca][yTroca];
                }
                else {
                    mat[i][j] = pai.getEstado()[i][j];
                }
            }
        }
        return mat;
    }

    public No testeObj(){
        No encontrado = null;
        for(int i = 0; i < sucessores.size(); i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    encontrado = sucessores.get(i);
                    if (sucessores.get(i).getEstado()[j][k] != Objetivo.getObjetivo(null).getEstado()[j][k]){
                        encontrado=null;
                        j=3; k=3;
                    }
                }
            }
            if(encontrado != null){
                return encontrado;
            }
        }
        return encontrado;
    }

    public void imprimeSucessores(){
        if(sucessores.isEmpty())
            System.out.println("Vazia");
        for(int i=0; i<sucessores.size(); i++){
            System.out.println("Sucessor " + sucessores.get(i));
            for (int j=0; j<3; j++){
                for (int k=0; k<3; k++){
                    System.out.println("["+j+"]["+k+"] = " + sucessores.get(i).getEstado()[j][k]);

                }
            }
            System.out.println("H = " + sucessores.get(i).getH());
            System.out.println("G = " + sucessores.get(i).getG());
            System.out.println("F = " + sucessores.get(i).getF());
        }
    }

    public void imprimeLista(){
        if(sucessores.isEmpty())
            System.out.println("vazia");
        else {
            for (int i=0; i<sucessores.size(); i++){
                System.out.println(sucessores.get(i));
            }
        }
    }

    public int size(){
        return sucessores.size();
    }

    public ArrayList<No> getSucessores() {
        return sucessores;
    }

    public void setSucessores(ArrayList<No> sucessores) {
        this.sucessores = sucessores;
    }
}
