package br.com.desafio.business;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.desafio.dto.ClienteDto;
import br.com.desafio.model.Cliente;
import br.com.desafio.repository.ClienteRepository;

@SpringBootTest
public class ClienteBusinessTest {

	private ClienteRepository repository = Mockito.mock(ClienteRepository.class);
	@Autowired
	private ClienteBusiness clienteBusiness;

	@Test
	public void listarClientesTest() {

		Cliente clienteMock = new Cliente();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		Mockito.when(this.repository.findAll()).thenReturn(Arrays.asList(clienteMock, clienteMock));
		List<?> listarClientes = this.clienteBusiness.listarClientes();
		Assert.assertNotNull(listarClientes);

	}

	@Test
	public void salvarTest() {
		Cliente clienteMock = new Cliente();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		Mockito.when(this.repository.save(Mockito.any())).thenReturn(clienteMock);
		ClienteDto cliente = this.clienteBusiness.salvar(new ClienteDto());
		Assert.assertNotNull(cliente);

	}

	@Test
	public void obterUm() {
		Cliente clienteMock = new Cliente();
		clienteMock.setBairro("ABC");
		clienteMock.setId(1L);
		clienteMock.setCep("");
		clienteMock.setCidade("");
		clienteMock.setEmail("");
		clienteMock.setEstado("");
		clienteMock.setRua("");
		clienteMock.setSenha("");
		ClienteDto dto = new ClienteDto();
		dto.setId(1L);
		Mockito.when(this.repository.getOne(1L)).thenReturn(clienteMock);
		Cliente cliente = this.clienteBusiness.obter(1L);
		Assert.assertNotNull(cliente);

	}

}
