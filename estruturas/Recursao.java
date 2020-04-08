package estruturas;

import java.io.Serializable;

public class Recursao implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1179061419233866826L;
    int i = 0;

    public void funcao() {
        System.out.println("Executando...");
        if (i < 5) {
            i++;
            this.funcao();
        }
    }

    public static void main(String[] args) {
        Recursao r = new Recursao();
        r.funcao();
    }
}