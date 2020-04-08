package estruturas;

import java.io.Serializable;
import grafoscidades.Cidade;
import grafoscidades.Mapa;

public class FilaCircular implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int tamanho;
    private Cidade[] cidades;
    private int inicio;
    private int fim;
    private int numeroElementos;

    public FilaCircular(int tamanho) {
        this.setTamanho(tamanho);
        this.setCidades(new Cidade[this.getTamanho()]);
        this.setInicio(0);
        this.setFim(-1);
        this.setNumeroElementos(0);
    }

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

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getNumeroElementos() {
        return numeroElementos;
    }

    public void setNumeroElementos(int numeroElementos) {
        this.numeroElementos = numeroElementos;
    }

    public void enfileirar(Cidade cidade) {
        if (!this.isCheia()) {
            this.setFim(this.getFim() + 1);
            if (this.getFim() == this.getTamanho()) {
                this.setFim(0);
            }
            this.getCidades()[this.getFim()] = cidade;
            this.setNumeroElementos(this.getNumeroElementos() + 1);
        }
    }

    public Cidade desenfileirar() {
        if (!this.isVazia()) {
            Cidade desenfileirar = this.getCidades()[this.getInicio()];
            this.setInicio(this.getInicio() + 1);
            if (this.getInicio() == this.getTamanho()) {
                this.setInicio(0);
            }
            this.setNumeroElementos(this.getNumeroElementos() - 1);
            return desenfileirar;
        }
        return null;
    }

    public Cidade verPrimeiro() {
        return this.getCidades()[this.getInicio()];
    }

    public boolean isVazia() {
        return this.getNumeroElementos() == 0;
    }

    private boolean isCheia() {
        return this.getNumeroElementos() == this.getTamanho();
    }

    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(5);
        Mapa mapa = new Mapa();
        fila.enfileirar(mapa.getAraucaria());
        fila.enfileirar(mapa.getBalsaNova());
        fila.enfileirar(mapa.getContenda());
        System.out.println(fila.verPrimeiro().toString());
        fila.desenfileirar();
        System.out.println(fila.verPrimeiro().toString());
        fila.enfileirar(mapa.getCampoLargo());
        fila.enfileirar(mapa.getCuritiba());
        fila.enfileirar(mapa.getLapa());
        System.out.println(fila.getInicio() + " " + fila.getFim());
        fila.desenfileirar();
        System.out.println(fila.getInicio() + " " + fila.getFim());
    }
}