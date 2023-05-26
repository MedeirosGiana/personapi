package br.gmdeveloper.registration.personapi.service;

import br.gmdeveloper.registration.personapi.dto.MessageResponseDTO;
import br.gmdeveloper.registration.personapi.dto.request.PersonDTO;
import br.gmdeveloper.registration.personapi.dto.request.PhoneDTO;
import br.gmdeveloper.registration.personapi.entity.Person;
import br.gmdeveloper.registration.personapi.entity.Phone;
import br.gmdeveloper.registration.personapi.exception.PersonNotFoundException;
import br.gmdeveloper.registration.personapi.mapper.PersonMapper;
import br.gmdeveloper.registration.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyExists(id);
        return  personMapper.toDTO(person);
        //opção sem o Lambda
        /*Optional<Person> optionalPerson = personRepository.findById(id);
        informa que não foi encontrado no sistema a pessoal procurada
        if (optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }*/
        //opção com o Lambda
    }

    public void delete(Long id) throws PersonNotFoundException{
        verifyExists(id);
        personRepository.deleteById(id);
    }
    private Person verifyExists(Long id) throws PersonNotFoundException{
      return personRepository.findById(id)
                .orElseThrow(()->new PersonNotFoundException(id));
    }
}



