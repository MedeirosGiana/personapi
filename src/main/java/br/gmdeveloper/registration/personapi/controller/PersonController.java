package br.gmdeveloper.registration.personapi.controller;

import br.gmdeveloper.registration.personapi.dto.MessageResponseDTO;
import br.gmdeveloper.registration.personapi.dto.request.PersonDTO;
import br.gmdeveloper.registration.personapi.exception.PersonNotFoundException;
import br.gmdeveloper.registration.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

  private PersonService personService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
    return personService.createPerson(personDTO);
  }

  @GetMapping
  public List<PersonDTO> listAll() {
    return personService.listAll();
  }

  @GetMapping("/{id}")
  public PersonDTO fidById(@PathVariable Long id) throws PersonNotFoundException {
    return  personService.findById(id);
  }
}