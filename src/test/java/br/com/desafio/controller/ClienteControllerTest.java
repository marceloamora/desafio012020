package br.com.desafio.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.business.ClienteBusiness;
import br.com.desafio.dto.ClienteDto;
import br.com.desafio.model.Cliente;

@SpringBootTest
public class ClienteControllerTest {
	
	private ClienteBusiness business = Mockito.mock(ClienteBusiness.class);
	@Autowired
	private ClienteController api;
	
	
	@Test
	public void testListar() {
		Cliente clienteMock = new Cliente();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		Mockito.when(this.business.listarClientes()).thenReturn( Arrays.asList(clienteMock, clienteMock));
		ResponseEntity<?> listarClientes = this.api.listar();
		Assert.assertNotNull(listarClientes);
	}
	
	
	@Test
	public void testSalvar() {
		ClienteDto clienteMock = new ClienteDto();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		Mockito.when(this.business.salvar(Mockito.any())).thenReturn(clienteMock);
		UriComponentsBuilder uriBuilder =  UriComponentsBuilder.newInstance();
		ResponseEntity<?> listarClientes = this.api.criar(new ClienteDto(), uriBuilder);
		Assert.assertNotNull(listarClientes);
	}
	
	
	@Test
	public void testObter() {
		Cliente clienteMock = new Cliente();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		Mockito.when(this.business.obter(Mockito.anyLong())).thenReturn(clienteMock);
		ResponseEntity<?> umCliente = this.api.obter(1L);
		Assert.assertNotNull(umCliente);
	}




}
