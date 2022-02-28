package org.senai.devinhouse.m1s09.repository;

import org.senai.devinhouse.m1s09.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository implements CrudRepository<Cliente>{

    private final List<Cliente> lista = new ArrayList<>();

    @Override
    public List<Cliente> findAll() {
        return lista;
    }

    @Override
    public Cliente findById(int id) {
        return lista.get(id);
    }

    @Override
    public int add(Cliente cliente) {
        this.lista.add(cliente);
        return this.lista.indexOf(cliente);
    }

    @Override
    public Cliente update(int id, Cliente cliente) {
        return this.lista.set(id, cliente);
    }

    @Override
    public Cliente delete(int id) {
        return this.lista.remove(id);
    }
}
