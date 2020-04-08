package estruturas;

import java.io.Serializable;

import grafoscidades.Cidade;
import grafoscidades.Mapa;

public class VetorOrdenadoCidade implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -7052985508162433945L;
    private Cidade[] cidades;
    private int numeroElementos;

    public VetorOrdenadoCidade(int tamanho) {
        this.setCidades(new Cidade[tamanho]);
        this.setNumeroElementos(0);
    }

    public void inserir(Cidade cidade) {
        int posicao;
        for (posicao = 0; posicao < this.getNumeroElementos(); posicao++) {
            if (this.cidades[posicao].getDistanciaLinhaReta() > cidade.getDistanciaLinhaReta()) {
                break;
            }
        }

        for (int k = this.getNumeroElementos(); k > posicao; k--) {
            this.cidades[k] = this.cidades[k - 1];
        }

        this.cidades[posicao] = cidade;
        this.numeroElementos++;
    }

    public String mostrar() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.numeroElementos; i++) {
            str.append(this.cidades[i].toString() + "\n");
        }
        return str.toString();
    }

    public int getNumeroElementos() {
        return numeroElementos;
    }

    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }

    public Cidade[] getCidades() {
        return cidades;
    }

    public void setCidades(Cidade[] cidades) {
        this.cidades = cidades;
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        VetorOrdenadoCidade vetor = new VetorOrdenadoCidade(5);
        vetor.inserir(mapa.getPortoUniao());
        vetor.inserir(mapa.getPauloFrontin());
        vetor.inserir(mapa.getBalsaNova());
        vetor.inserir(mapa.getPalmeira());
        System.out.println(vetor.mostrar());
    }
}