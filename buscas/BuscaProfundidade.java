package buscas;

import java.io.Serializable;
import estruturas.Pilha;
import grafoscidades.Cidade;
import grafoscidades.Mapa;

public class BuscaProfundidade implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Pilha fronteira;
    private Cidade estadoInicial;
    private Cidade estadoFinal;
    private boolean finalizado;

    public BuscaProfundidade(Cidade estadoInicial, Cidade estadoFinal) {
        this.setFinalizado(false);
        this.setEstadoInicial(estadoInicial);
        this.setEstadoFinal(estadoFinal);
        this.getEstadoInicial().setVisitado(true);

        this.setFronteira(new Pilha(20));
        this.getFronteira().empilhar(estadoInicial);
    }

    public Pilha getFronteira() {
        return fronteira;
    }

    public void setFronteira(Pilha fronteira) {
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

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public void buscar() {
        Cidade topo = this.getFronteira().verTopo();
        if (topo != null) {
            topo.setVisitado(true);
            System.out.println("Topo: " + topo.toString());

            if (topo == this.getEstadoFinal()) {
                this.setFinalizado(true);
            } else {
                topo.getAdjacentes().forEach((adjacente) -> {
                    if (!this.isFinalizado() && !adjacente.getCidade().isVisitado()) {
                        System.out.println("Adjacente a visitar: " + adjacente.getCidade().toString());
                        this.getFronteira().empilhar(adjacente.getCidade());
                        this.buscar();
                    }
                });
            }
            System.out.println("Desempilhar: " + this.getFronteira().desempilhar().toString());
        }
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        BuscaProfundidade buscaProfundidade = new BuscaProfundidade(mapa.getPortoUniao(), mapa.getCuritiba());
        buscaProfundidade.buscar();
    }
}