package com.example.ej2crud.application;

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
    OutputPersonDto outputPersonDto =
        new OutputPersonDto( person.getPerson_id(),
            person.getUser(),
            person.getName(),
            person.getSurname(),
            person.getCompany_email(),
            person.getPersonal_email(),
            person.getCity(),
            person.getActive(),
            person.getCreated_date(),
            person.getImage_url()
        );
        return outputPersonDto;
    }




}
