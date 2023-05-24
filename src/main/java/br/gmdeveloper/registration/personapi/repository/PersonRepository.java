package br.gmdeveloper.registration.personapi.repository;

import br.gmdeveloper.registration.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
