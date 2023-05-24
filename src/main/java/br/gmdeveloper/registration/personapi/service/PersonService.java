package br.gmdeveloper.registration.personapi.service;

import br.gmdeveloper.registration.personapi.dto.MessageResponseDto;
import br.gmdeveloper.registration.personapi.entity.Person;
import br.gmdeveloper.registration.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDto createdPerson(Person person){
        Person savePerson = personRepository.save(person);
        return MessageResponseDto
                .builder()
                .message("created person with id "+ savePerson.getId())
                .build();
    }
}
