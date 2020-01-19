package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.model.Cliente;

@Repository
public interface  PedidoRepository extends JpaRepository<Cliente, Long> {

}
