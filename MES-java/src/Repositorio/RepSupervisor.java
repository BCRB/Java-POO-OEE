package Repositorio;

import Modelo.Endereco;
import Modelo.Supervisor;

import java.util.ArrayList;
import java.util.List;

public class RepSupervisor implements IRepSupervisor {

    private static RepSupervisor instancia;
    private List<Supervisor> listaSupervisor;

    private RepSupervisor() {
        listaSupervisor = new ArrayList<>();
    }

    public static RepSupervisor getInstancia() {
        if (instancia == null) {
            instancia = new RepSupervisor();
        }
        return instancia;
    }

    @Override
    public void cadastrarSupervisor(Supervisor Supervisor) {
        listaSupervisor.add(Supervisor);
    }

    public void trocarSupervisor(String codigo, Supervisor novoSupervisor) {
        for (int i = 0; i < listaSupervisor.size(); i++) {
            if (listaSupervisor.get(i) != null && listaSupervisor.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaSupervisor.remove(i);
                listaSupervisor.add(novoSupervisor);
            }
        }
    }

    @Override
    public Supervisor pesquisarSupervisorCodigo(String codigo) {
        for (Supervisor Supervisor : listaSupervisor) {
            if (Supervisor != null && Supervisor.getCodigo().equalsIgnoreCase(codigo)) {
                Supervisor.setCpf(null);
                Supervisor.setCargaH(0);
                Supervisor.setSalario(0);
                return Supervisor;
            }
        }
        return null;
    }

    @Override
    public Supervisor pesquisarSupervisorCodigo(String codigo, String cpf) {
        for (Supervisor Supervisor : listaSupervisor) {
            if (Supervisor != null && Supervisor.getCodigo().equalsIgnoreCase(codigo) && Supervisor.getCodigo().equalsIgnoreCase(cpf)) {
                return Supervisor;
            }
        }
        return null;
    }

    public boolean existeSupervisor(String codigo) {
        for (Supervisor Supervisor : listaSupervisor) {
            if (Supervisor != null && Supervisor.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerSupervisorCodigo(String codigo) {
        for (int i = 0; i < listaSupervisor.size(); i++) {
            if (listaSupervisor.get(i) != null && listaSupervisor.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaSupervisor.remove(i);
            }
        }
    }

    @Override
    public void aumentarSalario(String codigo) {
        for (Supervisor Supervisor : listaSupervisor) {
            if (Supervisor != null && Supervisor.getCodigo().equalsIgnoreCase(codigo)) {
                Supervisor.setSalario(Supervisor.getSalario() + (Supervisor.getSalario() * 0.1));
            }
        }
    }

    public void aumentarSalario(String codigo, double quantidade) {
        for (Supervisor Supervisor : listaSupervisor) {
            if (Supervisor != null && Supervisor.getCodigo().equalsIgnoreCase(codigo)) {
                Supervisor.setSalario(Supervisor.getSalario() + quantidade);
            }
        }
    }

    public void removerEnderecoP(String codigo) {
        for (int i = 0; i < listaSupervisor.size(); i++) {
            if (listaSupervisor.get(i) != null && listaSupervisor.get(i).getCodigo().equalsIgnoreCase(codigo) && listaSupervisor.get(i).getEndereco() != null) {
                listaSupervisor.get(i).setEndereco(null);
            }
        }
    }

    @Override
    public boolean trocarEnderecoP(String codigo, Endereco endereco) {
        for (Supervisor Supervisor : listaSupervisor) {
            if (Supervisor != null && Supervisor.getCodigo().equalsIgnoreCase(codigo) && Supervisor.getEndereco() != null) {
                Supervisor.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }


    public boolean cadastrarEnderecoSupervisor(Endereco endereco, String codigo) {
        for (Supervisor Supervisor : listaSupervisor) {
            if (Supervisor != null && Supervisor.getCodigo().equalsIgnoreCase(codigo) && Supervisor.getEndereco() == null) {
                Supervisor.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }
}
