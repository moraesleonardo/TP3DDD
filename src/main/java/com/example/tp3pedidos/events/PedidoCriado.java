package com.example.tp3pedidos.events;

public class PedidoCriado extends BaseEvent<String> {

    public final String descricao;
    public final double valor;

    public PedidoCriado(String id, String descricao, double valor) {
        super(id);
        this.descricao = descricao;
        this.valor = valor;
    }
}