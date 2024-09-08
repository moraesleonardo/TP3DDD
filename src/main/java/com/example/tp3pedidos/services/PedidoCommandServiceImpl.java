package com.example.tp3pedidos.services;

import com.example.tp3pedidos.commands.CriarPedidoCommand;
import com.example.tp3pedidos.domain.Pedido;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandServiceImpl implements PedidoCommandService {

    @Autowired
    private CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> criarPedido(Pedido pedido) {
        return commandGateway.send(new CriarPedidoCommand(
                UUID.randomUUID().toString(),
                pedido.getDescricao(),
                pedido.getValor()));
    }
}
