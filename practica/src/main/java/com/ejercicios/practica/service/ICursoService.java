package com.ejercicios.practica.service;

import com.ejercicios.practica.dto.CursoTemaDTO;
import com.ejercicios.practica.model.Curso;

import java.util.List;

public interface ICursoService {

    public void saveCurso(Curso curso);

    public List<Curso> getCursos();

    public List<Curso> getCursosJava();

    public List<Curso> getCursosByName(String name);

    public void editCurso(Curso curso);

    // extras
    public Curso findCurso(Long id);

    public void deleteCurso(Long id);

    public CursoTemaDTO temaPorCurso(Long id);
}
