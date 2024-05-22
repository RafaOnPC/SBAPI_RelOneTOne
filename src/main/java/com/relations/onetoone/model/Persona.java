package com.relations.onetoone.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    private String name;

    //Relacion Bidireccional
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "address_id", referencedColumnName = "idAddress")
    @JsonManagedReference // Controla la serialización de Address
    private Address address;

}
