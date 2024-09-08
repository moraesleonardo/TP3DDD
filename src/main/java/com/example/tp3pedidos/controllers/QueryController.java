package com.example.tp3pedidos.controllers;

import com.example.tp3pedidos.services.QueryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/queries")
public class QueryController {

    private final QueryService service;

    @Autowired
    public QueryController(QueryService service) {
        this.service = service;
    }

    @GetMapping("/{id}/eventos")
    public List<Object> listarEventos(@PathVariable(value = "id") String id) {
        return service.listarEventos(id);
    }
}


