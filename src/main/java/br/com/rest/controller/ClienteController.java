package br.com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.com.rest.models.Cliente;
import br.com.rest.services.ClienteService;


@Api(value = "person")
@RestController
@RequestMapping("/cliente/")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(value = "Busca cliente por ID" )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{clienteId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente get(@PathVariable(value = "clienteId") String clienteId){
        return clienteService.findById(clienteId);
    }
	
	@ApiOperation(value = "busca todos os clientes" )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
	
	@ApiOperation(value = "Cria um novo cliente" )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente create(@RequestBody Cliente cliente){
		return clienteService.create(cliente);
	}
	
	@ApiOperation(value = "atualiza um cliente existene")
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente update(@RequestBody Cliente cliente){
		return clienteService.update(cliente);
	}

	@ApiOperation(value = "Remove cliente por ID" )
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{clienteId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "personId") String clienteId){
        clienteService.delete(clienteId);
    }
	
}
