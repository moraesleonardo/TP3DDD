package com.example.tp3pedidos.controllers;

import com.example.tp3pedidos.domain.Pedido;
import com.example.tp3pedidos.services.PedidoCommandService;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoCommandController {

    private final PedidoCommandService service;

    public PedidoCommandController(PedidoCommandService service) {
        this.service = service;
    }

    @PostMapping
    public CompletableFuture<String> criarPedido(@RequestBody Pedido pedido) {
        return service.criarPedido(pedido);
    }
}
