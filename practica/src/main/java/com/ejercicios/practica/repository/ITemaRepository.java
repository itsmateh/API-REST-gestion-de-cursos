package com.ejercicios.practica.repository;

import com.ejercicios.practica.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemaRepository extends JpaRepository<Tema,Long> {
}
