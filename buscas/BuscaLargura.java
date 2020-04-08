package buscas;

import java.io.Serializable;
import estruturas.FilaCircular;
import grafoscidades.Cidade;
import grafoscidades.Mapa;

public class BuscaLargura implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private FilaCircular fronteira;
    private Cidade estadoInicial;
    private Cidade estadoFinal;

    public BuscaLargura(Cidade estadoInicial, Cidade estadoFinal) {
        this.setEstadoInicial(estadoInicial);
        this.setEstadoFinal(estadoFinal);
        this.getEstadoInicial().setVisitado(true);
        this.setFronteira(new FilaCircular(20));
        this.getFronteira().enfileirar(estadoInicial);
    }

    public FilaCircular getFronteira() {
        return fronteira;
    }

    public void setFronteira(FilaCircular fronteira) {
        this.fronteira = fronteira;
    }

    public Cidade getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Cidade estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public Cidade getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(Cidade estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public void buscar() {
        Cidade primeiro = this.getFronteira().verPrimeiro();
        if (primeiro != null) {
            primeiro.setVisitado(true);
            System.out.println("Primeiro: " + primeiro.toString());
            System.out.println("Desenfileirar: " + this.getFronteira().desenfileirar().toString());

            if (primeiro != this.getEstadoFinal()) {
                primeiro.getAdjacentes().forEach((adjacente) -> {
                    System.out.println("Adjacente: " + adjacente.getCidade().toString());
                    if (!adjacente.getCidade().isVisitado()) {
                        adjacente.getCidade().setVisitado(true);
                        this.getFronteira().enfileirar(adjacente.getCidade());
                    }
                });
                if (!this.getFronteira().isVazia()) {
                    this.buscar();
                }
            }
        }
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        BuscaLargura buscaLargura = new BuscaLargura(mapa.getPortoUniao(), mapa.getCuritiba());
        buscaLargura.buscar();
    }
}