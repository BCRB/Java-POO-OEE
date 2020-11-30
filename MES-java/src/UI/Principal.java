package UI;

import java.util.Scanner;

class Principal {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        
        int menu;

        do {
            System.out.println("Digite: \n1: Cockpit OPERADOR. " +
                    "\n2: Cockpit SUPERVISOR. \n3: Cockpit GERENTE \n4: Cockpit DIRETOR \n0: SAIR. ");
            menu = s.nextInt();

            switch (menu) {
                case 4: 
                    UiDiretor uiDiretor= new UiDiretor();
                    uiDiretor.MenuDiretor();
                case 1:
                    UiOperador uiOperador = new UiOperador();
                    uiOperador.MenuOperador();
                    break;

                case 2:
                    UiSupervisor uiSupervisor = new UiSupervisor();
                    uiSupervisor.MenuSupervisor();
                    break;
                case 3:
                    UiGerente uiGerente = new UiGerente();
                    uiGerente.MenuGerente();
                case 0:
                    System.out.println("Até a Proxima. ");
                    break;

                default:
                    System.out.println("cadastre uma opção válida. ");
            }
        } while (menu != 0);
    
    }


}
