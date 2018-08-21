package br.com.rest.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import br.com.rest.models.Cliente;
import br.com.rest.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
    
  	private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
  
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Cliente create(Cliente cliente) {
    	logger.info("Criando um cliente");
        Cliente createdCliente = cliente;
        createdCliente.setId(counter.incrementAndGet());
  		return createdCliente;
    }

    @Override
    public Cliente findById(String clienteId) {
      	logger.info("Buscando cliente por ID");
        Cliente cliente = new Cliente();
        cliente.setId(Long.parseLong(clienteId));
        cliente.setNome ("Leandro");
        cliente.setSobrenome("Costa");
        cliente.setEndereco("Rua das Flores 4");
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
      	logger.info("buscando todos os clientes");
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Cliente cliente = mockCliente();
            clientes.add(cliente);
        }
        return clientes;
    }

    private Cliente mockCliente() {
    	long id = counter.incrementAndGet();
    	
        Cliente cliente = new Cliente();
		cliente.setId(id);
        cliente.setNome("Nome: " + id);
        cliente.setSobrenome("Sobrenome: " + id);
        cliente.setEndereco("Endereco: " + id);
        return cliente;
    }
    
    @Override
    public Cliente update(Cliente cliente) {
      	logger.info("Atualizando cliente");
    	return cliente;
    }

    @Override
    public void delete(String clienteId) {
		logger.info("Removendo Cliente");
    }
}
