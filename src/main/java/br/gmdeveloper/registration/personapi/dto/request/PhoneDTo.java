package br.gmdeveloper.registration.personapi.dto.request;

import br.gmdeveloper.registration.personapi.enums.PhoneType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PhoneDTo {
    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @Length(min = 13, max = 14)
    private String number;

}
