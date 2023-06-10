package br.com.t3tech.model;

import br.com.t3tech.servicos.ServicoDeBeleza;

public class Extensionista extends Funcionario implements ServicoDeBeleza {



    public Extensionista() {
    }

    public Extensionista(String nome, String cpf, String telefone, String cargo, double salario) {
        super(nome, cpf, telefone, cargo, salario);
    }

    @Override
    public double getComissao(double valorServico) {
        return valorServico * 0.75;
    }
}
