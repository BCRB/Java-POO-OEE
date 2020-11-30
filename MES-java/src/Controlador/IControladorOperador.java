package Controlador;

import Modelo.Relatorio;
import Modelo.Supervisor;
import Modelo.Op;
import Excecoes.OperadorException;
import Excecoes.SupervisorException;


interface IControladorOperador {

    Relatorio checarQuantidades(int idMaquina, String codigo) throws OperadorException;

    Op mostrarOps(String codigo) throws OperadorException, SupervisorException;

    Supervisor pesquisarSupervisorCodigo(String codigo) throws OperadorException;
}
