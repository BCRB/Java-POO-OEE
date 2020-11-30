package UI;

import Controlador.Fachada;
import Modelo.Operador;
import Modelo.Endereco;
import Modelo.Supervisor;
import Excecoes.GerenteException;

import java.util.Scanner;

class UiGerente {
    private static Scanner s = new Scanner(System.in);

    void MenuGerente() {
        int menu;
        do {
            System.out.println("Digite: \n1: Para cadastrar Operador. \n2: Para remover Operador pelo código. " +
                    "\n3: Para Pesquisar Operador pelo código e cpf." +
                    " \n4: Para cadastrar Supervisor. \n5: Para pesquisar Supervisores pelo codigo e cpf. \n6: " +
                    "Para remover Supervisor pelo codigo." +
                    "\n7: Trocar Supervisor.\n8: Remover endereço de um Operador.\n9" +
                    ": Remover endereço de um Supervisor.\n10: Alterar endereço de um Supervisor.\n11:" +
                    " Alterar endereço de um Operador.\n12: cadastrar endereço de um Operador.\n13: cadastrar endereço de um Supervisor.\n0: SAIR. ");
            menu = s.nextInt();

            switch (menu) {
                case 1:
                    cadastrarOperador();
                    break;
                case 2:
                    RemoverOperadorCodigo();
                    break;
                case 3:
                    PesquisarOperadorCodigo();
                    break;
                case 4:
                    cadastrarSupervisor();
                    break;
                case 5:
                    PesquisarSupervisorCodigo();
                    break;
                case 6:
                    RemoverSupervisorCodigo();
                    break;                
                case 7:
                    TrocarSupervisor();
                    break;
                case 8:
                    RemoverEnderecoOperador();
                    break;
                case 9:
                    RemoverEnderecoSupervisor();
                    break;
                case 10:
                    TrocarEndP();
                    break;
                case 11:
                    TrocarEndA();
                    break;
                case 12:
                    cadastrarEnderecoOperador();
                    break;
                case 13:
                    cadastrarEnderecoSupervisor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Digite uma opção válida:  ");
                    break;
            }
        } while (menu != 0);
    }

