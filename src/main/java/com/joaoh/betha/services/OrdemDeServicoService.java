package com.joaoh.betha.services;

import com.joaoh.betha.domain.Cidade;
import com.joaoh.betha.domain.Equipamento;
import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.repositories.CidadeRepository;
import com.joaoh.betha.repositories.EquipamentoRepository;
import com.joaoh.betha.repositories.OrdemDeServicoRepository;
import com.joaoh.betha.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemDeServicoService {

    @Autowired
    private OrdemDeServicoRepository repo;


    public List<OrdemDeServico> findAll() {
        return repo.findAll();
    }

    public OrdemDeServico find(Integer id) {
        Optional<OrdemDeServico> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public OrdemDeServico insert(OrdemDeServico obj) {
        obj.setId(null);
        return repo.save(obj);
    }


}
