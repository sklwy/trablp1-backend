package com.heroku.ifeslp1backend.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.heroku.ifeslp1backend.enumerator.EComStatus;
import com.heroku.ifeslp1backend.service.ComandasService;

@Entity
@Table(name = "GER_COMANDA")
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_COMANDA", length = 10, nullable = false)
	private Long codComanda;

	@Column(name = "COD_MESA", length = 10)
	private Long codMesa;

	@ElementCollection
	private List<Pedido> listPedidos;

	@Column(name = "VALOR_TOTAL")
	private double valorTotal;

	@Column(name = "DATA_INICIO")
	@Temporal(TemporalType.TIME)
	private Date dataInicio;

	@Column(name = "DATA_FINAL")
	@Temporal(TemporalType.TIME)
	private Date dataFinal;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_COMANDA", length = 15)
	private EComStatus statusComanda;

	public Comanda() {
	}

	public Comanda(Long codComanda, Long codMesa, List<Pedido> listPedidos, double valorTotal, Date dataInicio,
			Date dataFinal, EComStatus statusComanda) {
		this.codComanda = codComanda;
		this.codMesa = codMesa;
		this.listPedidos = listPedidos;
		this.valorTotal = valorTotal;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.statusComanda = statusComanda;
	}

	public Long getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(Long codComanda) {
		this.codComanda = codComanda;
	}

	public Long getCodMesa() {
		return codMesa;
	}

	public void setCodMesa(Long codMesa) {
		this.codMesa = codMesa;
	}

	public List<Pedido> getListPedidos() {
		return listPedidos;
	}

	public void setListPedidos(List<Pedido> listPedidos) {
		this.listPedidos = listPedidos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public EComStatus getStatusComanda() {
		return statusComanda;
	}

	public void setStatusComanda(EComStatus statusComanda) {
		this.statusComanda = statusComanda;
	}
}
