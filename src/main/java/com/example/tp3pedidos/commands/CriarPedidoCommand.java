package com.example.tp3pedidos.commands;

public class CriarPedidoCommand extends BaseCommand<String> {

    public final String descricao;
    public final double valor;

    public CriarPedidoCommand(String id, String descricao, double valor) {
        super(id);
        this.descricao = descricao;
        this.valor = valor;
    }
}
