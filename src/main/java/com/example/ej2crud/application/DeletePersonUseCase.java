package com.example.ej2crud.application;

import com.example.ej2crud.application.exceptions.NotFoundException;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonUseCase extends PersonUseCase{

    protected DeletePersonUseCase(PersonRepository personRepository) {
        super(personRepository);
    }

    public void delete(int id) {
        try {
            this.personRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new NotFoundException("El id no existe");
        }
    }
}
