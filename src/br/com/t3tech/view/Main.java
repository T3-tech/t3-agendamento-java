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
            System.out.println();
            System.out.println("*****************************************");
            System.out.println("T3Tech - Sistema de Agendamento de Salão");
            System.out.println("*****************************************");
            System.out.println();
            System.out.println("1 - Cadastrar Manicure");
            System.out.println("2 - Cadastrar Depiladora");
            System.out.println("3 - Cadastrar  Extencionista de Cílios");
            System.out.println("4 - Listar Funcionarios");
            System.out.println("5 - Cadastrar Agendamento");
            System.out.println("6 - Listar Agendamentos");
            System.out.println("7 - Listar Agendamentos por Data");
            System.out.println("8 - Comissão do funcionario pelo serviço: ");
            System.out.println("9 - Deletar Agendamento");
            System.out.println("10 - Deletar funcionario por CPF");
            System.out.println("11 - Editar Funcionario");
            System.out.println("12 - Editar Agendamento");
            System.out.println("13 - Sair");
            System.out.println();
            System.out.print("Digite a opção desejada: ");


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
                    System.out.println("Digite o salario da Manicure");
                    double salarioManicure = scanner1.nextDouble();
                    Manicure manicure = new Manicure(nomeManicure, cpfManicure, telefoneManicure, salarioManicure);

                    try {
                        for (Funcionario funcionario : funcionarios) {
                            if (funcionario.getCpf().equals(manicure.getCpf())) {
                                throw new IllegalArgumentException("Já existe um funcionario com este CPF!");
                            }
                        }
                        funcionarios.add(manicure);
                        System.out.println("Funcionario cadastrado com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Digite o nome da Depiladora");
                    String nomeDepiladora = scanner2.nextLine();
                    System.out.println("Digite o cpf da Depiladora");
                    String cpfDepiladora = scanner2.nextLine();
                    System.out.println("Digite o telefone da Depiladora");
                    String telefoneDepiladora = scanner2.nextLine();
                    scanner2.nextLine();
                    System.out.println("Digite o salario da Depiladora");
                    double salarioDepiladora = scanner2.nextDouble();
                    Depiladora depiladora = new Depiladora(nomeDepiladora, cpfDepiladora, telefoneDepiladora, salarioDepiladora);

                    try {
                        for (Funcionario funcionario : funcionarios) {
                            if (funcionario.getCpf().equals(depiladora.getCpf())) {
                                throw new IllegalArgumentException("Já existe um funcionario com este CPF!");
                            }
                        }
                        funcionarios.add(depiladora);
                        System.out.println("Funcionario cadastrado com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;


                case 3:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Digite o nome da Extensionista");
                    String nomeExtensionista = scanner3.nextLine();
                    System.out.println("Digite o cpf da Extensionista");
                    String cpf = scanner3.nextLine();
                    System.out.println("Digite o telefone da Extensionista");
                    String telefoneExtensionista = scanner3.nextLine();
                    System.out.println("Digite o salario da Extensionista");
                    double salarioExtensionista = scanner3.nextDouble();
                    Extensionista extensionista = new Extensionista(nomeExtensionista, cpf, telefoneExtensionista, salarioExtensionista);

                    try {
                        for (Funcionario funcionario : funcionarios) {
                            if (funcionario.getCpf().equals(extensionista.getCpf())) {
                                throw new IllegalArgumentException("Já existe um funcionario com este CPF!");
                            }
                        }
                        funcionarios.add(extensionista);
                        System.out.println("Funcionario cadastrado com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
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

                    System.out.println("-----------------------------------");
                    System.out.println("Funcionários");
                    for (int i = 0; i < funcionarios.size(); i++) {
                        System.out.print((i + 1) + ")" + funcionarios.get(i).getNome());
                        if (funcionarios.get(i) instanceof Depiladora) {
                            System.out.println(" - Depiladora");
                        } else if (funcionarios.get(i) instanceof Manicure) {
                            System.out.println(" - Manicure");
                        } else if (funcionarios.get(i) instanceof Extensionista) {
                            System.out.println(" - Extensionista");
                        }
                    }
                    System.out.println("-----------------------------------");


                    System.out.println("Digite o numero do funcionario que vai fazer o serviço");
                    int idFuncionario = scanner5.nextInt();

                    Funcionario achouFuncionario = funcionarios.get(idFuncionario - 1);

                    String nomeFuncionario = achouFuncionario.getNome();

                    scanner5.reset();
                    System.out.println("Digite o valor do serviço");
                    double valorServico = scanner5.nextDouble();
                    scanner5.reset();

                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getNome().equals(nomeFuncionario)) {
                            if (funcionario instanceof Manicure manicureIstrue) {
                                Agendamento agendamento = new Agendamento(data, nomeCliente, manicureIstrue, valorServico);
                                try {
                                    agenda.addAgendamento(agendamento);
                                    System.out.println("Agendamento realizado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (funcionario instanceof Depiladora depiladoraIstrue) {
                                Agendamento agendamento = new Agendamento(data, nomeCliente, depiladoraIstrue, valorServico);
                                try {
                                    agenda.addAgendamento(agendamento);
                                    System.out.println("Agendamento realizado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (funcionario instanceof Extensionista extensionistaIstrue) {
                                Agendamento agendamento = new Agendamento(data, nomeCliente, extensionistaIstrue, valorServico);
                                try {
                                    agenda.addAgendamento(agendamento);
                                    System.out.println("Agendamento realizado com sucesso!");
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
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
                    break;
                case 9:
                    agenda.deletarAgendamento();
                    break;

                case 10:
                    Scanner scanner9 = new Scanner(System.in);
                    System.out.println("Digite o CPF do funcionario: ");
                    String cpfFuncionarioParaApagar = scanner9.nextLine();
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getCpf().equals(cpfFuncionarioParaApagar)) {
                            int index = funcionarios.indexOf(funcionario);
                            funcionarios.remove(index);
                            System.out.println("Funcionario removido com sucesso!");
                            break;
                        }

                    }
                    break;

                case 11:
                    Scanner scanner10 = new Scanner(System.in);
                    System.out.println("Digite o CPF do funcionario: ");
                    String cpfFuncionarioParaAlterar = scanner10.nextLine();
                    for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getCpf().equals(cpfFuncionarioParaAlterar)) {
                            System.out.println("Digite o novo nome do funcionario: ");
                            String novoNome = scanner10.nextLine();
                            funcionario.setNome(novoNome);
                            System.out.println("Digite o novo telefone do funcionario: ");
                            String novoTelefone = scanner10.nextLine();
                            funcionario.setTelefone(novoTelefone);
                            System.out.println("Digite o novo salario do funcionario: ");
                            double novoSalario = scanner10.nextDouble();
                            funcionario.setSalario(novoSalario);
                            System.out.println("Funcionario alterado com sucesso!");
                            break;
                        }

                    }
                    break;
                case 12:
                    agenda.editarAgendamento();
                    break;


                case 13:
                    System.out.println("Saindo do sistema...");
                    break;
            }


        } while (opcao != 13);


    }
}
