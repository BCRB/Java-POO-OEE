package Controlador;

import Repositorio.IRepProducao;
import Repositorio.RepProducao;
import Excecoes.ProducaoException;

public class ControladorProducao implements IControladorProducao {
    private static IRepProducao repProducao;

    private static ControladorProducao instancia;

    private ControladorProducao() {
        repProducao = RepProducao.getInstancia();
    }

    public static ControladorProducao getInstancia() {
        if (instancia == null) {
            instancia = new ControladorProducao();
        }
        return instancia;
    }

    @Override
    public int iniciarProducao(int codigo) throws ProducaoException {
        if (codigo >= 1 && codigo <= 3) {
            if (repProducao.verificaProducao(codigo)) {
                return repProducao.iniciarProducao(codigo);
            } else {
                throw new ProducaoException("Producao indisponivel. ");
            }
        } else {
            throw new ProducaoException("Codigo inválido. ");
        }
    }

    @Override
    public void pararProducao(int codigo) throws ProducaoException {
        if (codigo >= 0 && codigo <= 8) {
            if (!repProducao.verificaProducao(codigo)) {
                if (codigo >= 0 && codigo <= 2) {
                    repProducao.pararProducao(codigo, 1);
                } else if (codigo >= 3 && codigo <= 5) {
                    repProducao.pararProducao(codigo, 2);
                } else if (codigo >= 6 && codigo <= 8) {
                    repProducao.pararProducao(codigo, 3);
                }
            } else {
                throw new ProducaoException("Producao indisponivel. ");
            }
        } else {
            throw new ProducaoException("Codigo inválido. ");
        }
    }
}
