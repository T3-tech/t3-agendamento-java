package br.com.t3tech.model;

import br.com.t3tech.servicos.ServicoDeBeleza;

public class Agendamento {
    private String data;
    private String nomeCliente;

    private ServicoDeBeleza servicoDeBeleza;

    private double valor;

    public Agendamento() {
    }

    public Agendamento(String data, String nome, ServicoDeBeleza servicoDeBeleza, double valor) {
        this.data = data;
        this.nomeCliente = nome;
        this.servicoDeBeleza = servicoDeBeleza;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nomeCliente;
    }

    public void setNome(String nome) {
        this.nomeCliente = nome;
    }

    public ServicoDeBeleza getServicoDeBeleza() {
        return servicoDeBeleza;
    }

    public void setServicoDeBeleza(ServicoDeBeleza servicoDeBeleza) {
        this.servicoDeBeleza = servicoDeBeleza;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "Agendamento: " + "\n" +
                " data: " + data + '\n' +
                " nome do cliente: " + nomeCliente + '\n' +
                " valor: " + valor + '\n' +
                " Profissional: " + servicoDeBeleza
                ;
    }
}
