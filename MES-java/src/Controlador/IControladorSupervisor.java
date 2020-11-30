package Controlador;

import Modelo.Operador;
import Modelo.Op;
import Excecoes.SupervisorException;

interface IControladorSupervisor {

    void alterarQuantidades(String codigo, double Quantidade, int unidade, int idMaquina) throws SupervisorException;

    void mandarOp(Op Op) throws SupervisorException;

    void removerOp(String codigo) throws SupervisorException;

    void removerOp(int prazo) throws SupervisorException;

    Operador pesquisarOperadorCodigo(String codigo) throws SupervisorException;

    void substituirT(Op t) throws SupervisorException;

    void passarOperadorsAno();
}
