package br.com.desafio.repository;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import br.com.desafio.model.Cliente;

@SpringBootTest
public class ClienteRepositoryTest {

	private ClienteRepository repository = Mockito.mock(ClienteRepository.class);
	
	@Test
	void listAllTest() {
		Cliente clienteMock = new Cliente();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		Mockito.when(this.repository.findAll()).thenReturn(Arrays.asList(clienteMock,clienteMock));
		List<Cliente> findAll = this.repository.findAll();
		Assert.assertNotNull(findAll);
	}
	
	@Test
	void saveTest() {
		Cliente clienteMock = new Cliente();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		Mockito.when(this.repository.save(Mockito.any())).thenReturn(clienteMock);
		Cliente cliente = this.repository.save(clienteMock);
		Assert.assertNotNull(cliente);
		Assert.assertTrue(clienteMock.getId()==1);
	}
	
	@Test
	void getClienteTest() {
		Cliente clienteMock = new Cliente();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		Mockito.when(this.repository.getOne(1L)).thenReturn(clienteMock);
		Cliente cliente = this.repository.getOne(1L);
		Assert.assertNotNull(cliente);
		Assert.assertTrue(clienteMock.getId()==1);
	}


}
