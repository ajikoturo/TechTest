package com.project.TechnicalTest.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employee_job_detail")
public class EmployeeJobDetail {

    @Id
    @Column(name = "employeeid")
    private Long id;

    @Column(name = "job_position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column(name = "join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
