package com.heroku.ifeslp1backend.model;

import javax.persistence.*;

@Entity
@Table(name = "GER_MESAS")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MES_COD", length = 10, nullable = false)
    private Long mesCod;

    @Column(name = "MES_ESP_COD", length = 5, nullable = false)
    private String mesEspCod;

    public Mesa() {
    }

    public Mesa(Long mesCod, String mesEspCod) {
        this.mesCod = mesCod;
        this.mesEspCod = mesEspCod;
    }

    public Long getMesCod() {
        return mesCod;
    }

    public void setMesCod(Long mesCod) {
        this.mesCod = mesCod;
    }

    public String getMesEspCod() {
        return mesEspCod;
    }

    public void setMesEspCod(String mesEspCod) {
        this.mesEspCod = mesEspCod;
    }
}
