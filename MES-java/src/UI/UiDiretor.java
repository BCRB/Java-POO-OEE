package UI;


import Controlador.Fachada;
import Modelo.Gerente;
import Modelo.Endereco;
import Excecoes.DiretorException;

import java.util.Scanner;

public class UiDiretor {

    static Scanner s = new Scanner(System.in);

    void MenuDiretor() {
        int opcao;

        do {
            System.out.println("Digite: \n1: Para cadastrar Gerente. \n2: Para Remover Gerente. " +
                    "\n3: Para pesquisar Gerente. \n4: Para Substituir Gerente." +
                    "\n5: Remover endereço de um Gerente. \n6: Alterar endereço do Gerente. " +
                    "\n9: cadastrar o endereço de um Gerente.  \n0: Para sair.");
            opcao = s.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarGerente();
                    break;
                case 2:
                    RemoverGerenteCodigo();
                    break;
                case 3:
                    PesquisarGerenteCodigo();
                    break;
                case 4:
                    SubstituirGerente();
                    break;
                case 5:
                    RemoverEnderecoGerente();
                    break;
                case 6:
                    TrocarEndD();
                    break;              
                case 7:
                    cadastrarEnderecoGerente();
                    break;
                case 0:                                  
                    break;
                default:
                    System.out.println("Digite uma opção valida.");
                    break;
            }
        } while (opcao != 0);
    }

        private void TrocarEndD() {
        try {
            System.out.println("Digite o codigo do Gerente que voce deseja trocar o endereço.");
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

            Fachada.getInstancia().trocarEndD(codigo, end);
            System.out.println("Endereço atualizado com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }

    }

    private void PesquisarGerenteCodigo() {
        try {
            System.out.println("cadastre o código do Gerente: ");
            String codigo = s.next();
            System.out.println("cadastre o cpf do Gerente: ");
            String cpf = s.next();
            Gerente d;
            d = Fachada.getInstancia().pesquisarGerenteCodigo(codigo, cpf);
            System.out.println("Nome: " + d.getNome());
            System.out.println("Idade: " + d.getIdade());
            System.out.println("Sexo: " + d.getSexo());
            System.out.println("Salário : " + d.getSalario());
            System.out.println("CPF: " + d.getCpf());
            System.out.println("Carga horária: " + d.getCargaH() + "\n");
            System.out.println("Endereço: " + "\n");
            if (d.getEndereco() != null) {
                System.out.println("Rua: " + d.getEndereco().getRua());
                System.out.println("Bairro: " + d.getEndereco().getBairro());
                System.out.println("Numero: " + d.getEndereco().getNumero());
                System.out.println("Complemento: " + d.getEndereco().getComplemento());
                System.out.println("Cep: " + d.getEndereco().getCep() + "\n");
            } else {
                System.out.println("Endereço não cadastrado. \n");
            }

        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cadastrarEnderecoGerente() {
        try {
            System.out.println("Digite o codigo do Gerente que voce deseja cadastrar o endereço.");
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

            Fachada.getInstancia().cadastrarEnderecoGerente(end, codigo);
            System.out.println("Enderço inserido com sucesso. \n");

        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverEnderecoGerente() {
        try {
            System.out.println("Digite o codigo do Gerente no qual deseja remover o endereço: ");
            String codigo = s.next();
            Fachada.getInstancia().removerEnderecoD(codigo);
            System.out.println("Endereço removido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void SubstituirGerente() {
        try {

            System.out.println("Digite o codigo do Gerente para que ele seja substituído: ");
            String codigo = s.next();

            Gerente novoGerente = new Gerente();
            Endereco end = new Endereco();
            System.out.println("Digite as informações do novo Gerente. \n");

            System.out.println("Digite o nome: ");
            novoGerente.setNome(s.next());

            System.out.println("Digite a idade: ");
            novoGerente.setIdade(s.nextInt());

            System.out.println("Digite o sexo: ");
            novoGerente.setSexo(s.next());

            System.out.println("Digite o cpf: ");
            novoGerente.setCpf(s.next());
            
            System.out.println("Digite o codigo do Gerente:");
            novoGerente.setCodigo(s.next());

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

            novoGerente.setEndereco(end);


            Fachada.getInstancia().substituirGerente(codigo, novoGerente);
            System.out.println("Gerente substituído com sucesso. \n ");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }

    private void RemoverGerenteCodigo() {
        String codigo;
        System.out.println("Digite o código do Gerente para ser removido: ");
        codigo = s.next();
        try {
            Fachada.getInstancia().removerGerenteCodigo(codigo);
            System.out.println("Gerente removido com sucesso. \n");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }
    }


    Gerente cadastrarGerente() {
        Gerente Gerente = new Gerente();
        Endereco end = new Endereco();
        try {

            System.out.println("Digite o nome: ");
            Gerente.setNome(s.next());

            System.out.println("Digite a idade: ");
            Gerente.setIdade(s.nextInt());

            System.out.println("Digite o sexo: ");
            Gerente.setSexo(s.next());

            System.out.println("Digite o cpf: ");
            Gerente.setCpf(s.next());
           
            System.out.println("Digite o codigo do Gerente: ");
            Gerente.setCodigo(s.next());

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

            Gerente.setEndereco(end);


            Fachada.getInstancia().cadastrarGerente(Gerente);
            System.out.println("Gerente inserido com sucesso. \n ");
        } catch (DiretorException e) {
            System.out.println(e.getMessage());
        }

        return Gerente;
    }
}
