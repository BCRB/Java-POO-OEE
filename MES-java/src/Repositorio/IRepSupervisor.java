package Repositorio;

import Modelo.Endereco;
import Modelo.Supervisor;

public interface IRepSupervisor {

    void cadastrarSupervisor(Supervisor p);

    Supervisor pesquisarSupervisorCodigo(String codigo);

    Supervisor pesquisarSupervisorCodigo(String codigo, String cpf);

    boolean existeSupervisor(String codigo);

    void removerSupervisorCodigo(String codigo);

    void aumentarSalario(String codigo);

    void aumentarSalario(String codigo, double quantidade);

    void trocarSupervisor(String codigo, Supervisor novoSupervisor);

    void removerEnderecoP(String codigo);

    boolean trocarEnderecoP(String codigo, Endereco endereco);

    boolean cadastrarEnderecoSupervisor(Endereco endereco, String codigo);
}
