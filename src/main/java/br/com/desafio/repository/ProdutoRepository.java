package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
