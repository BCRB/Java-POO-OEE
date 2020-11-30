package Controlador;

import Modelo.Operador;
import Modelo.Relatorio;
import Modelo.Supervisor;
import Modelo.Op;
import Repositorio.*;
import Excecoes.OperadorException;


public class ControladorOperador implements IControladorOperador {

    private static IRepOp repOp;
    private static IRepOperador repOperador;
    private static IRepSupervisor repSupervisor;

    private static ControladorOperador instancia;

    private ControladorOperador() {
        repOp = RepOp.getInstancia();
        repOperador = RepOperador.getInstancia();
        repSupervisor = RepSupervisor.getInstancia();
    }

    public static ControladorOperador getInstancia() {
        if (instancia == null) {
            instancia = new ControladorOperador();
        }

        return instancia;
    }

    @Override
    public Relatorio checarQuantidades(int idMaquina, String codigo) throws OperadorException {
        if (repOperador.existeOperador(codigo)) {
            Operador a = repOperador.checarQuantidades(codigo);
            return a.getRelatorio();
        } else {
            throw new OperadorException("Operador não encontrado.");
        }
    }

    @Override
    public Op mostrarOps(String codigo) throws OperadorException {

        if (repOp.existeOp(codigo)) {
            return repOp.mostrarOp(codigo);
        } else {
            throw new OperadorException("Op não existe.");
        }
    }

    @Override
    public Supervisor pesquisarSupervisorCodigo(String codigo) throws OperadorException {
        if (repSupervisor.existeSupervisor(codigo)) {
            return repSupervisor.pesquisarSupervisorCodigo(codigo);
        } else {
            throw new OperadorException("Supervisor não existe. ");
        }
    }
}
