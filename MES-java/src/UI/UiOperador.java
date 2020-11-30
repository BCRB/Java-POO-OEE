package UI;

import Controlador.Fachada;
import Modelo.Relatorio;
import Modelo.Supervisor;
import Modelo.Op;
import Excecoes.OperadorException;
import Excecoes.SupervisorException;
import Excecoes.ProducaoException;

import java.util.Scanner;

import Constants.Constantes;

class UiOperador {
    private static Scanner s = new Scanner(System.in);

    void MenuOperador() {
        int menu;
        do {
            System.out.println("Digite: \n1: Para consultar a PRODUÇÃO. " +
                    "\n2: Para consultar as ORDEN DE PRODUÇÃO.\n3: Para consultar SUPERVISOR " +
                    "\n4: Iniciar a PRODUÇÃO. \n5: Parar a PRODUÇÃO. \n0: Para SAIR.  ");
            menu = s.nextInt();
            switch (menu) {
                case 1:
                    checarQuantidades();
                    break;
                case 2:
                    MostrarOps();
                    break;
                case 3:
                    PesquisarSupervisor();
                    break;
                case 4:
                    iniciarProducao();
                    break;
                case 5:
                    pararProducao();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Obrigado por utilizar. ");
                    break;
            }

        } while (menu != 0);


    }

