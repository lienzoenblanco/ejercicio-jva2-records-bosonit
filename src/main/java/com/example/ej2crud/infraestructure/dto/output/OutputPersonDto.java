package com.example.ej2crud.infraestructure.dto.output;


import java.util.Date;

public record OutputPersonDto(
        Integer person_id,
        String user,
        String name,
        String surname,
        String company_email,
        String personal_email,
        String city,
        boolean active,
        Date created_date,
        String image_url
) {}
