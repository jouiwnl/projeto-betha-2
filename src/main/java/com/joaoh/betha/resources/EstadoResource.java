package com.joaoh.betha.resources;

import java.util.List;

import com.joaoh.betha.domain.Cidade;
import com.joaoh.betha.domain.Estado;
import com.joaoh.betha.services.CidadeService;
import com.joaoh.betha.services.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    EstadoService service;

    @Autowired
    CidadeService cidadeService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Estado>> findAll() {
        List<Estado> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Estado> find (@PathVariable Integer id) {
        Estado obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
    public ResponseEntity<List<Cidade>> findAllCidades(@PathVariable Integer estadoId) {
        List<Cidade> obj = cidadeService.findByEstado(estadoId);
        return ResponseEntity.ok().body(obj);
     
    }


}
