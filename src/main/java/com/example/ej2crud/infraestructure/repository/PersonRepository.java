package com.example.ej2crud.infraestructure.repository;

import com.example.ej2crud.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);
    List<Person> findById(int id);
    List<Person> deleteById(int id);
}
