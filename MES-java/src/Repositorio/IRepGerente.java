package Repositorio;

import Modelo.Gerente;
import Modelo.Endereco;

public interface IRepGerente {
    void cadastrarGerente(Gerente Gerente);

    boolean existeGerente(String codigo);

    void removerGerenteCodigo(String codigo);

    void substituirGerente(String codigo, Gerente novoGerente);

    void removerEnderecoD(String codigo);

    Gerente PesquisarGerenteCodigo(String codigo, String cpf);

    boolean TrocarEndD(String codigo, Endereco end);

    boolean cadastrarEnderecoGerente(Endereco endereco, String codigo);

    void AtualizarSalarioGerente(String codigo, Double novoSalario);

    void aumentarSalarioD(String codigo);
}
