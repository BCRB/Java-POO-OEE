package Modelo;


public abstract class Maquina {

    private Double[] Quantidade = new Double[3];
    private Double meta;
    private boolean aprovado;

    public Double getmeta() {
        return meta;
    }

    public void setmeta(Double meta) {
        this.meta = meta;
    }

    public Double[] getQuantidade() {
        return Quantidade;
    }

    public Double getQuantidade1() {
        return Quantidade[0];
    }

    public void setQuantidade1(Double Quantidade) {
        this.Quantidade[0] = Quantidade;
    }

    public Double getQuantidade2() {
        return Quantidade[1];
    }

    public void setQuantidade2(Double Quantidade) {
        this.Quantidade[1] = Quantidade;
    }

    public Double getQuantidade3() {
        return Quantidade[2];
    }

    public void setQuantidade3(Double Quantidade) {
        this.Quantidade[2] = Quantidade;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
}
