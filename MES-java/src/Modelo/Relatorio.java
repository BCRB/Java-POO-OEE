package Modelo;

public class Relatorio {
    private Lavadora Lavadora = new Lavadora();
    private Enchedora Enchedora = new Enchedora();
    private Rotuladora Rotuladora = new Rotuladora();
    private Paletizadora Paletizadora = new Paletizadora();
    private Empacotadora Empacotadora = new Empacotadora();

    public Lavadora getLavadora() {
        return Lavadora;
    }

    public Enchedora getEnchedora() {
        return Enchedora;
    }


    public Rotuladora getRotuladora() {
        return Rotuladora;
    }


    public Paletizadora getPaletizadora() {
        return Paletizadora;
    }


    public Empacotadora getEmpacotadora() {
        return Empacotadora;
    }


}
