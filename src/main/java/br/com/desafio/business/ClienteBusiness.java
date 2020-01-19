package br.com.desafio.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.dto.ClienteDto;
import br.com.desafio.model.Cliente;
import br.com.desafio.repository.ClienteRepository;

@Service
public class ClienteBusiness {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public ClienteDto salvar(ClienteDto clienteDto) {
		Cliente cliente = ClienteDto.converteCliente(clienteDto);
		Cliente save = clienteRepository.save(cliente);
		return new ClienteDto(save);
	}
	
	public Cliente obter(Long id) {
		Cliente cliente = clienteRepository.getOne(id);
		return cliente;
	}

}
