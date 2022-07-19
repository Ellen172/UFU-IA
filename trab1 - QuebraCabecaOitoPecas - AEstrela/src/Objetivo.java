public class Objetivo {
    static Objetivo obj;
    static int estado[][];

    Objetivo(int estado[][]){
        setEstado(estado);
    }

    static void imprime(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
              System.out.println("Estado["+i+"]["+j+"] = " + estado[i][j]);
            }
        }
    }

    public static synchronized Objetivo getObjetivo(int estado[][]) {
        if (obj == null) {
            obj = new Objetivo(estado);
        }
        return obj;
    }

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }
}
