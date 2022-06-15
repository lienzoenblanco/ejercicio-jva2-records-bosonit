package com.example.ej2crud.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int person_id;

    @Column(name = "`user`")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "company_email")
    private String company_email;

    @Column(name = "personal_email")
    private String personal_email;

    @Column(name = "city")
    private String city;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "termination_date")
    private Date termination_date;

}
