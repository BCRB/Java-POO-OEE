package Modelo;

public class Operador extends Pessoa {
    private String codigo;
    private int serie;
    private Relatorio Relatorio = new Relatorio();


    public Relatorio getRelatorio() {
        return Relatorio;
    }

    public void setRelatorio(Relatorio Relatorio) {
        this.Relatorio = Relatorio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
}
