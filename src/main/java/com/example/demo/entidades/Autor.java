package com.example.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
public class Autor {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;


}
