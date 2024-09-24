package com.tesla.crud.person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final List<Person> people = new ArrayList<>();

    public PersonService() {
        people.add(new Person(1, "Juan", "Perez", 25, 12345678, "Masculino", "JuanPerez@email.com"));
        people.add(new Person(2, "Maria", "Gomez", 30, 87654321, "Femenino", "MariaGomez@email.com"));
    }

    public List<Person> getNames() {
        return new ArrayList<>(people);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void deletePerson(int id) {
        people.remove(id);
    }

    public void updatePerson(int id, Person person) {
        people.set(id, person);
    }

}