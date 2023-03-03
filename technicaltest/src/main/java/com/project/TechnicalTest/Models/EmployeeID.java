package com.project.TechnicalTest.Models;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employeeid")
//@Document(indexName = "technicaltest", Type = "employeeID", shards = 2)
public class EmployeeID {

    @Id
    @Column(name = "employeeid")
    private Long id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "place_of_Birth")
    private String placeBirth;

    @Column(name = "date_of_Birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBirth;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "gender")
    private char gender;

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

    public String getPlaceBirth() {
        return placeBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
