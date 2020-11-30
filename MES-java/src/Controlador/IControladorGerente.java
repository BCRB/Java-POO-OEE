package Controlador;

import Modelo.Operador;
import Modelo.Endereco;
import Modelo.Supervisor;
import Excecoes.GerenteException;


interface IControladorGerente {

    void cadastrarOperador(Operador a) throws GerenteException;

    void removerOperadorCodigo(String codigo) throws GerenteException;

    Operador pesquisarOperadorCodigo(String codigo, String cpf) throws GerenteException;

    void cadastrarSupervisor(Supervisor p) throws GerenteException;

    Supervisor pesquisarSupervisorCodigo(String codigo, String cpf) throws GerenteException;

    void removerSupervisorCodigo(String codigo) throws GerenteException;

    void aumentarSalarioP(String codigo) throws GerenteException;

    void aumentarSalarioP(String codigo, double quantidade) throws GerenteException;

    void trocarSupervisor(String codigo, Supervisor novoSupervisor) throws GerenteException;

    void removerEnderecoP(String codigo) throws GerenteException;

    void removerEnderecoA(String codigo) throws GerenteException;

    void trocarEnderecoA(String codigo, Endereco endereco) throws GerenteException;

    void trocarEnderecoP(String codigo, Endereco endereco) throws GerenteException;

    void cadastrarEnderecoOperador(Endereco endereco, String codigo) throws GerenteException;

    void cadastrarEnderecoSupervisor(Endereco endereco, String codigo) throws GerenteException;
}
