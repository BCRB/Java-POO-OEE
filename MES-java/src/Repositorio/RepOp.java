package Repositorio;

import Modelo.Op;

import java.util.ArrayList;
import java.util.List;

public class RepOp implements IRepOp {

    private static RepOp instancia;
    private List<Op> listaOp;

    private RepOp() {
        listaOp = new ArrayList<>();
    }

    public static RepOp getInstancia() {
        if (instancia == null) {
            instancia = new RepOp();
        }
        return instancia;
    }

    @Override
    public void mandarOp(Op Op) {
        listaOp.add(Op);

    }

    public boolean existeOp(int prazo) {
        for (Op Op : listaOp) {
            if (Op != null && Op.getPrazo() == prazo) {
                return true;
            }
        }
        return false;
    }

    public boolean existeOp(String codigo) {
        for (Op Op : listaOp) {
            if (Op != null && Op.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removerOp(String codigo) {
        for (int i = 0; i < listaOp.size(); i++) {
            if (listaOp.get(i) != null && listaOp.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaOp.remove(i);
            }
        }

    }

    @Override
    public void removerOp(int prazo) {
        for (int i = 0; i < listaOp.size(); i++) {
            if (listaOp.get(i) != null && listaOp.get(i).getPrazo() == prazo) {
                listaOp.remove(i);
            }
        }
    }

    @Override
    public Op mostrarOp(String codigo) {
        for (Op Op : listaOp) {
            if (Op != null && Op.getCodigo().equalsIgnoreCase(codigo)) {
                return Op;
            }
        }
        return null;
    }

    @Override
    public void substituirT(Op t) {
        for (int i = 0; i < listaOp.size(); i++) {
            if (listaOp.get(i) != null && t.getCodigo().equalsIgnoreCase(listaOp.get(i).getCodigo())) {
                listaOp.remove(i);
                listaOp.add(t);
            }
        }
    }

}


