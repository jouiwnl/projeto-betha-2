package com.joaoh.betha.services;

import com.joaoh.betha.domain.Estado;
import com.joaoh.betha.repositories.CidadeRepository;
import com.joaoh.betha.repositories.EstadoRepository;
import com.joaoh.betha.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repo;


    public List<Estado> findAll() {
        return repo.findAll();
    }

    public Estado find(Integer id) {
        Optional<Estado> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Estado insert(Estado obj) {
        obj.setId(null);
        return repo.save(obj);
    }


}
