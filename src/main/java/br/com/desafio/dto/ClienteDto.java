package br.com.desafio.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import br.com.desafio.model.Cliente;

public class ClienteDto {
	private Long id;
	private String email;
	private String senha;
	private String rua;
	private String cidade;
	private String bairro;
	private String cep;
	private String estado;
	
	public ClienteDto() {}
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		this.rua = cliente.getRua();
		this.cidade = cliente.getCidade();
		this.bairro = cliente.getBairro();
		this.cep = cliente.getCep();
		this.estado = cliente.getEstado();
	}
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getRua() {
		return rua;
	}
	public String getCidade() {
		return cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCep() {
		return cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static Cliente converteCliente(ClienteDto dto) {
		Cliente cliente = new Cliente();
		cliente.setBairro(dto.getBairro());
		cliente.setCep(dto.getCep());
		cliente.setCidade(dto.getCidade());
		cliente.setEmail(dto.getEmail());
		cliente.setEstado(dto.getEstado());;
		cliente.setRua(dto.getRua());
		cliente.setSenha(dto.getSenha());
		return cliente;
	}
	
	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}


}
