package com.example.lab7.entitiies;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    private Integer id;

    @Size(max = 255)
    @Column(name = "FirstName")
    private String firstName;

    @Size(max = 255)
    @Column(name = "LastName")
    private String lastName;

    @Size(max = 255)
    @Column(name = "Email")
    private String email;

    @Size(max = 9)
    @Column(name = "Phone", length = 9)
    private String phone;

}