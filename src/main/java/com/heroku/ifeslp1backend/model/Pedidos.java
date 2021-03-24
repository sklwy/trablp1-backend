package com.heroku.ifeslp1backend.model;

import com.heroku.ifeslp1backend.enumerator.EPedStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GER_PEDIDOS")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PED_COD", length = 10, nullable = false)
    private Long pesCod;

    @Column(name = "MES_COD", length = 10)
    private Long mesCod;

    @Column(name = "COM_COD", length = 10)
    private Long comCod;

    @Column(name = "PRO_COD", length = 10)
    private Long proCod;

    @Enumerated(EnumType.STRING)
    @Column(name = "PED_STATUS", length = 15)
    private EPedStatus pedStatus;

    @Column(name = "PED_VLR_TOTAL")
    private double pedVlrTotal;

    public Pedidos() {
    }

    public Pedidos(Long pesCod, Long mesCod, Long comCod, Long proCod, EPedStatus pedStatus, double pedVlrTotal) {
        this.pesCod = pesCod;
        this.mesCod = mesCod;
        this.comCod = comCod;
        this.proCod = proCod;
        this.pedStatus = pedStatus;
        this.pedVlrTotal = pedVlrTotal;
    }

    public Long getPesCod() {
        return pesCod;
    }

    public void setPesCod(Long pesCod) {
        this.pesCod = pesCod;
    }

    public Long getMesCod() {
        return mesCod;
    }

    public void setMesCod(Long mesCod) {
        this.mesCod = mesCod;
    }

    public Long getComCod() {
        return comCod;
    }

    public void setComCod(Long comCod) {
        this.comCod = comCod;
    }

    public Long getProCod() {
        return proCod;
    }

    public void setProCod(Long proCod) {
        this.proCod = proCod;
    }

    public EPedStatus getPedStatus() {
        return pedStatus;
    }

    public void setPedStatus(EPedStatus pedStatus) {
        this.pedStatus = pedStatus;
    }

    public double getPedVlrTotal() {
        return pedVlrTotal;
    }

    public void setPedVlrTotal(double pedVlrTotal) {
        this.pedVlrTotal = pedVlrTotal;
    }
}
