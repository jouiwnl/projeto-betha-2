package com.joaoh.betha.services;

import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.repositories.ClienteRepository;
import com.joaoh.betha.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;


    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Cliente insert(Cliente obj) {
        obj.setId(null);
        return repo.save(obj);
    }


}
