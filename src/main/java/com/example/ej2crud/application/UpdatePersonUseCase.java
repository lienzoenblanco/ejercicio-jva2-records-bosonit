package com.example.ej2crud.application;

import com.example.ej2crud.application.exceptions.NotFoundException;
import com.example.ej2crud.application.exceptions.UnprocessableException;
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
            throw new NotFoundException("El id no existe");
        }
        if (inputPersonDto.user() == null){
            throw new UnprocessableException("El usuario no puede ser nulo");
        }
        Person person = personList.get(0);
        person.setUser(inputPersonDto.user());
        person.setPassword(inputPersonDto.password());
        person.setName(inputPersonDto.name());
        person.setSurname(inputPersonDto.surname());
        person.setCompany_email(inputPersonDto.company_email());
        person.setPersonal_email(inputPersonDto.personal_email());
        person.setCity(inputPersonDto.city());
        person.setActive(inputPersonDto.active());
        person.setCreated_date(inputPersonDto.created_date());
        person.setImage_url(inputPersonDto.image_url());
        this.personRepository.save(person);
        return true;
    }
}
