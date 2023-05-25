package br.gmdeveloper.registration.personapi.controller;

import br.gmdeveloper.registration.personapi.dto.MessageResponseDTO;
import br.gmdeveloper.registration.personapi.dto.request.PersonDTO;
import br.gmdeveloper.registration.personapi.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

  private PersonService personService;

  @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createdPerson(@RequestBody @Valid PersonDTO personDTO){

      return personService.createdPerson(personDTO);
    }

}
