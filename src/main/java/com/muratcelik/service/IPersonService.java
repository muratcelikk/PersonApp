package com.muratcelik.service;

import com.muratcelik.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    List<Person> getAllPerson();

    void addPerson(Person person);

    void deletePersonById(long id);

    Optional<Person> getPersonById(long id);

    void updatePerson(Person personUpdate);
}
