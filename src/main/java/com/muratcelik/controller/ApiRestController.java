package com.muratcelik.controller;

import com.muratcelik.entity.Person;
import com.muratcelik.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private IPersonService personService;

    //GetAll
    @GetMapping(value = "/get/getAllPerson")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    // GetById
    @GetMapping(value = "/get/getPersonById/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    //DeleteById
    @PostMapping(value = "/admin/deletePerson")
    public ResponseEntity<String> deletePersonById(@RequestBody Person person) {
        personService.deletePersonById(person.getId());
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
    //Add
    @PostMapping(value = "/admin/addPerson")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
    // Update
    @PostMapping(value = "/admin/updatePerson")
    public ResponseEntity<String> updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
