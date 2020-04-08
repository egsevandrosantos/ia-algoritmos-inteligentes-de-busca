package estruturas;

import java.io.Serializable;
import grafoscidades.Cidade;
import grafoscidades.Mapa;

public class Pilha implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int tamanho;
    private Cidade[] cidades;
    private int topo;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Cidade[] getCidades() {
        return cidades;
    }

    public void setCidades(Cidade[] cidades) {
        this.cidades = cidades;
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }

    public Pilha(int tamanho) {
        this.setTamanho(tamanho);
        this.setCidades(new Cidade[this.getTamanho()]);
        this.setTopo(-1);
    }

    public void empilhar(Cidade cidade) {
        if (!this.pilhaCheia()) {
            this.setTopo(this.getTopo() + 1);
            this.getCidades()[this.getTopo()] = cidade;
        }
    }

    public Cidade desempilhar() {
        if (!this.pilhaVazia()) {
            Cidade cidade = this.verTopo();
            this.setTopo(this.getTopo() - 1);
            return cidade;
        }

        return null;
    }

    public Cidade verTopo() {
        if (this.getTopo() >= 0) {
            return this.getCidades()[this.getTopo()];
        }

        return null;
    }

    private boolean pilhaCheia() {
        return this.getTopo() == this.getTamanho() - 1;
    }

    private boolean pilhaVazia() {
        return this.getTopo() == -1;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        Mapa mapa = new Mapa();
        pilha.empilhar(mapa.getPortoUniao());
        pilha.empilhar(mapa.getPauloFrontin());
        pilha.empilhar(mapa.getCanoinhas());
        System.out.println(pilha.verTopo().toString());
        pilha.desempilhar();
        System.out.println(pilha.verTopo().toString());
    }
}