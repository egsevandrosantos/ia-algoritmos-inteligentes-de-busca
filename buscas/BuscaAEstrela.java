package buscas;

import java.io.Serializable;

import estruturas.VetorOrdenadoAdjacente;
import grafoscidades.Adjacente;
import grafoscidades.Cidade;
import grafoscidades.Mapa;

public class BuscaAEstrela implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private VetorOrdenadoAdjacente fronteira;
    private Cidade estadoFinal;

    public BuscaAEstrela(Cidade estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public void buscar(Cidade estadoAtual) {
        System.out.println("Estado atual: " + estadoAtual.toString());
        estadoAtual.setVisitado(true);

        if (estadoAtual != this.estadoFinal) {
            this.fronteira = new VetorOrdenadoAdjacente(estadoAtual.getAdjacentes().size());
            for (Adjacente adjacente : estadoAtual.getAdjacentes()) {
                if (!adjacente.getCidade().isVisitado()) {
                    adjacente.getCidade().setVisitado(true);
                    this.fronteira.inserir(adjacente);
                }
            }
            System.out.println(this.fronteira.mostrar());
            if (this.fronteira.getAdjacentes().length > 0) {
                this.buscar(this.fronteira.getAdjacentes()[0].getCidade());
            }
        }
    }

    public VetorOrdenadoAdjacente getFronteira() {
        return fronteira;
    }

    public Cidade getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(Cidade estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public void setFronteira(VetorOrdenadoAdjacente fronteira) {
        this.fronteira = fronteira;
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        BuscaAEstrela buscaAEstrela = new BuscaAEstrela(mapa.getCuritiba());
        buscaAEstrela.buscar(mapa.getPortoUniao());
    }
}