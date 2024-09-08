package com.example.tp3pedidos.services;

import com.example.tp3pedidos.domain.Pedido;
import java.util.List;
import java.util.Optional;

public interface QueryService {
    Optional<Pedido> obterPorId(String id);
    List<Object> listarEventos(String id);
}
