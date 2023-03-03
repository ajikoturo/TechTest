package com.project.TechnicalTest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "master_currency")
public class MasterCurrency {

    @Id
    @Column(name = "currency_code")
    private String currency;

    @Column(name = "descr")
    private String descr;

    @Column(name = "rate")
    private int Rate;

    @Column(name = "valid_from")
    private Date validFrom;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }
}
