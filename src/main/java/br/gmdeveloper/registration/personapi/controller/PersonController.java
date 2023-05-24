package br.gmdeveloper.registration.personapi.controller;

import br.gmdeveloper.registration.personapi.dto.MessageResponseDto;
import br.gmdeveloper.registration.personapi.entity.Person;
import br.gmdeveloper.registration.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDto createdPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDto
                .builder()
                .message("created person with id "+ savedPerson.getId())
                .build();
    }
}
