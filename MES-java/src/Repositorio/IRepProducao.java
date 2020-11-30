package Repositorio;

public interface IRepProducao {

    int iniciarProducao(int tipo);

    boolean verificaProducao(int codigo);

    void pararProducao(int codigo, int opcao);
}
