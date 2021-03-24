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
    private Long pedCod;

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

    public Pedidos(Long pedCod, Long comCod, Long proCod, EPedStatus pedStatus, double pedVlrTotal) {
        this.pedCod = pedCod;
        this.comCod = comCod;
        this.proCod = proCod;
        this.pedStatus = pedStatus;
        this.pedVlrTotal = pedVlrTotal;
    }

    public Long getPedCod() {
        return pedCod;
    }

    public void setPedCod(Long pedCod) {
        this.pedCod = pedCod;
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
