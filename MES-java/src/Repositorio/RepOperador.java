package Repositorio;

import Modelo.Operador;
import Modelo.Relatorio;
import Modelo.Endereco;

import java.util.ArrayList;
import java.util.List;

public class RepOperador implements IRepOperador {
    private static RepOperador instancia;
    private List<Operador> listaOperador;

    private RepOperador() {
        listaOperador = new ArrayList<>();
    }

    public static RepOperador getInstancia() {
        if (instancia == null) {
            instancia = new RepOperador();
        }
        return instancia;
    }

    @Override

    public void cadastrarOperador(Operador Operador) {
        listaOperador.add(Operador);
    }

    @Override

    public Operador pesquisarOperadorCodigo(String codigo) {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getCodigo().equalsIgnoreCase(codigo)) {
                Operador.setCpf(null);
                return Operador;
            }
        }
        return null;
    }

    @Override
    public Operador pesquisarOperadorCodigo(String codigo, String cpf) {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getCodigo().equalsIgnoreCase(codigo) && Operador.getCpf().equalsIgnoreCase(cpf)) {
                return Operador;
            }
        }
        return null;
    }

    public void removerEnderecoA(String codigo) {
        for (int i = 0; i < listaOperador.size(); i++) {
            if (listaOperador.get(i) != null && listaOperador.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaOperador.get(i).setEndereco(null);
            }
        }
    }

    @Override
    public boolean trocarEnderecoA(String codigo, Endereco endereco) {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getCodigo().equalsIgnoreCase(codigo) && Operador.getEndereco() != null) {
                Operador.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerOperadorCodigo(String codigo) {
        for (int i = 0; i < listaOperador.size(); i++) {
            if (listaOperador.get(i) != null && listaOperador.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaOperador.remove(i);
            }
        }
    }

    public boolean existeOperador(String codigo) {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void alterarQuantidades(String codigo, double Quantidade, int unidade, int idMaquina) {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getCodigo().equalsIgnoreCase(codigo)) {
                if (unidade == 1) {
                    switch (idMaquina) {
                        case 1:
                            Operador.getRelatorio().getLavadora().setQuantidade1(Quantidade);
                            break;
                        case 2:
                            Operador.getRelatorio().getEnchedora().setQuantidade1(Quantidade);
                            break;
                        case 3:
                            Operador.getRelatorio().getRotuladora().setQuantidade1(Quantidade);
                            break;
                        case 4:
                            Operador.getRelatorio().getEmpacotadora().setQuantidade1(Quantidade);
                            break;
                        case 5:
                            Operador.getRelatorio().getPaletizadora().setQuantidade1(Quantidade);
                            break;
                    }
                } else if (unidade == 2) {
                    switch (idMaquina) {
                        case 1:
                            Operador.getRelatorio().getLavadora().setQuantidade2(Quantidade);
                            break;
                        case 2:
                            Operador.getRelatorio().getEnchedora().setQuantidade2(Quantidade);
                            break;
                        case 3:
                            Operador.getRelatorio().getRotuladora().setQuantidade2(Quantidade);
                            break;
                        case 4:
                            Operador.getRelatorio().getEmpacotadora().setQuantidade2(Quantidade);
                            break;
                        case 5:
                            Operador.getRelatorio().getPaletizadora().setQuantidade2(Quantidade);
                            break;
                    }
                } else if (unidade == 3) {
                    switch (idMaquina) {
                        case 1:
                            Operador.getRelatorio().getLavadora().setQuantidade3(Quantidade);
                            break;
                        case 2:
                            Operador.getRelatorio().getEnchedora().setQuantidade3(Quantidade);
                            break;
                        case 3:
                            Operador.getRelatorio().getRotuladora().setQuantidade3(Quantidade);
                            break;
                        case 4:
                            Operador.getRelatorio().getEmpacotadora().setQuantidade3(Quantidade);
                            break;
                        case 5:
                            Operador.getRelatorio().getPaletizadora().setQuantidade3(Quantidade);
                            break;
                    }
                }
            }
        }
        alterarmeta(codigo, idMaquina);
    }

    private void alterarmeta(String codigo, int idMaquina) {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getCodigo().equalsIgnoreCase(codigo)) {
                switch (idMaquina) {
                    case 1:
                        if ((Operador.getRelatorio().getLavadora().getQuantidade1() != null) && (Operador.getRelatorio().getLavadora().getQuantidade2() != null) && (Operador.getRelatorio().getLavadora().getQuantidade3() != null)) {
                            Operador.getRelatorio().getLavadora().setmeta((Operador.getRelatorio().getLavadora().getQuantidade1() + Operador.getRelatorio().getLavadora().getQuantidade2() + Operador.getRelatorio().getLavadora().getQuantidade3()) / 3);
                        }
                        if ((Operador.getRelatorio().getLavadora().getmeta() != null) && Operador.getRelatorio().getLavadora().getmeta() >= 7) {
                            Operador.getRelatorio().getLavadora().setAprovado(true);
                        } else {
                            Operador.getRelatorio().getLavadora().setAprovado(false);
                        }
                        break;
                    case 2:
                        if ((Operador.getRelatorio().getEnchedora().getQuantidade1() != null) && (Operador.getRelatorio().getEnchedora().getQuantidade2() != null) && (Operador.getRelatorio().getEnchedora().getQuantidade3() != null)) {
                            Operador.getRelatorio().getEnchedora().setmeta((Operador.getRelatorio().getEnchedora().getQuantidade1() + Operador.getRelatorio().getEnchedora().getQuantidade2() + Operador.getRelatorio().getEnchedora().getQuantidade3()) / 3);
                        }
                        if ((Operador.getRelatorio().getEnchedora().getmeta() != null) && Operador.getRelatorio().getEnchedora().getmeta() >= 7) {
                            Operador.getRelatorio().getEnchedora().setAprovado(true);
                        } else {
                            Operador.getRelatorio().getEnchedora().setAprovado(false);
                        }
                        break;
                    case 3:
                        if ((Operador.getRelatorio().getRotuladora().getQuantidade1() != null) && (Operador.getRelatorio().getRotuladora().getQuantidade2() != null) && (Operador.getRelatorio().getRotuladora().getQuantidade3() != null)) {
                            Operador.getRelatorio().getRotuladora().setmeta((Operador.getRelatorio().getRotuladora().getQuantidade1() + Operador.getRelatorio().getRotuladora().getQuantidade2() + Operador.getRelatorio().getRotuladora().getQuantidade3()) / 3);
                        }
                        if ((Operador.getRelatorio().getRotuladora().getmeta() != null) && Operador.getRelatorio().getRotuladora().getmeta() >= 7) {
                            Operador.getRelatorio().getRotuladora().setAprovado(true);
                        } else {
                            Operador.getRelatorio().getRotuladora().setAprovado(false);
                        }
                        break;
                    case 4:
                        if ((Operador.getRelatorio().getEmpacotadora().getQuantidade1() != null) && (Operador.getRelatorio().getEmpacotadora().getQuantidade2() != null) && (Operador.getRelatorio().getEmpacotadora().getQuantidade3() != null)) {
                            Operador.getRelatorio().getEmpacotadora().setmeta((Operador.getRelatorio().getEmpacotadora().getQuantidade1() + Operador.getRelatorio().getEmpacotadora().getQuantidade2() + Operador.getRelatorio().getEmpacotadora().getQuantidade3()) / 3);
                        }
                        if ((Operador.getRelatorio().getEmpacotadora().getmeta() != null) && Operador.getRelatorio().getEmpacotadora().getmeta() >= 7) {
                            Operador.getRelatorio().getEmpacotadora().setAprovado(true);
                        } else {
                            Operador.getRelatorio().getEmpacotadora().setAprovado(false);
                        }
                        break;
                    case 5:
                        if ((Operador.getRelatorio().getPaletizadora().getQuantidade1() != null) && (Operador.getRelatorio().getPaletizadora().getQuantidade2() != null) && (Operador.getRelatorio().getPaletizadora().getQuantidade3() != null)) {
                            Operador.getRelatorio().getPaletizadora().setmeta((Operador.getRelatorio().getPaletizadora().getQuantidade1() + Operador.getRelatorio().getPaletizadora().getQuantidade2() + Operador.getRelatorio().getPaletizadora().getQuantidade3()) / 3);
                        }
                        if ((Operador.getRelatorio().getPaletizadora().getmeta() != null) && Operador.getRelatorio().getPaletizadora().getmeta() >= 7) {
                            Operador.getRelatorio().getPaletizadora().setAprovado(true);
                        } else {
                            Operador.getRelatorio().getPaletizadora().setAprovado(false);
                        }
                        break;
                }
            }
        }
    }

    public Operador checarQuantidades(String codigo) {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getCodigo().equalsIgnoreCase(codigo)) {
                return Operador;
            }
        }
        return null;
    }

    public boolean cadastrarEnderecoOperador(Endereco endereco, String codigo) {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getCodigo().equalsIgnoreCase(codigo) && Operador.getEndereco() == null) {
                Operador.setEndereco(endereco);
                return true;
            }
        }
        return false;
    }

    @Override
    public void passarOperadorsAno() {
        for (Operador Operador : listaOperador) {
            if (Operador != null && Operador.getSerie() <= 2) {
                if (Operador.getRelatorio().getPaletizadora().isAprovado() && Operador.getRelatorio().getEmpacotadora().isAprovado() &&
                        Operador.getRelatorio().getRotuladora().isAprovado() && Operador.getRelatorio().getEnchedora().isAprovado()
                        && Operador.getRelatorio().getLavadora().isAprovado()) {
                    Operador.setSerie(Operador.getSerie() + 1);
                    Operador.setRelatorio(new Relatorio());
                }
            } else {
                listaOperador.remove(Operador);
            }
        }
    }

    @Override
    public boolean checarSerie(Operador a) {
        if (a.getSerie() <= 1 || a.getSerie() >= 3) {
            return false;
        }
        return true;
    }
}
