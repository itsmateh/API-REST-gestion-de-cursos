package com.ejercicios.practica.service;

import com.ejercicios.practica.dto.CursoTemaDTO;
import com.ejercicios.practica.model.Curso;
import com.ejercicios.practica.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CursoService implements ICursoService{
    // INYECCION DEPENDENCIAS
    @Autowired
    ICursoRepository curRep;




    @Override
    public void saveCurso(Curso curso) {
        curRep.save(curso);
    }

    @Override
    public List<Curso> getCursos() {
        return curRep.findAll();
    }

    @Override
    public List<Curso> getCursosJava() {
         String palabra = "Java";
         String coincide;

         List<Curso> listaCursos = this.getCursos();
         List<Curso> listaCursosJava = new ArrayList<Curso>();

        for(Curso curso : listaCursos){
            coincide = curso.getNombre();
            boolean contieneJava = coincide.contains(palabra);
            if(contieneJava == true) {
                listaCursosJava.add(curso);
            }
        }
        return listaCursosJava;
    }

    @Override
    public List<Curso> getCursosByName(String name) {
        String palabra = name;
        String coincide;

        List<Curso> listaCursos = this.getCursos();
        List<Curso> listaCursosPalabra = new ArrayList<Curso>();

        for(Curso c : listaCursos){
            coincide = c.getNombre();
            boolean contienePalabra = coincide.contains(palabra);
            if(contienePalabra == true) {
                listaCursosPalabra.add(c);
            }
        }
        return listaCursosPalabra;
    }

    @Override
    public void editCurso(Curso curso) {
        this.saveCurso(curso);
    }

    @Override
    public Curso findCurso(Long id) {
        return curRep.findById(id).orElse(null);
    }

    @Override
    public void deleteCurso(Long id) {
        curRep.deleteById(id);
    }

    @Override
    public CursoTemaDTO temaPorCurso(Long id) {
         CursoTemaDTO curTemDTO = new CursoTemaDTO();
         Curso curso = this.findCurso(id);

         curTemDTO.setNombreCurso(curso.getNombre());
         curTemDTO.setListaTemas(curso.getListaDeTemas());

         return curTemDTO;
    }


}