    private void pararProducao() {
        try {
            System.out.println("Digite o codigo da linha de produção que você deseja parar: ");
            int codigo = s.nextInt();
            Fachada.getInstancia().pararProducao(codigo);
            System.out.println("Linha de produção parada com sucesso!");
        } catch (ProducaoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void MostrarOps() {
        String codigo;

        System.out.println("Digite o codigo da ordem de produção que voce deseja consultar: ");
        codigo = s.next();

        try {
            Op t;
            t = Fachada.getInstancia().mostrarOps(codigo);


            System.out.println("Quantidade: " + t.getConteudo());
            System.out.println("Prazo: " + t.getPrazo());
            System.out.println("Codigo da ordem de produção: " + t.getCodigo());

        } catch (OperadorException | SupervisorException e) {
            System.out.println(e.getMessage());
        }

    }

    private void PesquisarSupervisor() {
        try {
            System.out.println("Digite o codigo do SUPERVISOR: ");
            Supervisor p;
            p = Fachada.getInstancia().pesquisarSupervisorCodigo(s.next());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Sexo: " + p.getSexo());
            System.out.println("Idade: " + p.getIdade());
        } catch (OperadorException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void iniciarProducao() {
        try {
            System.out.println("Qual linha de produção será utilizada? \n1: Linha de GARRAFA\n2: Linha de LATA\n3: Linha de COPO ");
            int tipo = s.nextInt();
            int codigo = Fachada.getInstancia().iniciarProducao(tipo);
            System.out.println("Produção inciada com sucesso. \n" +
                    "O código da linha de produção é: " + codigo);
        } catch (ProducaoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void checarQuantidades() {
        System.out.println("Qual centro de Trabalho voce deseja consultar a PRODUÇÃO:\n1-Lavadora" +
                "\n2-Enchedora\n3-Rotuladora\n4-Empacotadora\n5-Paletizadora ");
        int idMaquina = s.nextInt();
        System.out.println("Digite seu código de OPERADOR:");
        String codigo = s.next();
        Relatorio Relatorio;
       
        try {
            Relatorio = Fachada.getInstancia().checarQuantidades(idMaquina, codigo);
            switch (idMaquina) {
                case 1:
                                        
                        System.out.println("Linha de Produção: Lavadora");
                        System.out.println("Quantidade Boa:" +Constantes.QuantBoa + " unidade" );
                        System.out.println("Quantidade Refugo:" +Constantes.QuantRefugo+" unidade" );
                        System.out.println("Tempo Parado:" +Constantes.TempoParado +" minutos");
                        System.out.println("Tempo Produtivo:" +Constantes.TempoProdutivo +" minutos");

                    if (Relatorio.getLavadora().getmeta() != null) {
                        System.out.println("meta: " + Relatorio.getLavadora().getmeta());
                        if (Relatorio.getLavadora().isAprovado()) {
                            System.out.println("Estado: Aprovado por Meta. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } 
                    break;
                case 2:
                    
                        System.out.println("Linha de Produção: Enchedora");
                        System.out.println("Quantidade Boa:" +Constantes.QuantBoa1 + " unidade" );
                        System.out.println("Quantidade Refugo:" +Constantes.QuantRefugo1+" unidade" );
                        System.out.println("Tempo Parado:" +Constantes.TempoParado1 +" minutos");
                        System.out.println("Tempo Produtivo:" +Constantes.TempoProdutivo1 +" minutos");
                    
                    if (Relatorio.getEnchedora().getmeta() != null) {
                        System.out.println("meta: " + Relatorio.getEnchedora().getmeta());
                        if (Relatorio.getEnchedora().isAprovado()) {
                            System.out.println("Estado: Aprovado por Meta. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Meta disponível apenas com as 3 Quantidades. ");
                    }
                    break;
                case 3:
                                        
                        System.out.println("Linha de Produção: Rotuladora");
                        System.out.println("Quantidade Boa:" +Constantes.QuantBoa2 + " unidade" );
                        System.out.println("Quantidade Refugo:" +Constantes.QuantRefugo2+" unidade" );
                        System.out.println("Tempo Parado:" +Constantes.TempoParado2 +" minutos");
                        System.out.println("Tempo Produtivo:" +Constantes.TempoProdutivo2 +" minutos");
                                        
                    if (Relatorio.getRotuladora().getmeta() != null) {
                        System.out.println("meta: " + Relatorio.getRotuladora().getmeta());
                        if (Relatorio.getRotuladora().isAprovado()) {
                            System.out.println("Estado: Aprovado por Meta. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Meta disponível apenas com as 3 Quantidades. ");
                    }
                    break;
                case 4:
                    
                    System.out.println("Linha de Produção: Empacotadora");
                    System.out.println("Quantidade Boa:" +Constantes.QuantBoa3 + " unidade" );
                    System.out.println("Quantidade Refugo:" +Constantes.QuantRefugo3+" unidade" );
                    System.out.println("Tempo Parado:" +Constantes.TempoParado3 +" minutos");
                    System.out.println("Tempo Produtivo:" +Constantes.TempoProdutivo3 +" minutos");
                    
                    if (Relatorio.getEmpacotadora().getmeta() != null) {
                        System.out.println("meta: " + Relatorio.getEmpacotadora().getmeta());
                        if (Relatorio.getEmpacotadora().isAprovado()) {
                            System.out.println("Estado: Aprovado por Meta. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Meta disponível apenas com as 3 Quantidades. ");
                    }
                    break;
                case 5:
                    
                    System.out.println("Linha de Produção: Paletizadora");
                    System.out.println("Quantidade Boa:" +Constantes.QuantBoa4 + " unidade" );
                    System.out.println("Quantidade Refugo:" +Constantes.QuantRefugo4+" unidade" );
                    System.out.println("Tempo Parado:" +Constantes.TempoParado4 +" minutos");
                    System.out.println("Tempo Produtivo:" +Constantes.TempoProdutivo4+" minutos");

                    if (Relatorio.getPaletizadora().getmeta() != null) {
                        System.out.println("meta: " + Relatorio.getPaletizadora().getmeta());
                        if (Relatorio.getPaletizadora().isAprovado()) {
                            System.out.println("Estado: Aprovado por Meta. ");
                        } else {
                            System.out.println("Estado: Reprovado. ");
                        }
                    } else {
                        System.out.println("Meta disponível apenas com as 3 Quantidades. ");
                    }
                    break;
                default:
                    System.out.println("cadastre uma matéria válida!");
                    break;
            }
        } catch (OperadorException e) {
            System.out.println(e.getMessage());

        }
    }
}
