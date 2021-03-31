package com.heroku.ifeslp1backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GER_MESA")
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_MESA", length = 10, nullable = false)
	private Long codMesa;

	@Column(name = "NOME", length = 5, nullable = false)
	private String nome;

	public Mesa(Long codMesa, String nome) {
		this.codMesa = codMesa;
		this.nome = nome;
	}

	public Long getCodMesa() {
		return codMesa;
	}

	public void setCodMesa(Long codMesa) {
		this.codMesa = codMesa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
