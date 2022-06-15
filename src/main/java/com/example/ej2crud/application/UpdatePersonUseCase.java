package com.example.ej2crud.application;

import com.example.ej2crud.domain.Person;
import com.example.ej2crud.infraestructure.dto.input.InputPersonDto;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdatePersonUseCase extends PersonUseCase{

    protected UpdatePersonUseCase(PersonRepository personRepository) {
        super(personRepository);
    }

    public Boolean update(InputPersonDto inputPersonDto, int id) {
        List<Person> personList = this.personRepository.findById(id);
        if (personList == null){
            return false;
        }
        Person person = personList.get(0);
        person.setUser(inputPersonDto.getUser());
        person.setPassword(inputPersonDto.getPassword());
        person.setName(inputPersonDto.getName());
        person.setSurname(inputPersonDto.getSurname());
        person.setCompany_email(inputPersonDto.getCompany_email());
        person.setPersonal_email(inputPersonDto.getPersonal_email());
        person.setCity(inputPersonDto.getCity());
        person.setActive(inputPersonDto.getActive());
        person.setCreated_date(inputPersonDto.getCreated_date());
        person.setImage_url(inputPersonDto.getImage_ulr());
        this.personRepository.save(person);
        return true;
    }
}
