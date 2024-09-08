package com.example.tp3pedidos.services;


import com.example.tp3pedidos.domain.Pedido;
import com.example.tp3pedidos.infra.PedidoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoQueryServiceImpl implements PedidoQueryService {

    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoQueryServiceImpl(EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Object> listarEventos(String id) {
        return eventStore.readEvents(id)
                .asStream()
                .map(record -> record.getPayload())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPorId(String id) {
        return pedidoRepository.findById(id);
    }
}
