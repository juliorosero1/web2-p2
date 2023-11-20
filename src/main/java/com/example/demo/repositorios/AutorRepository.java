package com.example.demo.repositorios;

import com.example.demo.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
