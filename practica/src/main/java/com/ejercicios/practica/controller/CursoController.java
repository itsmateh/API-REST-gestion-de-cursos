package com.ejercicios.practica.controller;

import com.ejercicios.practica.dto.CursoTemaDTO;
import com.ejercicios.practica.model.Curso;
import com.ejercicios.practica.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CursoController  {

    @Autowired
    ICursoService curServ;

   // 1) CREAR CURSO
   @PostMapping("/curso/crear")
    public String crearCurso(@RequestBody Curso curso){
       curServ.saveCurso(curso);
       return "¡Curso creado exitosamente!" +
               "Nombre: " + curso.getNombre();
   }


    // 3) TRAER TODOS LOS CURSOS
    @GetMapping("/curso/todos")
    public List<Curso> getAllCursos(){
       return curServ.getCursos();
    }

    // 4) TRAER TEMAS DE UN CURSO
    @GetMapping("/curso/tema/{id}")
    public CursoTemaDTO temaPorCurso(long id){
        return curServ.temaPorCurso(id);
    }

    // 5) TRAER TODOS LOS CURSOS CON LA PALABRA "JAVA"
    @GetMapping("/curso/java")
    public List<Curso> traerCursosJava(){
       return curServ.getCursosJava();
    }

    // extra: TRAER TODOS LOS CURSOS CON CIERTO NOBRE
    @GetMapping("/cursos/{nombre}")
    public List<Curso> traerCursoSolicitado(@PathVariable String nombre){
       return curServ.getCursosByName(nombre);
    }




}
