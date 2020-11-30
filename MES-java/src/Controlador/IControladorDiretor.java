package Controlador;

import Modelo.Gerente;
import Modelo.Endereco;
import Excecoes.DiretorException;

public interface IControladorDiretor {

    void cadastrarGerente(Gerente Gerente) throws DiretorException;

    void removerGerenteCodigo(String Gerente) throws DiretorException;

    void substituirGerente(String codigo, Gerente novoGerente) throws DiretorException;

    void removerEnderecoD(String codigo) throws DiretorException;

    Gerente pesquisarGerenteCodigo(String codigo, String cpf) throws DiretorException;

    void trocarEndD(String codigo, Endereco endereco) throws DiretorException;

    void cadastrarEnderecoGerente(Endereco endereco, String codigo) throws DiretorException;

    void AtualizarSalarioGerente(String codigo, Double novoSalario) throws DiretorException;

    void aumentarSalarioD(String codigo) throws DiretorException;
}
