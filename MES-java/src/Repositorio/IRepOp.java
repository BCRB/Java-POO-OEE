package Repositorio;

import Modelo.Op;

public interface IRepOp {

    void mandarOp(Op Op);

    boolean existeOp(String codigo);

    void removerOp(String codigo);

    void removerOp(int prazo);

    Op mostrarOp(String codigo);

    void substituirT(Op t);
}
