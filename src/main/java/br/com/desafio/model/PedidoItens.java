package br.com.desafio.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidoitens")
public class PedidoItens {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto idProduto;
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido idPedido;
	private String produto;
	private Integer quantidade;
	private BigDecimal valor;
	private BigDecimal subtotal;
	public Long getId() {
		return id;
	}
	public Produto getIdProduto() {
		return idProduto;
	}
	public Pedido getIdPedido() {
		return idPedido;
	}
	public String getProduto() {
		return produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}
	public void setIdPedido(Pedido idPedido) {
		this.idPedido = idPedido;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	
	

}
