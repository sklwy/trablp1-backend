package com.heroku.ifeslp1backend.model;

import com.heroku.ifeslp1backend.enumerator.EPedStatus;

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
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "GER_COMANDAS")
public class Comandas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COM_COD", length = 10, nullable = false)
    private Long comCod;

    @ElementCollection
    private List<Pedidos> comPedidos;

    @Column(name = "COM_VALOR_TOTAL")
    private double comValorTotal;

    @Column(name = "COM_DTA_INI")
    @Temporal(TemporalType.TIME)
    private Date comDtaIni;

    @Column(name = "COM_DTA_FINI")
    @Temporal(TemporalType.TIME)
    private Date comDtaFini;

    @Enumerated(EnumType.STRING)
    @Column(name = "COM_STATUS")
    private EPedStatus comStatus;

    public Comandas() {
    }

    public Comandas(Long comCod, double comValorTotal, Date comDtaIni, Date comDtaFini, EPedStatus comStatus) {
        this.comCod = comCod;
        this.comValorTotal = comValorTotal;
        this.comDtaIni = comDtaIni;
        this.comDtaFini = comDtaFini;
        this.comStatus = comStatus;
    }

    public Comandas(Long comCod, List<Pedidos> comPedidos, double comValorTotal, Date comDtaIni, Date comDtaFini, EPedStatus comStatus) {
        this.comCod = comCod;
        this.comPedidos = comPedidos;
        this.comValorTotal = comValorTotal;
        this.comDtaIni = comDtaIni;
        this.comDtaFini = comDtaFini;
        this.comStatus = comStatus;
    }

    public Long getComCod() {
        return comCod;
    }

    public void setComCod(Long comCod) {
        this.comCod = comCod;
    }

    public List<Pedidos> getComPedidos() {
        return comPedidos;
    }

    public void setComPedidos(List<Pedidos> comPedidos) {
        this.comPedidos = comPedidos;
    }

    public double getComValorTotal() {
        return comValorTotal;
    }

    public void setComValorTotal(double comValorTotal) {
        this.comValorTotal = comValorTotal;
    }

    public Date getComDtaIni() {
        return comDtaIni;
    }

    public void setComDtaIni(Date comDtaIni) {
        this.comDtaIni = comDtaIni;
    }

    public Date getComDtaFini() {
        return comDtaFini;
    }

    public void setComDtaFini(Date comDtaFini) {
        this.comDtaFini = comDtaFini;
    }

    public EPedStatus getComStatus() {
        return comStatus;
    }

    public void setComStatus(EPedStatus comStatus) {
        this.comStatus = comStatus;
    }
}
