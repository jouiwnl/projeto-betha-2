package com.joaoh.betha.services;

import com.joaoh.betha.repositories.OrdemDeServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdemDeServicoService {

    @Autowired
    private OrdemDeServicoRepository repo;

}
