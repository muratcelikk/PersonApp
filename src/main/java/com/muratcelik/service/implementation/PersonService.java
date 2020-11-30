package com.muratcelik.service.implementation;

import com.muratcelik.entity.Person;
import com.muratcelik.repository.PersonRepo;
import com.muratcelik.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    @Override
    public void addPerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void deletePersonById(long id) {
        personRepo.deleteById(id);
    }

    @Override
    public Optional<Person> getPersonById(long id) {
        return personRepo.findById(id);
    }

    @Override
    public void updatePerson(Person personUpdate) {
        Person person = personRepo.getOne(personUpdate.getId());
        person.setName(personUpdate.getName());
        person.setAge(personUpdate.getAge());
        personRepo.save(person);
    }
}
