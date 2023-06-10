package br.com.t3tech.model;

import br.com.t3tech.servicos.ServicoDeBeleza;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.*;

public class Agenda {


    ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();

    public void addAgendamento(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    public void removeAgendamento(Agendamento agendamento) {
        agendamentos.remove(agendamento);
    }

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
                System.out.println("Serviço:" + agendamento + "Valor a ser pago: " + funcionario.getComissao(agendamento.getValor()));
            }

        }
    }


}
