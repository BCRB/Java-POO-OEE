package Repositorio;

import Modelo.Gerente;
import Modelo.Endereco;

import java.util.ArrayList;
import java.util.List;

public class RepGerente implements IRepGerente {

    private static RepGerente instancia;
    private List<Gerente> listaGerente;

    private RepGerente() {
        listaGerente = new ArrayList<>();
    }

    public static RepGerente getInstancia() {
        if (instancia == null) {
            instancia = new RepGerente();
        }
        return instancia;
    }

    public void substituirGerente(String codigo, Gerente novoGerente) {
        for (int i = 0; i < listaGerente.size(); i++) {
            if (listaGerente.get(i) != null && listaGerente.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaGerente.remove(i);

                listaGerente.add(novoGerente);
            }
        }
    }

    public void cadastrarGerente(Gerente Gerente) {
        listaGerente.add(Gerente);
    }

    public boolean existeGerente(String codigo) {
        for (Gerente Gerente : listaGerente) {
            if (Gerente != null && Gerente.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerGerenteCodigo(String codigo) {
        for (int i = 0; i < listaGerente.size(); i++) {
            if (listaGerente.get(i) != null && listaGerente.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaGerente.remove(i);
            }
        }
    }

    public void removerEnderecoD(String codigo) {
        for (int i = 0; i < listaGerente.size(); i++) {
            if (listaGerente.get(i) != null && listaGerente.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaGerente.get(i).setEndereco(null);
            }
        }
    }

    @Override
    public Gerente PesquisarGerenteCodigo(String codigo, String cpf) {
        for (Gerente Gerente : listaGerente) {
            if (Gerente != null && Gerente.getCodigo().equalsIgnoreCase(codigo) && Gerente.getCodigo().equalsIgnoreCase(cpf)) {
                return Gerente;
            }
        }
        return null;
    }

    @Override
    public boolean TrocarEndD(String codigo, Endereco endereco) {
        for (Gerente Gerente : listaGerente) {
            if (Gerente != null && Gerente.getCodigo().equalsIgnoreCase(codigo) && Gerente.getEndereco() != null) {
                Gerente.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cadastrarEnderecoGerente(Endereco endereco, String codigo) {
        for (Gerente Gerente : listaGerente) {
            if (Gerente != null && Gerente.getCodigo().equalsIgnoreCase(codigo) && Gerente.getEndereco() == null) {
                Gerente.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }

    @Override
    public void AtualizarSalarioGerente(String codigo, Double novoSalario) {
        for (Gerente Gerente : listaGerente) {
            if (Gerente != null && Gerente.getCodigo().equalsIgnoreCase(codigo)) {
                Gerente.setSalario(novoSalario);
            }
        }
    }

    @Override
    public void aumentarSalarioD(String codigo) {
        for (Gerente Gerente : listaGerente) {
            if (Gerente != null && Gerente.getCodigo().equalsIgnoreCase(codigo)) {
                Gerente.setSalario(Gerente.getSalario() + (Gerente.getSalario() * 0.1));
            }
        }
    }
}


