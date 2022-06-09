package com.example.ej2crud.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InputPersonDto {
    private int person_id;
    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String image_ulr;
}
