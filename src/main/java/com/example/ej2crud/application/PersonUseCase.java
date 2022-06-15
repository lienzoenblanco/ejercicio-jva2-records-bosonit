package com.example.ej2crud.application;

import com.example.ej2crud.application.dto.ResponseDto;
import com.example.ej2crud.infraestructure.dto.input.InputPersonDto;
import com.example.ej2crud.infraestructure.dto.output.OutputPersonDto;
import com.example.ej2crud.domain.Person;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonUseCase {
    protected PersonRepository personRepository;

    protected PersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    protected List<OutputPersonDto> serialize(List<Person> personList) {
        ArrayList<OutputPersonDto> outputPersonDtoList = new ArrayList<>();
        for (Person person: personList) {
            outputPersonDtoList.add(this.serialize(person));
        }
        return outputPersonDtoList;
    }

    protected OutputPersonDto serialize(Person person) {
        OutputPersonDto outputPersonDto = new OutputPersonDto();
        outputPersonDto.setPerson_id(person.getPerson_id());
        outputPersonDto.setUser(person.getUser());
        outputPersonDto.setName(person.getName());
        outputPersonDto.setSurname(person.getSurname());
        outputPersonDto.setCompany_email(person.getCompany_email());
        outputPersonDto.setPersonal_email(person.getPersonal_email());
        outputPersonDto.setCity(person.getCity());
        outputPersonDto.setActive(person.getActive());
        outputPersonDto.setCreated_date(person.getCreated_date());
        outputPersonDto.setImage_ulr(person.getImage_url());
        return outputPersonDto;
    }




}
