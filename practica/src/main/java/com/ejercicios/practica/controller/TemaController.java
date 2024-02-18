package com.ejercicios.practica.controller;

import com.ejercicios.practica.model.Tema;
import com.ejercicios.practica.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {

    @Autowired
    ITemaService temaServ;

    // 2) CREAR TEMAS Y ASOCIAR A CURSO
    @PostMapping("/tema/crear")
    public String crearTema(@RequestBody Tema tema){
        temaServ.saveTema(tema);
        return "¡Tema creado con exito! :)";
    }

    // 6) MODIFICAR LOS DATOS DE UN CURSO
    @PutMapping("/tema/edit")
    public String editTema(@RequestBody Tema tema){
            temaServ.editTema(tema);
            return "¡Tema editado correctamente! :)";

    }
}