    private void TrocarEndA() {
        try {
            System.out.println("Digite o codigo do Operador que voce deseja trocar o endereço.");
            String codigo = s.next();
            Endereco end = new Endereco();
            System.out.println("Digite o nome do bairro: ");
            end.setBairro(s.next());
            System.out.println("Digite o nome da rua: ");
            end.setRua(s.next());
            System.out.println("Digite o número");
            end.setNumero(s.next());
            System.out.println("Digite o complemento");
            end.setComplemento(s.next());
            System.out.println("cadastre o CEP");
            end.setCep(s.next());

            Fachada.getInstancia().trocarEnderecoA(codigo, end);
            System.out.println("Endereço alterado com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void TrocarEndP() {
        try {
            System.out.println("Digite o codigo do Supervisor que voce deseja trocar o endereço.");
            String codigo = s.next();
            Endereco end = new Endereco();
            System.out.println("Digite o nome do bairro: ");
            end.setBairro(s.next());
            System.out.println("Digite o nome da rua: ");
            end.setRua(s.next());
            System.out.println("Digite o número");
            end.setNumero(s.next());
            System.out.println("Digite o complemento");
            end.setComplemento(s.next());
            System.out.println("cadastre o CEP");
            end.setCep(s.next());

            Fachada.getInstancia().trocarEnderecoP(codigo, end);
            System.out.println("Endereço alterado com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverEnderecoOperador() {
        try {
            System.out.println("Digite o codigo do Operador no qual deseja remover o endereço: ");
            String codigo = s.next();

            Fachada.getInstancia().removerEnderecoA(codigo);
            System.out.println("Endereço removido com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverEnderecoSupervisor() {
        try {
            System.out.println("Digite o codigo do Supervisor no qual deseja remover o endereço: ");
            String codigo = s.next();
            Fachada.getInstancia().removerEnderecoP(codigo);
            System.out.println("Endereço removido com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void TrocarSupervisor() {
        try {

            System.out.println("Digite o codigo do Supervisor para que ele seja substituído: ");
            String codigo = s.next();

            Supervisor novoSupervisor = new Supervisor();
            Endereco end = new Endereco();
            System.out.println("Digite as informações do Supervisor que irá substituir. \n");

            System.out.println("Digite o nome: ");
            novoSupervisor.setNome(s.next());

            System.out.println("Digite a idade: ");
            novoSupervisor.setIdade(s.nextInt());

            System.out.println("Digite o sexo: ");
            novoSupervisor.setSexo(s.next());

            System.out.println("Digite o cpf: ");
            novoSupervisor.setCpf(s.next());
           
            System.out.println("Digite o codigo do Gerente: ");
            novoSupervisor.setCodigo(s.next());

            System.out.println("Endereço: \n");

            System.out.println("Digite a rua: ");
            end.setRua(s.next());

            System.out.println("Digite o bairro: ");
            end.setBairro(s.next());

            System.out.println("Digite o número: ");
            end.setNumero(s.next());

            System.out.println("Digite o CEP: ");
            end.setCep(s.next());

            System.out.println("Digite o complemento: ");
            end.setComplemento(s.next());

            novoSupervisor.setEndereco(end);


            Fachada.getInstancia().trocarSupervisor(codigo, novoSupervisor);
            System.out.println("Supervisor substituído com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverSupervisorCodigo() {
        String codigo;
        System.out.println("Digite o código do Supervisor para ser removido: ");
        codigo = s.next();

        try {
            Fachada.getInstancia().removerSupervisorCodigo(codigo);
            System.out.println("Supervisor removido com sucesso. \n ");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());

        }
    }

    private void PesquisarSupervisorCodigo() {
        try {
            System.out.println("cadastre o código do Supervisor: ");
            String codigo = s.next();
            System.out.println("cadastre o cpf do Supervisor: ");
            String cpf = s.next();
            Supervisor p;
            p = Fachada.getInstancia().pesquisarSupervisorCodigo(codigo, cpf);
            System.out.println(p.getCodigo());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Idade: " + p.getIdade());
            System.out.println("Sexo: " + p.getSexo());
            System.out.println("Maquina de ensino: " + p.getMaquina());
            System.out.println("Salário : " + p.getSalario());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("Carga horária: " + p.getCargaH() + "\n");
            System.out.println("Endereço: " + "\n");
            if (p.getEndereco() != null) {
                System.out.println("Rua: " + p.getEndereco().getRua());
                System.out.println("Bairro: " + p.getEndereco().getBairro());
                System.out.println("Numero: " + p.getEndereco().getNumero());
                System.out.println("Complemento: " + p.getEndereco().getComplemento());
                System.out.println("Cep: " + p.getEndereco().getCep() + "\n");
            } else {
                System.out.println("Endereço não cadastrado. \n");
            }
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverOperadorCodigo() {
        String codigo;
        System.out.println("Digite o código do Operador para ser removido: ");
        codigo = s.next();
        try {
            Fachada.getInstancia().removerOperadorCodigo(codigo);
            System.out.println("Operador removido com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cadastrarOperador() {
        Operador a = new Operador();
        Endereco end = new Endereco();
        System.out.println("Digite o nome do Operador: ");
        a.setNome(s.next());

        System.out.println("Digite a idade do Operador: ");
        a.setIdade(s.nextInt());

        System.out.println("Digite o gênero do Operador: ");
        a.setSexo(s.next());

        System.out.println("Digite o CPF do Operador: ");
        a.setCpf(s.next());
        
        System.out.println("Digite o código que o Operador usará: ");
        a.setCodigo(s.next());

        System.out.println("Digite o nome do bairro: ");
        end.setBairro(s.next());
        System.out.println("Digite o nome da rua: ");
        end.setRua(s.next());
        System.out.println("Digite o número");
        end.setNumero(s.next());
        System.out.println("Digite o complemento");
        end.setComplemento(s.next());
        System.out.println("cadastre o CEP");
        end.setCep(s.next());

        a.setEndereco(end);

        try {
            Fachada.getInstancia().cadastrarOperador(a);
            System.out.println("Operador inserido com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cadastrarSupervisor() {
        try {

            Supervisor p = new Supervisor();
            Endereco end = new Endereco();
            System.out.println("Digite o nome do Supervisor: ");
            p.setNome(s.next());

            System.out.println("Digite o sexo: ");
            p.setSexo(s.next());

            System.out.println("Digite a idade: ");
            p.setIdade(s.nextInt());

            System.out.println("Digite o CPF: ");
            p.setCpf(s.next());

            System.out.println("Digite o código que o Supervisor utilizará: ");
            p.setCodigo(s.next());

            System.out.println("Digite o nome do bairro: ");
            end.setBairro(s.next());
            System.out.println("Digite o nome da rua: ");
            end.setRua(s.next());
            System.out.println("Digite o número: ");
            end.setNumero(s.next());
            System.out.println("Digite o complemento: ");
            end.setComplemento(s.next());
            System.out.println("cadastre o CEP: ");
            end.setCep(s.next());

            p.setEndereco(end);

            Fachada.getInstancia().cadastrarSupervisor(p);
            System.out.println("Supervisor inserido com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }


    }

    private void PesquisarOperadorCodigo() {
        try {
            System.out.println("cadastre o código: ");
            String codigo = s.next();
            System.out.println("cadastre o cpf: ");
            Operador a;
            a = Fachada.getInstancia().pesquisarOperadorCodigo(codigo, s.next());
            System.out.println("Codigo: " + a.getCodigo());
            System.out.println("Nome: " + a.getNome());
            System.out.println("Idade: " + a.getIdade());
            System.out.println("Sexo: " + a.getSexo());
            System.out.println("CPF: " + a.getCpf() + "\n");
            System.out.println("Endereço: " + "\n");
            if (a.getEndereco() != null) {
                System.out.println("Rua: " + a.getEndereco().getRua());
                System.out.println("Bairro: " + a.getEndereco().getBairro());
                System.out.println("Numero: " + a.getEndereco().getNumero());
                System.out.println("Complemento: " + a.getEndereco().getComplemento());
                System.out.println("Cep: " + a.getEndereco().getCep() + "\n");
            } else {
                System.out.println("Endereço não cadastrado. \n");
            }
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

      private void cadastrarEnderecoSupervisor() {
        try {
            System.out.println("Digite o codigo do Supervisor que voce deseja cadastrar o endereço.");
            String codigo = s.next();
            Endereco end = new Endereco();

            System.out.println("Digite o novo endereço: \n");

            System.out.println("Digite o nome do bairro: ");
            end.setBairro(s.next());
            System.out.println("Digite o nome da rua: ");
            end.setRua(s.next());
            System.out.println("Digite o número");
            end.setNumero(s.next());
            System.out.println("Digite o complemento");
            end.setComplemento(s.next());
            System.out.println("cadastre o CEP");
            end.setCep(s.next());

            Fachada.getInstancia().cadastrarEnderecoSupervisor(end, codigo);
            System.out.println("Endereço inserido com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cadastrarEnderecoOperador() {
        try {
            System.out.println("Digite o codigo do Operador que voce deseja cadastrar o endereço.");
            String codigo = s.next();
            Endereco end = new Endereco();

            System.out.println("Digite o novo endereço: \n");

            System.out.println("Digite o nome do bairro: ");
            end.setBairro(s.next());
            System.out.println("Digite o nome da rua: ");
            end.setRua(s.next());
            System.out.println("Digite o número");
            end.setNumero(s.next());
            System.out.println("Digite o complemento");
            end.setComplemento(s.next());
            System.out.println("cadastre o CEP");
            end.setCep(s.next());

            Fachada.getInstancia().cadastrarEnderecoOperador(end, codigo);
            System.out.println("Endereço inserido com sucesso. \n");
        } catch (GerenteException e) {
            System.out.println(e.getMessage());
        }
    }
}
