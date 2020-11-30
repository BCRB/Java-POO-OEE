package Controlador;


import Modelo.Operador;
import Modelo.Op;
import Repositorio.IRepOperador;
import Repositorio.IRepOp;
import Repositorio.RepOperador;
import Repositorio.RepOp;
import Excecoes.SupervisorException;

public class ControladorSupervisor implements IControladorSupervisor {

    private static IRepOperador repOperador;
    private static IRepOp repOp;

    private static ControladorSupervisor instancia;

    private ControladorSupervisor() {
        repOperador = RepOperador.getInstancia();
        repOp = RepOp.getInstancia();
    }

    public static ControladorSupervisor getInstancia() {
        if (instancia == null) {
            instancia = new ControladorSupervisor();
        }
        return instancia;
    }

    @Override
    public void alterarQuantidades(String codigo, double Quantidade, int unidade, int idMaquina) throws SupervisorException {
        if (repOperador.existeOperador(codigo) && Quantidade >= 0 && Quantidade <= 10) {
            repOperador.alterarQuantidades(codigo, Quantidade, unidade, idMaquina);
        } else {
            throw new SupervisorException("Erro ao alterar Quantidade. ");
        }
    }

    @Override
    public void mandarOp(Op Op) throws SupervisorException {
        if (repOp.existeOp(Op.getCodigo())) {
            throw new SupervisorException("Op com mesmo código já cadastrado. \n ");
        } else {
            repOp.mandarOp(Op);
        }

    }

    @Override
    public void removerOp(String codigo) throws SupervisorException {
        if (RepOp.getInstancia().existeOp(codigo)) {
            repOp.removerOp(codigo);
        } else {
            throw new SupervisorException("Op não existe. \n ");
        }
    }

    @Override
    public void removerOp(int prazo) throws SupervisorException {
        if (RepOp.getInstancia().existeOp(prazo)) {
            repOp.removerOp(prazo);
        } else {
            throw new SupervisorException("Op não existe. \n ");
        }
    }


    @Override
    public Operador pesquisarOperadorCodigo(String codigo) throws SupervisorException {
        if (repOperador.existeOperador(codigo)) {
            return repOperador.pesquisarOperadorCodigo(codigo);
        } else {
            throw new SupervisorException("Operador não existe. ");
        }
    }

    @Override
    public void substituirT(Op t) throws SupervisorException {
        if (repOp.existeOp(t.getCodigo())) {
            repOp.substituirT(t);
        } else {
            throw new SupervisorException("Op não existe!");
        }
    }

    public void passarOperadorsAno() {
        repOperador.passarOperadorsAno();
    }
}

