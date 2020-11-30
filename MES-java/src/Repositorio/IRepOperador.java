package Repositorio;

import Modelo.Operador;
import Modelo.Endereco;

public interface IRepOperador {

    void cadastrarOperador(Operador a);

    Operador pesquisarOperadorCodigo(String codigo);

    Operador pesquisarOperadorCodigo(String codigo, String cpf);

    void removerOperadorCodigo(String codigo);

    boolean existeOperador(String codigo);

    void alterarQuantidades(String codigo, double Quantidade, int unidade, int idMaquina);

    Operador checarQuantidades(String codigo);

    void removerEnderecoA(String codigo);

    boolean trocarEnderecoA(String codigo, Endereco endereco);

    boolean cadastrarEnderecoOperador(Endereco endereco, String codigo);

    void passarOperadorsAno();

    boolean checarSerie(Operador a);
}
