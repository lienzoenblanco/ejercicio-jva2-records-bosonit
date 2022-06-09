package com.example.ej2crud.service;

import com.example.ej2crud.entity.InputPersonDto;
import com.example.ej2crud.entity.OutputPersonDto;
import com.example.ej2crud.entity.Person;
import com.example.ej2crud.entity.ResponseDto;
import com.example.ej2crud.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    PersonRepository personRepository;

    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public ResponseDto add(InputPersonDto inputPersonDto) {
        if (inputPersonDto.getUser() == null) {
            return new ResponseDto(false,"El usuario no puede ser nulo");
        } else if (inputPersonDto.getUser().length() > 10){
            return new ResponseDto(false, "La longitud del campo usuario no puede ser superior a 10 caracteres");
        }
        Person person = new Person();
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
        this.personRepository.saveAndFlush(person);
        return new ResponseDto(true, "El usuario "+inputPersonDto.getUser()+" ha sido creado");
    }

    public OutputPersonDto getById(int id) {
        List<Person> personList = this.personRepository.findById(id);
        Person person = personList.get(0);
        return this.serialize(person);
    }

    public List<OutputPersonDto> list() {
        List<Person> personList= this.personRepository.findAll();
        return this.serialize(personList);
    }

    public List<OutputPersonDto> findByName(String name) {
        List<Person> personList = this.personRepository.findByName(name);
        return this.serialize(personList);
    }

    private List<OutputPersonDto> serialize(List<Person> personList) {
        ArrayList<OutputPersonDto> outputPersonDtoList = new ArrayList<>();
        for (Person person: personList) {
            outputPersonDtoList.add(this.serialize(person));
        }
        return outputPersonDtoList;
    }

    private OutputPersonDto serialize(Person person) {
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

    public void delete(int id) {
        this.personRepository.deleteById(id);
    }
}
