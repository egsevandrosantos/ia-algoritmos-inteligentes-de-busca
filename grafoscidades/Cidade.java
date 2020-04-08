package grafoscidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cidade implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8233496785568317673L;
    private String nome;
    private int distanciaLinhaReta;
    private boolean visitado;
    private List<Adjacente> adjacentes;

    public String getNome() {
        return nome;
    }

    public int getDistanciaLinhaReta() {
        return distanciaLinhaReta;
    }

    public void setDistanciaLinhaReta(int distanciaLinhaReta) {
        this.distanciaLinhaReta = distanciaLinhaReta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<Adjacente> getAdjacentes() {
        return adjacentes;
    }

    public void setAdjacentes(List<Adjacente> adjacentes) {
        this.adjacentes = adjacentes;
    }

    public void addAdjacentes(Adjacente cidade) {
        this.adjacentes.add(cidade);
    }

    public Cidade(String nome, int distanciaLinhaReta) {
        this.setNome(nome);
        this.setDistanciaLinhaReta(distanciaLinhaReta);
        this.setVisitado(false);
        this.setAdjacentes(new ArrayList<Adjacente>());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("Nome: " + this.getNome());
        builder.append(", Distância em linha reta até o objetivo: " + this.getDistanciaLinhaReta());
        builder.append(", Visitado: " + this.isVisitado());
        builder.append(", Total de adjacentes: " + this.getAdjacentes().size());
        builder.append("]");
        return builder.toString();
    }
}