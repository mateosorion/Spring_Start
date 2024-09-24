package com.tesla.crud.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/person")

public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path="getNames")
    public List<Person> getNames(){
        return personService.getNames();
    }

    @PostMapping(path="addPerson")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @DeleteMapping(path="deletePerson/{id}")
    public void deletePerson(@PathVariable int id){
        personService.deletePerson(id);
    }

    @PutMapping(path="updatePerson/{id}")
    public void updatePerson(@PathVariable int id, @RequestBody Person person){
        personService.updatePerson(id, person);
    }

}
