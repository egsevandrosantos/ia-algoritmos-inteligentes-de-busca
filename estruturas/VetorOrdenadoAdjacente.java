package estruturas;

import java.io.Serializable;

import grafoscidades.Adjacente;

public class VetorOrdenadoAdjacente implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2468693000371422484L;
    private Adjacente[] adjacentes;
    private int numeroElementos;

    public VetorOrdenadoAdjacente(int tamanho) {
        this.setAdjacentes(new Adjacente[tamanho]);
        this.setNumeroElementos(0);
    }

    public Adjacente[] getAdjacentes() {
        return adjacentes;
    }

    public void setAdjacentes(Adjacente[] adjacentes) {
        this.adjacentes = adjacentes;
    }

    public void inserir(Adjacente adjacente) {
        int posicao;
        for (posicao = 0; posicao < this.getNumeroElementos(); posicao++) {
            if (this.adjacentes[posicao].distanciaAEstrela() > adjacente.distanciaAEstrela()) {
                break;
            }
        }

        for (int k = this.getNumeroElementos(); k > posicao; k--) {
            this.adjacentes[k] = this.adjacentes[k - 1];
        }

        this.adjacentes[posicao] = adjacente;
        this.numeroElementos++;
    }

    public String mostrar() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.numeroElementos; i++) {
            str.append(this.adjacentes[i].toString() + "\n");
        }
        return str.toString();
    }

    public int getNumeroElementos() {
        return numeroElementos;
    }

    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }
}