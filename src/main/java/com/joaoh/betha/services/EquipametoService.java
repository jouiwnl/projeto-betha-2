package com.joaoh.betha.services;

import com.joaoh.betha.domain.Equipamento;
import com.joaoh.betha.repositories.EquipamentoRepository;
import com.joaoh.betha.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EquipametoService {

    @Autowired
    private EquipamentoRepository repo;

    public Equipamento find(Integer id) {
        Optional<Equipamento> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Equipamento> findAll() {
        return repo.findAll();
    }

}
