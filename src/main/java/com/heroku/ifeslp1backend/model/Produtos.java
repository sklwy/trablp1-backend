package com.heroku.ifeslp1backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GER_PRODUTOS")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_COD", length = 10, nullable = false)
    private Long proCod;

    @Column(name = "PRO_DES_NOME")
    private String proDesNome;

    @Column(name = "PRO_INGREDIENTE")
    private String proIngrediente;

    @Column(name = "PRO_VALOR")
    private double proValor;

    public Produtos() {
    }

    public Produtos(Long proCod, String proDesNome, String proIngrediente, double proValor) {
        this.proCod = proCod;
        this.proDesNome = proDesNome;
        this.proIngrediente = proIngrediente;
        this.proValor = proValor;
    }

    public Long getProCod() {
        return proCod;
    }

    public void setProCod(Long proCod) {
        this.proCod = proCod;
    }

    public String getProDesNome() {
        return proDesNome;
    }

    public void setProDesNome(String proDesNome) {
        this.proDesNome = proDesNome;
    }

    public String getProIngrediente() {
        return proIngrediente;
    }

    public void setProIngrediente(String proIngrediente) {
        this.proIngrediente = proIngrediente;
    }

    public double getProValor() {
        return proValor;
    }

    public void setProValor(double proValor) {
        this.proValor = proValor;
    }
}
