package com.heroku.ifeslp1backend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.heroku.ifeslp1backend.enumerator.EPedStatus;

@Entity
@Table(name = "GER_PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_PEDIDO", length = 10, nullable = false)
	private Long codPedido;

	@Column(name = "COD_COMANDA", length = 10)
	private Long codComanda;

	@ElementCollection
	private List<Produto> produtos;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_PEDIDOS", length = 15)
	private EPedStatus statusPedidos;

	@Column(name = "VALOR_TOTAL")
	private double valorTotal;

	@Column(name = "OBSERVACAO")
	private String observacao;
	
	public Pedido() {
	}

	public Pedido(Long codPedido, Long codComanda, List<Produto> produtos, EPedStatus statusPedidos, double valorTotal,
			String observacao) {
		this.codPedido = codPedido;
		this.codComanda = codComanda;
		this.produtos = produtos;
		this.statusPedidos = statusPedidos;
		this.valorTotal = valorTotal;
		this.observacao = observacao;
	}

	public Long getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Long codPedido) {
		this.codPedido = codPedido;
	}

	public Long getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(Long codComanda) {
		this.codComanda = codComanda;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public EPedStatus getStatusPedidos() {
		return statusPedidos;
	}

	public void setStatusPedidos(EPedStatus statusPedidos) {
		this.statusPedidos = statusPedidos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		return true;
	}
}
