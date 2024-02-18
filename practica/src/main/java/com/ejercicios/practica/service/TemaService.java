package com.ejercicios.practica.service;

import com.ejercicios.practica.model.Tema;
import com.ejercicios.practica.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService implements ITemaService{

    @Autowired
    ITemaRepository temaRep;

    @Override
    public List<Tema> getTemas() {
        return temaRep.findAll();
    }

    @Override
    public void saveTema(Tema tema) {
        temaRep.save(tema);
    }

    @Override
    public void deleteTema(Long id) {
        temaRep.deleteById(id);
    }

    @Override
    public Tema findTema(Long id) {
        return temaRep.findById(id).orElse(null);
    }

    @Override
    public void editTema(Tema tema) {
        this.saveTema(tema);
    }

}
