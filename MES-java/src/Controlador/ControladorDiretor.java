package Controlador;


import Modelo.Gerente;
import Modelo.Endereco;
import Repositorio.IRepGerente;
import Repositorio.RepGerente;
import Excecoes.DiretorException;

public class ControladorDiretor implements IControladorDiretor {

    private static IRepGerente repGerente;

    private static ControladorDiretor instancia;

    private ControladorDiretor() {
        repGerente = RepGerente.getInstancia();
    }

    public static ControladorDiretor getInstancia() {
        if (instancia == null) {
            instancia = new ControladorDiretor();
        }
        return instancia;
    }

    @Override
    public void cadastrarGerente(Gerente Gerente) throws DiretorException {
        if (repGerente.existeGerente(Gerente.getCodigo())) {
            throw new DiretorException("Gerente com o mesmo código já cadastrado!");
        } else {
            repGerente.cadastrarGerente(Gerente);
        }
    }

    public void removerGerenteCodigo(String codigo) throws DiretorException {
        if (repGerente.existeGerente(codigo)) {
            repGerente.removerGerenteCodigo(codigo);
        } else {
            throw new DiretorException("Gerente não existe!");
        }
    }

    public void substituirGerente(String codigo, Gerente novoGerente) throws DiretorException {
        if (repGerente.existeGerente(codigo)) {
            repGerente.substituirGerente(codigo, novoGerente);
        } else {
            throw new DiretorException("Gerente não existe!");
        }
    }

    public void removerEnderecoD(String codigo) throws DiretorException {
        if (repGerente.existeGerente(codigo)) {
            repGerente.removerEnderecoD(codigo);
        } else {
            throw new DiretorException("Gerente não existe!");
        }
    }

    public Gerente pesquisarGerenteCodigo(String codigo, String cpf) throws DiretorException {

        if (repGerente.existeGerente(codigo)) {
            return repGerente.PesquisarGerenteCodigo(codigo, cpf);
        } else {
            throw new DiretorException("Gerente não existe. ");
        }

    }

    @Override
    public void trocarEndD(String codigo, Endereco endereco) throws DiretorException {
        if (repGerente.existeGerente(codigo)) {
            if (repGerente.TrocarEndD(codigo, endereco)) {
            } else {
                throw new DiretorException("Endereço do Gerente não cadastrado.");
            }
        } else {
            throw new DiretorException("Gerente não existe!");
        }
    }

    public void cadastrarEnderecoGerente(Endereco endereco, String codigo) throws DiretorException {
        if (repGerente.cadastrarEnderecoGerente(endereco, codigo)) {
        } else {
            throw new DiretorException("Endereço já cadastrado!");
        }
    }

    public void AtualizarSalarioGerente(String codigo, Double novoSalario) throws DiretorException {
        if (repGerente.existeGerente(codigo)) {
            repGerente.AtualizarSalarioGerente(codigo, novoSalario);

        } else {
            throw new DiretorException("Gerente Inexistente. ");
        }
    }

    @Override
    public void aumentarSalarioD(String codigo) throws DiretorException {
        if (repGerente.existeGerente(codigo)) {
            repGerente.aumentarSalarioD(codigo);
        } else {
            throw new DiretorException("Gerente não existe. ");
        }
    }
}

