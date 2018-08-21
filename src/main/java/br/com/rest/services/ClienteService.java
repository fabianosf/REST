package br.com.rest.services;

import java.util.List;

import br.com.rest.models.Cliente;

public interface ClienteService {
    
    Cliente create(final Cliente cliente);
    Cliente findById(final String clienteId);
    List<Cliente> findAll();
    Cliente update(Cliente cliente);
    void delete(final String clienteId);

}
