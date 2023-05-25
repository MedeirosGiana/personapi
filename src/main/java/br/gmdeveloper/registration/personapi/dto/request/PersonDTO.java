package br.gmdeveloper.registration.personapi.dto.request;

import br.gmdeveloper.registration.personapi.entity.Person;
import br.gmdeveloper.registration.personapi.entity.Phone;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDTO {
    private Long id;
    @NotEmpty
    @Length(min = 1, max = 100)
    private String firstName;
    @NotEmpty
    @Length(min = 1, max = 100)
    private String lastName;
    @NotEmpty
    @CPF
    private String cpf;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private List<PhoneDTo> phone;

    public void setPhone(List<Phone> phones) {
    }
}
