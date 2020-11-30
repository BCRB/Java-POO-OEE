package Repositorio;

import Modelo.ProducaoGarrafa;
import Modelo.ProducaoLata;
import Modelo.ProducaoPote;

public class RepProducao implements IRepProducao {

    private static RepProducao instancia;
    private ProducaoLata[] arrayProducaoC = new ProducaoLata[3];
    private ProducaoGarrafa[] arrayProducaoA = new ProducaoGarrafa[3];
    private ProducaoPote[] arrayProducaoI = new ProducaoPote[3];

    private RepProducao() {
        for (int i = 0; i <= 2; i++) {
            arrayProducaoC[i] = new ProducaoLata();
            arrayProducaoA[i] = new ProducaoGarrafa();
            arrayProducaoI[i] = new ProducaoPote();
        }
    }


    public static IRepProducao getInstancia() {
        if (instancia == null) {
            instancia = new RepProducao();
        }
        return instancia;
    }


    @Override
    public int iniciarProducao(int codigo) {
        switch (codigo) {
            case 1:
                for (int i = 0; i <= 2; i++) {
                    if (!arrayProducaoA[i].getOcupada()) {
                        arrayProducaoA[i].setOcupada(true);
                        arrayProducaoA[i].setCodigo(i);
                        return arrayProducaoA[i].getCodigo();
                    }
                }
                break;
            case 2:
                int j = 3;
                for (int i = 0; i <= 2; i++) {
                    if (!arrayProducaoI[i].getOcupada()) {
                        arrayProducaoI[i].setOcupada(true);
                        arrayProducaoI[i].setCodigo(j);
                        return arrayProducaoI[i].getCodigo();
                    }
                    j++;
                }
                break;
            case 3:
                int k = 5;
                for (int i = 0; i <= 2; i++) {
                    if (!arrayProducaoC[i].getOcupada()) {
                        arrayProducaoC[i].setOcupada(true);
                        arrayProducaoC[i].setCodigo(k);
                        return arrayProducaoC[i].getCodigo();
                    }
                    k++;
                }
                break;
        }
        return 0;
    }

    @Override
    public void pararProducao(int codigo, int opcao) {
        switch (opcao) {
            case 1:
                for (int i = 0; i <= 2; i++) {
                    if (arrayProducaoA[i].getOcupada() && arrayProducaoA[i].getCodigo() == codigo) {
                        arrayProducaoA[i].setOcupada(false);
                        break;
                    }
                }
            case 2:
                for (int i = 0; i <= 2; i++) {
                    if (arrayProducaoI[i].getOcupada() && arrayProducaoI[i].getCodigo() == codigo) {
                        arrayProducaoI[i].setOcupada(false);
                        break;
                    }
                }
            case 3:
                for (int i = 0; i <= 2; i++) {
                    if (arrayProducaoC[i].getOcupada() && arrayProducaoC[i].getCodigo() == codigo) {
                        arrayProducaoC[i].setOcupada(false);
                        break;
                    }
                }
        }
    }

    public boolean verificaProducao(int codigo) {
        switch (codigo) {
            case 1:
                for (int i = 0; i <= 2; i++) {
                    if (!arrayProducaoA[i].getOcupada()) {
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i <= 2; i++) {
                    if (!arrayProducaoI[i].getOcupada()) {
                        return true;
                    }
                }
                break;
            case 3:
                for (int i = 0; i <= 2; i++) {
                    if (!arrayProducaoC[i].getOcupada()) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }


}


