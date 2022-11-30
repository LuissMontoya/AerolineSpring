package com.example.oracle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HOTEL")
public class Hotel {
    @Id
    private Long hotecodi;
    private String hotenomb;
    private String hotenit;
    private String hotedire;
    private Long hotetele;
    private String hoteesta;
    private String hoteemai;
    private Long hotecelu;

    public Long getHotecodi() {
        return hotecodi;
    }

    public void setHotecodi(Long hotecodi) {
        this.hotecodi = hotecodi;
    }

    public String getHotenomb() {
        return hotenomb;
    }

    public void setHotenomb(String hotenomb) {
        this.hotenomb = hotenomb;
    }

    public String getHotenit() {
        return hotenit;
    }

    public void setHotenit(String hotenit) {
        this.hotenit = hotenit;
    }

    public String getHotedire() {
        return hotedire;
    }

    public void setHotedire(String hotedire) {
        this.hotedire = hotedire;
    }

    public Long getHotetele() {
        return hotetele;
    }

    public void setHotetele(Long hotetele) {
        this.hotetele = hotetele;
    }

    public String getHoteesta() {
        return hoteesta;
    }

    public void setHoteesta(String hoteesta) {
        this.hoteesta = hoteesta;
    }

    public String getHoteemai() {
        return hoteemai;
    }

    public void setHoteemai(String hoteemai) {
        this.hoteemai = hoteemai;
    }

    public Long getHotecelu() {
        return hotecelu;
    }

    public void setHotecelu(Long hotecelu) {
        this.hotecelu = hotecelu;
    }
}
