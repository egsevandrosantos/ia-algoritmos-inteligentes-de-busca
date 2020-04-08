package grafoscidades;

import java.io.Serializable;

public class Mapa implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Cidade portoUniao;
    private Cidade pauloFrontin;
    private Cidade canoinhas;
    private Cidade irati;
    private Cidade palmeira;
    private Cidade campoLargo;
    private Cidade curitiba;
    private Cidade balsaNova;
    private Cidade araucaria;
    private Cidade saoJose;
    private Cidade contenda;
    private Cidade mafra;
    private Cidade tijucas;
    private Cidade lapa;
    private Cidade saoMateus;
    private Cidade tresBarras;

    public Mapa() {
        this.setPortoUniao(new Cidade("Porto União", 203));
        this.setPauloFrontin(new Cidade("Paulo Frontin", 172));
        this.setCanoinhas(new Cidade("Canoinhas", 141));
        this.setIrati(new Cidade("Irati", 139));
        this.setPalmeira(new Cidade("Palmeira", 59));
        this.setCampoLargo(new Cidade("Campo Largo", 27));
        this.setCuritiba(new Cidade("Curitiba", 0));
        this.setBalsaNova(new Cidade("Balsa Nova", 41));
        this.setAraucaria(new Cidade("Araucária", 23));
        this.setSaoJose(new Cidade("São José dos Pinhais", 13));
        this.setContenda(new Cidade("Contenda", 39));
        this.setMafra(new Cidade("Mafra", 94));
        this.setTijucas(new Cidade("Tijucas do Sul", 56));
        this.setLapa(new Cidade("Lapa", 74));
        this.setSaoMateus(new Cidade("São Mateus do Sul", 123));
        this.setTresBarras(new Cidade("Três Barras", 131));

        this.portoUniao.addAdjacentes(new Adjacente(this.pauloFrontin, 46));
        this.portoUniao.addAdjacentes(new Adjacente(this.saoMateus, 87));
        this.portoUniao.addAdjacentes(new Adjacente(this.canoinhas, 78));
        this.pauloFrontin.addAdjacentes(new Adjacente(this.irati, 75));
        this.pauloFrontin.addAdjacentes(new Adjacente(this.portoUniao, 46));
        this.canoinhas.addAdjacentes(new Adjacente(this.portoUniao, 78));
        this.canoinhas.addAdjacentes(new Adjacente(this.mafra, 66));
        this.canoinhas.addAdjacentes(new Adjacente(this.tresBarras, 12));
        this.irati.addAdjacentes(new Adjacente(this.pauloFrontin, 75));
        this.irati.addAdjacentes(new Adjacente(this.saoMateus, 57));
        this.irati.addAdjacentes(new Adjacente(this.palmeira, 75));
        this.palmeira.addAdjacentes(new Adjacente(this.irati, 75));
        this.palmeira.addAdjacentes(new Adjacente(this.campoLargo, 55));
        this.palmeira.addAdjacentes(new Adjacente(this.saoMateus, 77));
        this.campoLargo.addAdjacentes(new Adjacente(this.palmeira, 55));
        this.campoLargo.addAdjacentes(new Adjacente(this.balsaNova, 22));
        this.campoLargo.addAdjacentes(new Adjacente(this.curitiba, 29));
        this.curitiba.addAdjacentes(new Adjacente(this.saoJose, 15));
        this.curitiba.addAdjacentes(new Adjacente(this.araucaria, 37));
        this.curitiba.addAdjacentes(new Adjacente(this.balsaNova, 51));
        this.curitiba.addAdjacentes(new Adjacente(this.campoLargo, 29));
        this.balsaNova.addAdjacentes(new Adjacente(this.contenda, 19));
        this.balsaNova.addAdjacentes(new Adjacente(this.curitiba, 51));
        this.balsaNova.addAdjacentes(new Adjacente(this.campoLargo, 22));
        this.araucaria.addAdjacentes(new Adjacente(this.contenda, 18));
        this.araucaria.addAdjacentes(new Adjacente(this.curitiba, 37));
        this.saoJose.addAdjacentes(new Adjacente(this.curitiba, 15));
        this.saoJose.addAdjacentes(new Adjacente(this.tijucas, 49));
        this.contenda.addAdjacentes(new Adjacente(this.balsaNova, 19));
        this.contenda.addAdjacentes(new Adjacente(this.araucaria, 18));
        this.contenda.addAdjacentes(new Adjacente(this.lapa, 26));
        this.mafra.addAdjacentes(new Adjacente(this.tijucas, 99));
        this.mafra.addAdjacentes(new Adjacente(this.lapa, 57));
        this.mafra.addAdjacentes(new Adjacente(this.canoinhas, 66));
        this.tijucas.addAdjacentes(new Adjacente(this.saoJose, 49));
        this.tijucas.addAdjacentes(new Adjacente(this.mafra, 99));
        this.lapa.addAdjacentes(new Adjacente(this.contenda, 26));
        this.lapa.addAdjacentes(new Adjacente(this.saoMateus, 60));
        this.lapa.addAdjacentes(new Adjacente(this.mafra, 57));
        this.saoMateus.addAdjacentes(new Adjacente(this.lapa, 60));
        this.saoMateus.addAdjacentes(new Adjacente(this.portoUniao, 87));
        this.saoMateus.addAdjacentes(new Adjacente(this.tresBarras, 43));
        this.saoMateus.addAdjacentes(new Adjacente(this.irati, 57));
        this.saoMateus.addAdjacentes(new Adjacente(this.palmeira, 77));
        this.tresBarras.addAdjacentes(new Adjacente(this.saoMateus, 43));
        this.tresBarras.addAdjacentes(new Adjacente(this.canoinhas, 12));
    }

    public Cidade getPortoUniao() {
        return portoUniao;
    }

    public void setPortoUniao(Cidade portoUniao) {
        this.portoUniao = portoUniao;
    }

    public Cidade getPauloFrontin() {
        return pauloFrontin;
    }

    public void setPauloFrontin(Cidade pauloFrontin) {
        this.pauloFrontin = pauloFrontin;
    }

    public Cidade getCanoinhas() {
        return canoinhas;
    }

    public void setCanoinhas(Cidade canoinhas) {
        this.canoinhas = canoinhas;
    }

    public Cidade getIrati() {
        return irati;
    }

    public void setIrati(Cidade irati) {
        this.irati = irati;
    }

    public Cidade getPalmeira() {
        return palmeira;
    }

    public void setPalmeira(Cidade palmeira) {
        this.palmeira = palmeira;
    }

    public Cidade getCampoLargo() {
        return campoLargo;
    }

    public void setCampoLargo(Cidade campoLargo) {
        this.campoLargo = campoLargo;
    }

    public Cidade getCuritiba() {
        return curitiba;
    }

    public void setCuritiba(Cidade curitiba) {
        this.curitiba = curitiba;
    }

    public Cidade getBalsaNova() {
        return balsaNova;
    }

    public void setBalsaNova(Cidade balsaNova) {
        this.balsaNova = balsaNova;
    }

    public Cidade getAraucaria() {
        return araucaria;
    }

    public void setAraucaria(Cidade araucaria) {
        this.araucaria = araucaria;
    }

    public Cidade getSaoJose() {
        return saoJose;
    }

    public void setSaoJose(Cidade saoJose) {
        this.saoJose = saoJose;
    }

    public Cidade getContenda() {
        return contenda;
    }

    public void setContenda(Cidade contenda) {
        this.contenda = contenda;
    }

    public Cidade getMafra() {
        return mafra;
    }

    public void setMafra(Cidade mafra) {
        this.mafra = mafra;
    }

    public Cidade getTijucas() {
        return tijucas;
    }

    public void setTijucas(Cidade tijucas) {
        this.tijucas = tijucas;
    }

    public Cidade getLapa() {
        return lapa;
    }

    public void setLapa(Cidade lapa) {
        this.lapa = lapa;
    }

    public Cidade getSaoMateus() {
        return saoMateus;
    }

    public void setSaoMateus(Cidade saoMateus) {
        this.saoMateus = saoMateus;
    }

    public Cidade getTresBarras() {
        return tresBarras;
    }

    public void setTresBarras(Cidade tresBarras) {
        this.tresBarras = tresBarras;
    }
}