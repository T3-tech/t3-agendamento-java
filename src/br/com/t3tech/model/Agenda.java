package br.com.t3tech.model;

import br.com.t3tech.servicos.ServicoDeBeleza;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.*;

public class Agenda {


    ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();

    public void addAgendamento(Agendamento agendamento) {
        for (Agendamento agendamentoProcura : agendamentos) {
            if (agendamentoProcura.getData().equals(agendamento.getData()) && agendamentoProcura.getServicoDeBeleza().equals(agendamento.getServicoDeBeleza())) {
                throw new IllegalArgumentException("Já existe um agendamento para esta data com este serviço!");
            }
        }

        agendamentos.add(agendamento);
    }

//    public void removeAgendamento(Agendamento agendamento) {
//        agendamentos.remove(agendamento);
//    }

    public void listarAgendamentos() {
        for (Agendamento agendamento : agendamentos) {
            System.out.println(agendamento);
        }
    }

    public void listarAgendamentosPorData(String data) {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getData().equals(data)) {
                System.out.println(agendamento);
            }
        }
    }


    public void comissaoPorServico(ServicoDeBeleza funcionario) {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getServicoDeBeleza().equals(funcionario)) {
                System.out.println(agendamento + "\nValor a ser pago: " + funcionario.getComissao(agendamento.getValor()));
            }

        }
    }

//    public void ApagaAgendamentosPorData(String data) {
//
//        for (Agendamento agendamento : agendamentos) {
//            if (agendamento.getData().equals(data)) {
//                agendamentos.remove(agendamento);
//                System.out.println("Agendamento removido com sucesso!");
//                break;
//            }
//        }
//    }


    public void deletarAgendamento() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < agendamentos.size(); i++) {
            System.out.println((i + 1 )+" - " + agendamentos.get(i));
        }
        System.out.println("Digite o número do agendamento que deseja remover: ");
        int numero = scanner.nextInt();
        numero -= 1;
        agendamentos.remove(numero);
        System.out.println("Agendamento removido com sucesso!");
    }

    public void editarAgendamento() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < agendamentos.size(); i++) {
            System.out.println((i + 1) + " - " + agendamentos.get(i));
        }
        System.out.println("Digite o número do agendamento que deseja editar: ");
        int numero = scanner.nextInt();
        numero -= 1;
        System.out.println("Digite a nova data: ");
        String data = scanner.next();
        System.out.println("Digite o novo nome do cliente: ");
        String nome = scanner.next();
        System.out.println("Digite o novo valor: ");
        double valor = scanner.nextDouble();
        agendamentos.get(numero).setData(data);
        agendamentos.get(numero).setNome(nome);
        agendamentos.get(numero).setValor(valor);
        System.out.println("Agendamento editado com sucesso!");
    }
}
