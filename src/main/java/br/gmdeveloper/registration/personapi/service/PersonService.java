package br.gmdeveloper.registration.personapi.service;

import br.gmdeveloper.registration.personapi.dto.MessageResponseDTO;
import br.gmdeveloper.registration.personapi.dto.request.PersonDTO;
import br.gmdeveloper.registration.personapi.dto.request.PhoneDTo;
import br.gmdeveloper.registration.personapi.entity.Person;
import br.gmdeveloper.registration.personapi.entity.Phone;
import br.gmdeveloper.registration.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createdPerson(PersonDTO personDTO) {
        Person personToSave = Person.builder()
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .birthDate(personDTO.getBirthDate())
                .cpf(personDTO.getCpf())
                .build();
        List<Phone> phonesToSave = new ArrayList<>();
        if (personDTO.getPhone() != null) {
            for (PhoneDTo phoneDTO : personDTO.getPhone()) {
                Phone phone = Phone.builder()
                        .number(phoneDTO.getNumber())
                        .type(phoneDTO.getType())
                        .build();
                phonesToSave.add(phone);
            }
        }
        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO.builder()
                .message("Created person").build();
    }
}
