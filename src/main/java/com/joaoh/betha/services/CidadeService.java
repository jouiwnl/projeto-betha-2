package com.joaoh.betha.services;

import com.joaoh.betha.domain.Cidade;
import com.joaoh.betha.domain.Equipamento;
import com.joaoh.betha.repositories.CidadeRepository;
import com.joaoh.betha.repositories.EquipamentoRepository;
import com.joaoh.betha.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;


    public List<Cidade> findAll() {
        return repo.findAll();
    }

    public Cidade find(Integer id) {
        Optional<Cidade> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Cidade insert(Cidade obj) {
        obj.setId(null);
        return repo.save(obj);
    }


}
