package com.project.TechnicalTest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_benefit_detail")
public class EmployeeBenefitDetail {

    @Id
    @Column(name = "employeeid")
    private Long id;

    @Column(name = "salary")
    private int salary;

    @Column(name = "currency_code")
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
