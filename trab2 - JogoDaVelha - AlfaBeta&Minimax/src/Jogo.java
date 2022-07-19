import java.util.ArrayList;

public class Jogo {
    public static void main(String[] args) {
        Estado estadoInicial = new Estado(new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '}, null);

        /*Minimax mm = new Minimax();
        Estado finalMinimax = mm.max(estadoInicial);
        imprimirCaminho(finalMinimax);*/

        PodaAlfaBeta ab = new PodaAlfaBeta();
        Estado finalAlfaBeta = ab.max(estadoInicial, -9999, 9999);
        imprimirCaminho(finalAlfaBeta);
    }

    public static void imprimirCaminho(Estado estado){
        while(estado.getPai() != null){
            System.out.println();
            for(int i=0; i<9; i++){
                System.out.print(estado.getTabuleiro()[i]);
                if(i==8){
                    System.out.println();
                }
                else if(i%3==2){
                    System.out.println();
                    System.out.println("---------");
                }
                else {
                    System.out.print(" | ");
                }
            }
            System.out.println("v = " + estado.getFator());

            estado = estado.getPai();
        }
    }

}
