package com.example.tp3pedidos.events;

public class BaseEvent<T> {

    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
