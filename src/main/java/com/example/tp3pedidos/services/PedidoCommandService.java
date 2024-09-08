package com.example.tp3pedidos.services;

import com.example.tp3pedidos.domain.Pedido;
import java.util.concurrent.CompletableFuture;

public interface PedidoCommandService {
    CompletableFuture<String> criarPedido(Pedido pedido);
}
