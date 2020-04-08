package buscas;

import java.io.Serializable;

import estruturas.VetorOrdenadoCidade;
import grafoscidades.Adjacente;
import grafoscidades.Cidade;
import grafoscidades.Mapa;

public class BuscaGulosa implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8374663020146533454L;
    private VetorOrdenadoCidade fronteira;
    private Cidade estadoFinal;

    public BuscaGulosa(Cidade estadoFinal) {
        this.setEstadoFinal(estadoFinal);
    }

    public Cidade getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(Cidade estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public VetorOrdenadoCidade getFronteira() {
        return fronteira;
    }

    public void setFronteira(VetorOrdenadoCidade fronteira) {
        this.fronteira = fronteira;
    }

    public void buscar(Cidade estadoAtual) {
        System.out.println("Estado atual: " + estadoAtual.toString());
        estadoAtual.setVisitado(true);

        if (estadoAtual != estadoFinal) {
            this.fronteira = new VetorOrdenadoCidade(estadoAtual.getAdjacentes().size());
            for (Adjacente adjacente : estadoAtual.getAdjacentes()) {
                if (!adjacente.getCidade().isVisitado()) {
                    adjacente.getCidade().setVisitado(true);
                    this.fronteira.inserir(adjacente.getCidade());
                }
            }
            System.out.println(this.fronteira.mostrar());
            if (this.fronteira.getCidades().length > 0) {
                this.buscar(this.fronteira.getCidades()[0]);
            }
        }
    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        BuscaGulosa buscaGulosa = new BuscaGulosa(mapa.getCuritiba());
        buscaGulosa.buscar(mapa.getPortoUniao());
    }
}