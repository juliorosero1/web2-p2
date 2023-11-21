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

    public void copyDataFromUser(Autor source) {
        this.id = source.getId();
        this.email = source.getEmail();
        this.nombre = source.getNombre();
        this.apellido = source.getApellido();
    }
}
