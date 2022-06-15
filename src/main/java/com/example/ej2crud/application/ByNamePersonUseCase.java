package com.example.ej2crud.application;

import com.example.ej2crud.domain.Person;
import com.example.ej2crud.infraestructure.dto.output.OutputPersonDto;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ByNamePersonUseCase extends PersonUseCase{

    ByNamePersonUseCase(PersonRepository personRepository) {
        super(personRepository);
    }
    public List<OutputPersonDto> findByName(String name) {
        List<Person> personList = this.personRepository.findByName(name);
        return this.serialize(personList);
    }
}
