package com.example.ej2crud.controler;

import com.example.ej2crud.entity.InputPersonDto;
import com.example.ej2crud.entity.OutputPersonDto;
import com.example.ej2crud.entity.ResponseDto;
import com.example.ej2crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    private ResponseDto responseDto;

    @PostMapping
    public ResponseEntity add(@RequestBody InputPersonDto inputPersonDto) {
        ResponseDto responseDto = this.personService.add(inputPersonDto);
        if (responseDto.getSuccess() == false) {
            return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
    }

    @GetMapping
    public List<OutputPersonDto> list() {
        return this.personService.list();
    }

    @GetMapping("/{id}")
    public OutputPersonDto getById(@PathVariable int id) {
        return this.personService.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<OutputPersonDto> getByName(@PathVariable String name) {
        return this.personService.findByName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @RequestBody InputPersonDto person,
            @PathVariable int id
    ) {
        if (!this.personService.update(person, id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.personService.delete(id);
    }
}
