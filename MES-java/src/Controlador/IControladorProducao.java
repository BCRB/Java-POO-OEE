package Controlador;

import Excecoes.ProducaoException;

interface IControladorProducao {

    int iniciarProducao(int codigo) throws ProducaoException;

    void pararProducao(int codigo) throws ProducaoException;
}
