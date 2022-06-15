package com.example.ej2crud.application;

import com.example.ej2crud.infraestructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCase extends PersonUseCase{

    protected DeletePersonUseCase(PersonRepository personRepository) {
        super(personRepository);
    }

    public void delete(int id) {
        this.personRepository.deleteById(id);
    }
}
