package Modelo;


public class Supervisor extends Funcionario {
    private String Maquina;

    public void AumentarSalario() {
        setSalario(getSalario() + (getSalario() * 0.1));
    }

    public void AumentarSalario(double quantidade) {
        setSalario(getSalario() + quantidade);
    }

    public String getMaquina() {
        return Maquina;
    }

    public void setMaquina(String Maquina) {
        this.Maquina = Maquina;
    }

}
