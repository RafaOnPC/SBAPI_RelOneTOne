package com.relations.onetoone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    private String street;
    private String city;

    @OneToOne(mappedBy = "address", cascade = CascadeType.MERGE)
    @JsonBackReference // Evita la serialización recursiva de Persona
    private Persona persona;

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", persona=" + persona.getIdPersona() +
                '}';
    }
}
