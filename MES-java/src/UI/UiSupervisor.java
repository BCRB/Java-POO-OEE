package UI;

import Controlador.Fachada;
import Modelo.Operador;
import Modelo.Op;
import Excecoes.SupervisorException;


import java.util.Scanner;

class UiSupervisor {

    private Scanner s = new Scanner(System.in);

    void MenuSupervisor() {

        int menu;
        do {
            System.out.println(
                    "\n1: Para cadastrar ORDEM DE PRODUÇÃO. \n2: Para deletar ORDEM DE PRODUÇÃO. " +
                    "\n3: Pesquisar OPERADOR pelo codigo. \n4: Remover ORDEM DE PRODUÇÃO pelo prazo. " +
                    "\n5: Substituir ORDEM DE PRODUÇÃO."+"\n0: Para SAIR.");
            menu = s.nextInt();

            switch (menu) {
                
                case 1:
                    MandarOp();
                    break;

                case 2:
                    RemoverOpC();
                    break;
                case 3:
                    PesquisarOperadorCodigo();
                    break;
                case 4:
                    RemoverOpP();
                    break;
                case 5:
                    TrocarOp();
                    break;                
                case 0:
                    break;              
                default:
                    System.out.println("Digite uma opção válida: ");
                    break;
            }
        } while (menu != 0);
       
    }

        Op CriarOp() {
        Op Op = new Op();
        System.out.println("Digite o codigo que da ORDEM DE PRODUÇÃO: ");
        Op.setCodigo(s.next());

        System.out.println("Digite a Quantidade a ser produzida: ");
        Op.setConteudo(s.next());

        System.out.println("Digite o prazo da ORDEM DE PRODUÇÃO (em dias): ");
        Op.setPrazo(s.nextInt());


        return Op;
    }

    private void TrocarOp() {
        try {
            Op Op = CriarOp();
            Fachada.getInstancia().substituirT(Op);
            System.out.println("ORDEM DE PRODUÇÃO substituido com sucesso. \n");
        } catch (SupervisorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverOpC() {
        String codigo;
        System.out.println("Digite o codigo da ORDEM DE PRODUÇÃO para ser deletada: ");
        codigo = s.next();

        try {
            Fachada.getInstancia().removerOp(codigo);
            System.out.println("ORDEM DE PRODUÇÃO deletada com sucesso. \n");
        } catch (SupervisorException e) {
            System.out.println(e.getMessage());
        }

    }

    private void RemoverOpP() {
        int prazo;
        System.out.println("Digite o prazo das ORDEM DE PRODUÇÃO que devem ser deletadas: ");
        prazo = s.nextInt();

        try {
            Fachada.getInstancia().removerOp(prazo);
            System.out.println("ORDEM DE PRODUÇÃO deletada com sucesso. \n ");
        } catch (SupervisorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void MandarOp() {

        Op Op = CriarOp();
        try {
            Fachada.getInstancia().mandarOp(Op);
            System.out.println("ORDEM DE PRODUÇÃO cadastrada com sucesso. \n");
        } catch (SupervisorException e) {
            System.out.println(e.getMessage());
        }


    }

    private void PesquisarOperadorCodigo() {
        try {
            System.out.println("cadastre o código: ");
            Operador t;
            t = Fachada.getInstancia().pesquisarOperadorCodigo(s.next());
            System.out.println("Nome: " + t.getNome());
            System.out.println("Idade: " + t.getIdade());
            System.out.println("Sexo: " + t.getSexo());
            System.out.println("Serie: " + t.getSerie() + "\n");
        } catch (SupervisorException e) {
            System.out.println(e.getMessage());
        }
    }
}
