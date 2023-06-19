package br.com.t3tech.model;

import br.com.t3tech.servicos.ServicoDeBeleza;

public class Manicure extends Funcionario implements ServicoDeBeleza {



    public Manicure() {
    }

    public Manicure(String nome, String cpf, String telefone, double salario) {
        super(nome, cpf, telefone,  salario);
    }

    @Override
    public double getComissao(double valorServico) {
        return valorServico * 0.63;
    }
}
