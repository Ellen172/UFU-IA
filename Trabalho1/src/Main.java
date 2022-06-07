import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str, string[];

        System.out.println("Inserir como no modelo -> {{x,x,x},{x,x,x},{x,x,x}}");
        System.out.println();

        System.out.println("Insira o estado final: ");
        str = scan.next();
        string = str.replaceAll("\\{", "")
                .replaceAll("}", "")
                .split(",");
        int[][] estadoFinal = new int[3][3];
        int aux = 0;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                estadoFinal[i][j] = Integer.parseInt(string[aux]);
                aux++;
            }
        }
        Objetivo.getObjetivo(estadoFinal);

        System.out.println("Insira o estado inicial: ");
        str = scan.next();
        string = str.replaceAll("\\{", "")
                .replaceAll("}", "")
                .split(",");
        int[][] estadoInicial = new int[3][3];
        int aux1 = 0;
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                estadoInicial[i][j] = Integer.parseInt(string[aux1]);
                aux1++;
            }
        }

        System.out.println("Insira o tipo de heuristica: ");
        System.out.println("(m = Manhattan | e = Posições erradas)");
        str = scan.next();
        char tipo = str.charAt(0);

        No noInicial = new No(estadoInicial, null, tipo);

        Borda borda = new Borda();
        Borda expandidos = new Borda();
        Sucessores sucessores = new Sucessores();

        int qtdNos=0, custoFinal = 0;
        while(!borda.vazia()){
            No no = borda.desenfileirar();
            qtdNos += sucessores.expandir(no);
            expandidos.enfileirar(no);

            No encontrado = sucessores.testeObj();
            if(encontrado != null){
                custoFinal = encontrado.getG() + encontrado.getH();
                System.out.println("Teste objetivo alcançado!");
                System.out.println();
                System.out.println("Caminho do nó (do ultimo ao primeiro): ");
                System.out.println(encontrado);
                for (int i=0; i<3; i++){
                    for (int j=0; j<3; j++){
                        System.out.println("["+i+"]["+j+"] = " + encontrado.getEstado()[i][j]);
                    }
                }

                System.out.println("g(n) = " + encontrado.getG());
                System.out.println("h(n) = " + encontrado.getH());
                encontrado = encontrado.getPai();
                while(encontrado!=null){
                    System.out.println(encontrado);
                    for (int i=0; i<3; i++){
                        for (int j=0; j<3; j++){
                            System.out.println("["+i+"]["+j+"] = " + encontrado.getEstado()[i][j]);
                        }
                    }
                    System.out.println("g(n) = " + encontrado.getG());
                    System.out.println("h(n) = " + encontrado.getH());

                    encontrado = encontrado.getPai();
                }
                System.out.println();
                System.out.println("Custo final: " + custoFinal);
                System.out.println("Nós gerados: " + qtdNos);
                System.exit(0);
            }
            else{
                for(int i = 0; i < sucessores.size(); i++) {
                    int s = expandidos.existe(sucessores.getSucessores().get(i));
                    if(s < 0){
                        int b = borda.existe(sucessores.getSucessores().get(i));
                        if (b > -1){
                            int m = borda.menorF(sucessores.getSucessores().get(i), borda.getBorda().get(b));
                            if (m == 1){
                                borda.getBorda().remove(b);
                                borda.enfileirar(sucessores.getSucessores().get(i));
                            }
                        } else {
                            borda.enfileirar(sucessores.getSucessores().get(i));
                        }
                    }
                }
                sucessores.getSucessores().clear();

            }
        }
        if(borda.vazia())
            System.out.println("Solução não encontrada!");
        System.exit(0);
    }
}
