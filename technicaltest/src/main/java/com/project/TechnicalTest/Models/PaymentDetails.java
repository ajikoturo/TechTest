package com.project.TechnicalTest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {

    @Id
    @Column(name = "employeeid")
    private Long id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "job_position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column(name = "currency_code")
    private String currency;

    @Column(name = "salary")
    private int salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
