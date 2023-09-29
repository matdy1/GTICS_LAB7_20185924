package com.example.lab7.entitiies;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Tecnicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID", nullable = false)
    private int id;

    @Size(max = 255,message = "Solo se soportan 255 caractéres")
    @NotBlank
    @Column(name = "FirstName")
    private String firstName;

    @Size(max = 255,message = "Solo se soportan 255 caracteres")
    @NotBlank
    @Column(name = "LastName")
    private String lastName;

    @Size(max = 9,message = "Solo se soportan 9 caracteres")
    @Column(name = "Phone", length = 9)
    private String phone;

    @Size(max = 8,message = "Solo se soportan 8 caracteres")
    @Column(name = "Dni", length = 8)
    @NotBlank
    private String DNI;

    @Column(name = "Age")
    @Digits(integer = 5,fraction = 0)
    @Min(value = 0,message = "el valor debe ser mayor a cero")
    @Max(value = 32767,message = "el valor máximo es 32767")
    private int edad;
}