package Controlador;

import Modelo.Operador;
import Modelo.Endereco;
import Modelo.Supervisor;
import Repositorio.IRepOperador;
import Repositorio.IRepSupervisor;
import Repositorio.RepOperador;
import Repositorio.RepSupervisor;
import Excecoes.GerenteException;

public class ControladorGerente implements IControladorGerente {

    private static IRepOperador repOperador;
    private static IRepSupervisor repSupervisor;

    private static ControladorGerente instancia;

    private ControladorGerente() {
        repOperador = RepOperador.getInstancia();
        repSupervisor = RepSupervisor.getInstancia();
    }

    public static ControladorGerente getInstancia() {
        if (instancia == null) {
            instancia = new ControladorGerente();
        }
        return instancia;
    }

    @Override
    public void cadastrarOperador(Operador a) throws GerenteException {
        if (repOperador.existeOperador(a.getCodigo())) {
            throw new GerenteException("Operador com mesmo código já cadastrado!");
        }
        if (repOperador.checarSerie(a)) {
            throw new GerenteException("Série invalida!");
        } else {
            repOperador.cadastrarOperador(a);
        }
    }

    @Override
    public void removerOperadorCodigo(String codigo) throws GerenteException {
        if (repOperador.existeOperador(codigo)) {
            repOperador.removerOperadorCodigo(codigo);
        } else {
            throw new GerenteException("Operador não existe!");
        }
    }

    @Override
    public Operador pesquisarOperadorCodigo(String codigo, String cpf) throws GerenteException {
        if (repOperador.existeOperador(codigo)) {
            return repOperador.pesquisarOperadorCodigo(codigo, cpf);

        } else {
            throw new GerenteException("Operador não existe. ");
        }
    }

    @Override
    public void cadastrarSupervisor(Supervisor p) throws GerenteException {
        if (repSupervisor.existeSupervisor(p.getCodigo())) {
            throw new GerenteException("Supervisor com mesmo código já cadastrado!");
        } else {
            repSupervisor.cadastrarSupervisor(p);
        }
    }

    //OVERLOAD
    public Supervisor pesquisarSupervisorCodigo(String codigo, String cpf) throws GerenteException {

        if (repSupervisor.existeSupervisor(codigo)) {
            return repSupervisor.pesquisarSupervisorCodigo(codigo, cpf);
        } else {
            throw new GerenteException("Supervisor não existe. ");
        }

    }

    public void removerSupervisorCodigo(String codigo) throws GerenteException {
        if (repSupervisor.existeSupervisor(codigo)) {
            repSupervisor.removerSupervisorCodigo(codigo);
        } else {
            throw new GerenteException("Supervisor não existe. ");
        }
    }

    @Override
    public void aumentarSalarioP(String codigo) throws GerenteException {
        if (repSupervisor.existeSupervisor(codigo)) {
            repSupervisor.aumentarSalario(codigo);
        } else {
            throw new GerenteException("Supervisor não existe. ");
        }
    }

    @Override
    public void aumentarSalarioP(String codigo, double quantidade) throws GerenteException {
        if (repSupervisor.existeSupervisor(codigo)) {
            repSupervisor.aumentarSalario(codigo, quantidade);
        } else {
            throw new GerenteException("Supervisor não existe. ");
        }
    }

    public void trocarSupervisor(String codigo, Supervisor novoSupervisor) throws GerenteException {
        if (repSupervisor.existeSupervisor(codigo)) {
            repSupervisor.trocarSupervisor(codigo, novoSupervisor);
        } else {
            throw new GerenteException("Supervisor não existe!");
        }
    }

    public void removerEnderecoP(String codigo) throws GerenteException {
        if (repSupervisor.existeSupervisor(codigo)) {
            repSupervisor.removerEnderecoP(codigo);
        } else {
            throw new GerenteException("Supervisor não existe!");
        }
    }

    public void removerEnderecoA(String codigo) throws GerenteException {
        if (repOperador.existeOperador(codigo)) {
            repOperador.removerEnderecoA(codigo);
        } else {
            throw new GerenteException("Operador não existe!");
        }
    }

    @Override
    public void trocarEnderecoA(String codigo, Endereco endereco) throws GerenteException {
        if (repOperador.existeOperador(codigo)) {
            if (repOperador.trocarEnderecoA(codigo, endereco)) {
            } else {
                throw new GerenteException("Endereço do Operador não cadastrado.");
            }
        } else {
            throw new GerenteException("Operador não existe!");
        }
    }

    @Override
    public void trocarEnderecoP(String codigo, Endereco endereco) throws GerenteException {
        if (repSupervisor.existeSupervisor(codigo)) {
            if (repSupervisor.trocarEnderecoP(codigo, endereco)) {
            } else {
                throw new GerenteException("Endereço do Supervisor não cadastrado.");
            }
        } else {
            throw new GerenteException("Supervisor não existe!");
        }
    }

    @Override
    public void cadastrarEnderecoOperador(Endereco endereco, String codigo) throws GerenteException {
        if (repOperador.cadastrarEnderecoOperador(endereco, codigo)) {
        } else {
            throw new GerenteException("Endereço já cadastrado!");
        }
    }

    @Override
    public void cadastrarEnderecoSupervisor(Endereco endereco, String codigo) throws GerenteException {
        if (repSupervisor.cadastrarEnderecoSupervisor(endereco, codigo)) {
        } else {
            throw new GerenteException("Endereço já cadastrado!");
        }
    }

}
