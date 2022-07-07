package com.example.ej2crud.infraestructure.dto.input;

import lombok.Data;

import java.util.Date;


public record InputPersonDto(
        int person_id,
        String user,
        String password,
        String name,
        String surname,
        String company_email,
        String personal_email,
        String city,
        boolean active,
        Date created_date,
        String image_url
) {}
