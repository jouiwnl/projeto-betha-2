package com.joaoh.betha.services;

import java.util.List;

import com.joaoh.betha.domain.Cidade;
import com.joaoh.betha.repositories.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repo;


    public List<Cidade> findByEstado(Integer estadoId) {
		  return repo.findCidades(estadoId);
	}

}
