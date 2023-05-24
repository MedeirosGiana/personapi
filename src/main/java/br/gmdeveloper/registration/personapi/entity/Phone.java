package br.gmdeveloper.registration.personapi.entity;

import br.gmdeveloper.registration.personapi.enums.PhoneType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)//torna o campo obrigatório
    private PhoneType type;

    @Column(nullable = false)
    private String number;

}
