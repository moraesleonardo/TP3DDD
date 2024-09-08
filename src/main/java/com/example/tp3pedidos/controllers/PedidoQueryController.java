package com.example.tp3pedidos.controllers;

import com.example.tp3pedidos.domain.Pedido;
import com.example.tp3pedidos.services.PedidoQueryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoQueryController {

    private final PedidoQueryService service;

    @Autowired
    public PedidoQueryController(@Qualifier("pedidoQueryServiceImpl") PedidoQueryService service) { // Usa Qualifier para especificar a implementação
        this.service = service;
    }

    @GetMapping("/{id}/eventos")
    public List<Object> listarEventos(@PathVariable(value = "id") String id) {
        return service.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Pedido obterPorId(@PathVariable(value = "id") String id) {
        Optional<Pedido> pedido = service.obterPorId(id);
        return pedido.orElse(null);
    }
}
