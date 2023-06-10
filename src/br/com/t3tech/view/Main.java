package br.com.t3tech.view;

import br.com.t3tech.model.*;
import br.com.t3tech.servicos.ServicoDeBeleza;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Agenda agenda = new Agenda();

        int opcao;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*****************************************");
            System.out.println("T3Tech - Sistema de Agendamento de Salão");
            System.out.println("*****************************************");
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar Manicure");
            System.out.println("2 - Cadastrar Depiladora");
            System.out.println("3 - Cadastrar  Extencionista de Cílios");
            System.out.println("4 - Listar Funcionarios");
            System.out.println("5 - Cadastrar Agendamento");
            System.out.println("6 - Listar Agendamentos");
            System.out.println("7 - Listar Agendamentos por Data");
            System.out.println("8 - Comissão do funcionario pelo serviço: ");

            System.out.println("9 - Sair");
            opcao = scanner.nextInt();


            switch (opcao) {
                case 1:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Digite o nome da Manicure");
                    String nomeManicure = scanner1.nextLine();
                    System.out.println("Digite o cpf da Manicure");
                    String cpfManicure = scanner1.nextLine();
                    System.out.println("Digite o telefone da Manicure");
                    String telefoneManicure = scanner1.nextLine();
                    System.out.println("Digite o cargo da Manicure");
                    String cargoManicure = scanner1.nextLine();
                    System.out.println("Digite o salario da Manicure");
                    double salarioManicure = scanner1.nextDouble();
                    Manicure manicure = new Manicure(nomeManicure, cpfManicure, telefoneManicure, cargoManicure, salarioManicure);
                    funcionarios.add(manicure);

                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Digite o nome da Depiladora");
                    String nomeDepiladora = scanner2.nextLine();
                    System.out.println("Digite o cpf da Depiladora");
                    String cpfDepiladora = scanner2.nextLine();
                    System.out.println("Digite o telefone da Depiladora");
                    String telefoneDepiladora = scanner2.nextLine();
                    System.out.println("Digite o cargo da Depiladora");
                    String cargoDepiladora = scanner2.nextLine();
                    System.out.println("Digite o salario da Depiladora");
                    double salarioDepiladora = scanner2.nextDouble();
                    Depiladora depiladora = new Depiladora(nomeDepiladora, cpfDepiladora, telefoneDepiladora, cargoDepiladora, salarioDepiladora);
                    funcionarios.add(depiladora);
                    break;


                case 3:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Digite o nome da Extensionista");
                    String nomeExtensionista = scanner3.nextLine();
                    System.out.println("Digite o cpf da Extensionista");
                    String cpf = scanner3.nextLine();
                    System.out.println("Digite o telefone da Extensionista");
                    String telefoneExtensionista = scanner3.nextLine();
                    System.out.println("Digite o cargo da Extensionista");
                    String cargoExtensionista = scanner3.nextLine();
                    System.out.println("Digite o salario da Extensionista");
                    double salarioExtensionista = scanner3.nextDouble();
                    Extensionista extensionista = new Extensionista(nomeExtensionista, cpf, telefoneExtensionista, cargoExtensionista, salarioExtensionista);
                    funcionarios.add(extensionista);
                    break;


                case 4:
                    for (Funcionario funcionario : funcionarios) {
                        System.out.println(funcionario);
                    }
                    break;

                case 5:
                    Scanner scanner5 = new Scanner(System.in);

                    System.out.println("Digite o nome do cliente");
                    String nomeCliente = scanner5.nextLine();

                    System.out.println("Digite a data");
                    String data = scanner5.nextLine();


                    System.out.println("Digite o nome do funcionario que vai fazer o serviço");
                    String nomeFuncionario = scanner5.nextLine();
                    scanner5.reset();
                    System.out.println("Digite o valor do serviço");
                    double valorServico = scanner5.nextDouble();
                    scanner5.reset();

                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getNome().equals(nomeFuncionario)) {
                            if (funcionario instanceof Manicure manicureIstrue) {
                                Agendamento agendamento = new Agendamento(nomeCliente, data, manicureIstrue, valorServico);
                                agenda.addAgendamento(agendamento);
                            } else if (funcionario instanceof Depiladora depiladoraIstrue) {
                                Agendamento agendamento = new Agendamento(nomeCliente, data, depiladoraIstrue, valorServico);
                                agenda.addAgendamento(agendamento);
                            } else if (funcionario instanceof Extensionista extensionistaIstrue) {
                                Agendamento agendamento = new Agendamento(nomeCliente, data, extensionistaIstrue, valorServico);
                                agenda.addAgendamento(agendamento);
                            }
                        }

                    }
                    break;

                case 6:
                    agenda.listarAgendamentos();
                    break;


                case 7:
                    Scanner scanner6 = new Scanner(System.in);
                    System.out.println("Digite a data");
                    String dataAgendamento = scanner6.nextLine();
                    agenda.listarAgendamentosPorData(dataAgendamento);
                    break;

                case 8:
                    Scanner scanner7 = new Scanner(System.in);
                    System.out.println("Digite o nome do funcionario: ");
                    String nome = scanner7.nextLine();
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getNome().equals(nome)) {
                            ServicoDeBeleza funcinarioDeBeleza = (ServicoDeBeleza) funcionario;
                            agenda.comissaoPorServico(funcinarioDeBeleza);
                        }
                    }


                case 9:
                    System.out.println("Saindo do sistema...");
            }


        } while (opcao != 9);


    }
}
