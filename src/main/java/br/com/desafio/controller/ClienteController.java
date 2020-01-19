package br.com.desafio.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.business.ClienteBusiness;
import br.com.desafio.dto.ClienteDto;
import br.com.desafio.model.Cliente;

@RestController()
@RequestMapping("api/v1/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(clienteBusiness.listarClientes());
	}
	
	@PostMapping
	public ResponseEntity<?> criar(@RequestBody ClienteDto dto, UriComponentsBuilder uriBuilder) {
		ClienteDto clienteDto = clienteBusiness.salvar(dto);
		URI uri = uriBuilder.path("/api/v1/cliente/{id}").buildAndExpand(clienteDto.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> obter(@PathVariable("id") Long id){
		Cliente clienteDto = clienteBusiness.obter(id);
		return ResponseEntity.ok(clienteDto);
	}

}
