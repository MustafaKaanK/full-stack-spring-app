package com.example.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Personel {
    
    @Id
    private String tc;
    private String ad;
    private String soyad;

    // Constructors
    public Personel() {}

    public Personel(String tc, String ad, String soyad) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
}
