package grafoscidades;

import java.io.Serializable;

public class Adjacente implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3373649995272484780L;
    private Cidade cidade;
    private int distanciaEstrada;

    public int distanciaAEstrela() {
        return this.cidade.getDistanciaLinhaReta() + this.distanciaEstrada;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public int getDistanciaEstrada() {
        return distanciaEstrada;
    }

    public void setDistanciaEstrada(int distanciaEstrada) {
        this.distanciaEstrada = distanciaEstrada;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Adjacente(Cidade cidade, int distanciaEstrada) {
        this.setCidade(cidade);
        this.setDistanciaEstrada(distanciaEstrada);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append("Cidade: " + this.cidade.toString());
        stringBuilder.append(", Distancia em estrada: " + this.distanciaEstrada);
        stringBuilder.append(", Distancia A*: " + this.distanciaAEstrela());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}