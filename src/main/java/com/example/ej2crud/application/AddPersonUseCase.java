package com.example.ej2crud.application;

import com.example.ej2crud.application.dto.ResponseDto;
import com.example.ej2crud.application.exceptions.UnprocessableException;
import com.example.ej2crud.domain.Person;
import com.example.ej2crud.infraestructure.dto.input.InputPersonDto;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class AddPersonUseCase extends PersonUseCase{

    AddPersonUseCase(PersonRepository personRepository) {
        super(personRepository);
    }

    public ResponseDto add(InputPersonDto inputPersonDto) {
        if (inputPersonDto.user() == null) {
            throw new UnprocessableException("El usuario no puede ser nulo");
        } else if (inputPersonDto.user().length() > 10){
            throw new UnprocessableException("La longitud del campo usuario no puede ser superior a 10 caracteres");
        }
        Person person = new Person();
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
        this.personRepository.saveAndFlush(person);
        return new ResponseDto(true, "El usuario "+inputPersonDto.user()+" ha sido creado");
    }
}
