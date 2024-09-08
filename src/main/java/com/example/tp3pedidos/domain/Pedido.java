package com.example.tp3pedidos.domain;

import com.example.tp3pedidos.commands.CriarPedidoCommand;
import com.example.tp3pedidos.domain.Estado;
import com.example.tp3pedidos.events.PedidoCriado;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Entity
public class Pedido {

    @AggregateIdentifier
    @Id
    private String id;
    private String descricao;
    private double valor;
    private String estado;

    public Pedido() {
    }

    //--------------------------------------------------------------------------
    @CommandHandler
    public Pedido(CriarPedidoCommand comando) {
        AggregateLifecycle.apply(new PedidoCriado(comando.id, comando.descricao, comando.valor));
    }

    @EventSourcingHandler
    protected void on(PedidoCriado evento) {
        this.id = evento.id;
        this.descricao = evento.descricao;
        this.valor = evento.valor;
        this.estado = Estado.CRIADO.name();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
