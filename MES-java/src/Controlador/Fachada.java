package Controlador;

import Modelo.*;
import Excecoes.*;

public class Fachada implements IControladorGerente, IControladorSupervisor, IControladorOperador, IControladorProducao, IControladorDiretor {

    private static Fachada instancia;
    private final IControladorSupervisor controladorSupervisor;
    private final IControladorGerente controladorGerente;
    private final IControladorOperador controladorOperador;
    private final IControladorProducao controladorProducao;
    private final IControladorDiretor controladorDiretor;

    private Fachada() {
        controladorGerente = ControladorGerente.getInstancia();
        controladorSupervisor = ControladorSupervisor.getInstancia();
        controladorOperador = ControladorOperador.getInstancia();
        controladorProducao = ControladorProducao.getInstancia();
        controladorDiretor = ControladorDiretor.getInstancia();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    @Override
    public void cadastrarOperador(Operador a) throws GerenteException {
        controladorGerente.cadastrarOperador(a);
    }

    @Override
    public void removerOperadorCodigo(String codigo) throws GerenteException {
        controladorGerente.removerOperadorCodigo(codigo);
    }

    //OVERLOAD
    public Operador pesquisarOperadorCodigo(String codigo) throws SupervisorException {
        return controladorSupervisor.pesquisarOperadorCodigo(codigo);
    }

    public Operador pesquisarOperadorCodigo(String codigo, String cpf) throws GerenteException {
        return controladorGerente.pesquisarOperadorCodigo(codigo, cpf);
    }

    //OVERLOAD
    public Supervisor pesquisarSupervisorCodigo(String codigo, String cpf) throws GerenteException {
        return controladorGerente.pesquisarSupervisorCodigo(codigo, cpf);
    }

    public Supervisor pesquisarSupervisorCodigo(String codigo) throws OperadorException {
        return controladorOperador.pesquisarSupervisorCodigo(codigo);
    }

    //OVERLOAD
    public void aumentarSalarioP(String codigo) throws GerenteException {
        controladorGerente.aumentarSalarioP(codigo);
    }

    public void aumentarSalarioP(String codigo, double quantidade) throws GerenteException {
        controladorGerente.aumentarSalarioP(codigo, quantidade);
    }

    @Override
    public void trocarSupervisor(String codigo, Supervisor novoSupervisor) throws GerenteException {
        controladorGerente.trocarSupervisor(codigo, novoSupervisor);
    }

    //OVERLOAD
    public void removerOp(String codigo) throws SupervisorException {
        controladorSupervisor.removerOp(codigo);
    }

    public void removerOp(int prazo) throws SupervisorException {
        controladorSupervisor.removerOp(prazo);
    }

    @Override
    public void cadastrarSupervisor(Supervisor p) throws GerenteException {
        ControladorGerente.getInstancia().cadastrarSupervisor(p);
    }

    @Override
    public void removerSupervisorCodigo(String codigo) throws GerenteException {
        controladorGerente.removerSupervisorCodigo(codigo);
    }

    @Override
    public void alterarQuantidades(String codigo, double Quantidade, int unidade, int idMaquina) throws SupervisorException {
        controladorSupervisor.alterarQuantidades(codigo, Quantidade, unidade, idMaquina);

    }

    @Override
    public void mandarOp(Op Op) throws SupervisorException {
        controladorSupervisor.mandarOp(Op);
    }

    @Override
    public Relatorio checarQuantidades(int idMaquina, String codigo) throws OperadorException {
        return controladorOperador.checarQuantidades(idMaquina, codigo);
    }

    @Override
    public Op mostrarOps(String codigo) throws OperadorException, SupervisorException {
        return controladorOperador.mostrarOps(codigo);
    }

    @Override
    public int iniciarProducao(int codigo) throws ProducaoException {
        return controladorProducao.iniciarProducao(codigo);
    }

    public void cadastrarGerente(Gerente Gerente) throws DiretorException {
        controladorDiretor.cadastrarGerente(Gerente);
    }

    public void removerGerenteCodigo(String codigo) throws DiretorException {
        controladorDiretor.removerGerenteCodigo(codigo);
    }

    @Override
    public void substituirGerente(String codigo, Gerente novoGerente) throws DiretorException {
        controladorDiretor.substituirGerente(codigo, novoGerente);
    }


    @Override
    public void removerEnderecoP(String codigo) throws GerenteException {
        controladorGerente.removerEnderecoP(codigo);
    }

    public void removerEnderecoD(String codigo) throws DiretorException {
        controladorDiretor.removerEnderecoD(codigo);
    }

    @Override
    public Gerente pesquisarGerenteCodigo(String codigo, String cpf) throws DiretorException {
        return controladorDiretor.pesquisarGerenteCodigo(codigo, cpf);
    }

    @Override
    public void trocarEndD(String codigo, Endereco endereco) throws DiretorException {
        controladorDiretor.trocarEndD(codigo, endereco);
    }

    public void removerEnderecoA(String codigo) throws GerenteException {
        controladorGerente.removerEnderecoA(codigo);
    }

    @Override
    public void trocarEnderecoA(String codigo, Endereco endereco) throws GerenteException {
        controladorGerente.trocarEnderecoA(codigo, endereco);
    }

    public void trocarEnderecoP(String codigo, Endereco endereco) throws GerenteException {
        controladorGerente.trocarEnderecoP(codigo, endereco);
    }

    public void substituirT(Op t) throws SupervisorException {
        controladorSupervisor.substituirT(t);
    }

    public void cadastrarEnderecoGerente(Endereco endereco, String codigo) throws DiretorException {
        controladorDiretor.cadastrarEnderecoGerente(endereco, codigo);
    }

    @Override
    public void AtualizarSalarioGerente(String codigo, Double novoSalario) throws DiretorException {
        controladorDiretor.AtualizarSalarioGerente(codigo, novoSalario);
    }

    public void aumentarSalarioD(String codigo) throws DiretorException {
        controladorDiretor.aumentarSalarioD(codigo);
    }

    public void cadastrarEnderecoSupervisor(Endereco endereco, String codigo) throws GerenteException {
        controladorGerente.cadastrarEnderecoSupervisor(endereco, codigo);
    }

    public void cadastrarEnderecoOperador(Endereco endereco, String codigo) throws GerenteException {
        controladorGerente.cadastrarEnderecoOperador(endereco, codigo);
    }

    public void passarOperadorsAno() {
        controladorSupervisor.passarOperadorsAno();
    }

    public void pararProducao(int codigo) throws ProducaoException {
        controladorProducao.pararProducao(codigo);
    }
}

