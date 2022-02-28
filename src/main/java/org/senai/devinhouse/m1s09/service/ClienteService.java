package org.senai.devinhouse.m1s09.service;

import org.senai.devinhouse.m1s09.model.Cliente;
import org.senai.devinhouse.m1s09.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements CrudService<Cliente>{

    private CrudRepository<Cliente> clienteRepository;

    public ClienteService(CrudRepository<Cliente> clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> get() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(int id) {
        return clienteRepository.findById(id);
    }

    @Override
    public int save(Cliente cliente) {
        return clienteRepository.add(cliente);
    }

    @Override
    public Cliente update(int id, Cliente cliente) {
        return clienteRepository.update(id, cliente);
    }

    @Override
    public Cliente delete(int id) {
        return clienteRepository.delete(id);
    }
}
